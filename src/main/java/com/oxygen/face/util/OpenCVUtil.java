package com.oxygen.face.util;

import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageFactory;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class OpenCVUtil {
    private static FaceUtil faceUtil = new FaceUtil();

    public static Mat getFace(Mat img) {
        try {
            BufferedImage image = mat2BI(img);
            byte[] data = ImageUtil.image2byte(image);
            List<FaceInfo> faceInfos = faceUtil.detectFaces(ImageFactory.getRGBData(data));
            if (faceInfos.size() > 0) {
                com.arcsoft.face.Rect rect = faceInfos.get(0).getRect();
                Imgproc.rectangle(img, new Point(rect.left, rect.top),
                        new Point(rect.left, rect.bottom),
                        new Scalar(0, 255, 0));
                Imgproc.rectangle(img, new Point(rect.left, rect.top),
                        new Point(rect.right, rect.top),
                        new Scalar(0, 255, 0));
                Imgproc.rectangle(img, new Point(rect.right, rect.top),
                        new Point(rect.right, rect.bottom),
                        new Scalar(0, 255, 0));
                Imgproc.rectangle(img, new Point(rect.left, rect.bottom),
                        new Point(rect.right, rect.bottom),
                        new Scalar(0, 255, 0));
            }
        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("It has some error:" + faceDetections);
        }
        return img;
    }

    public static BufferedImage mat2BI(Mat mat) {
        int dataSize = mat.cols() * mat.rows() * (int) mat.elemSize();
        byte[] data = new byte[dataSize];
        mat.get(0, 0, data);
        int type = mat.channels() == 1 ? BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_3BYTE_BGR;
        if (type == BufferedImage.TYPE_3BYTE_BGR) {
            for (int i = 0; i < dataSize; i += 3) {
                byte blue = data[i];
                data[i] = data[i + 2];
                data[i + 2] = blue;
            }
        }
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);
        return image;
    }

}
