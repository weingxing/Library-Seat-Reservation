package com.oxygen.face.util;

import com.alibaba.fastjson.JSON;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.oxygen.library.controller.WechatController;
import com.oxygen.library.dto.ChooseSeatInfo;
import com.oxygen.library.dto.Response;
import com.oxygen.library.entity.ChooseSeat;
import com.oxygen.library.entity.UserCompareInfo;
import com.oxygen.library.util.WechatUtil;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

/**
 * @author XiaoHui
 */
public class ShowImgUtil extends JPanel {
    public static BufferedImage mImg;
    private VideoCapture capture;
    private JFrame frame;
    private FaceUtil faceEngineService = new FaceUtil();

    /**
     * 运行窗体并进行显示
     */
    public void run() {
        try {
            this.init();

            Mat temp = new Mat();
            Mat capImg = new Mat();

            while (this.frame.isShowing()) {
                this.capture.read(capImg);
                // temp的图片是灰色
                Imgproc.cvtColor(capImg, temp, Imgproc.COLOR_RGB2GRAY);
                // 将图片进行识别
                mImg = OpenCVUtil.mat2BI(OpenCVUtil.getFace(capImg));
                this.repaint();
            }
            capture.release();
            frame.dispose();
        } catch (Exception e) {
            // do nothing
        }
    }

    /**
     * 初始化摄像头和lib
     */
    private void init() {
        // 加载dll文件
        System.loadLibrary("opencv_java430");

        capture = new VideoCapture();
        capture.open(0);
        int height = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
        int width = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);

        if (height == 0 || width == 0) {
            System.out.println("摄像头打开失败");
        }

        // 创建页面
        JLabel label = new JLabel("");
        label.setFont(new Font("SimHei", 0, 40));

        frame = new JFrame("人脸识别");
        this.setSize(width + frame.getInsets().left + frame.getInsets().right,
                height + frame.getInsets().top + frame.getInsets().bottom);
//        label.setLocation(100,100);
        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,
                this, label);
        frame.setDefaultCloseOperation(2);
        left.resetToPreferredSizes();
        left.setOneTouchExpandable(true);
        left.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                left.setDividerLocation(0.85);
            }
        });
        frame.add(left);
        frame.setVisible(true);
        frame.pack();
        frame.setSize(width + frame.getInsets().left + frame.getInsets().right,
                100 + height + frame.getInsets().top + frame.getInsets().bottom);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 重绘Panel
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.repaint();

        if (mImg != null) {
            g.drawImage(mImg, 0, 0, mImg.getWidth(), mImg.getHeight(), this);
            JLabel component = (JLabel) this.getParent().getComponents()[1];
            ImageInfo imageInfo = ImageFactory.getRGBData(ImageUtil.image2byte(mImg));
            List<FaceInfo> faceInfoList = faceEngineService.detectFaces(imageInfo);
            if (faceInfoList.size() > 0) {
                FaceInfo faceInfo = faceInfoList.get(0);
                byte[] feature = faceEngineService.extractFaceFeature(imageInfo, faceInfo);
                List<UserCompareInfo> compareInfos = faceEngineService.faceRecognition(feature,
                        (float) 0.8);
//                System.out.println(compareInfos);
                Response response = null;
                try {
                    String url = "http://127.0.0.1:8081/wechat/enter?stuId="
                            + compareInfos.get(0).getName();
                    response = JSON.parseObject(WechatUtil.sendGet(url), Response.class);
                    if (response.getContent().toString().contains("{")) {
                        ChooseSeatInfo chooseSeatInfo = JSON.parseObject(response.getContent().toString(),
                                ChooseSeatInfo.class);
//                    System.out.println(chooseSeatInfo);
                        String text = chooseSeatInfo.getLibraryName() + " " +
                                chooseSeatInfo.getCid() + "号(" +
                                chooseSeatInfo.getSeatPos() + ")";
                        component.setText(text);
                    } else {
                        component.setText(response.getContent().toString());
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        }
    }
}
