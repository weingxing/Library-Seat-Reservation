package com.oxygen.face.util;

import cn.hutool.core.collection.CollectionUtil;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.toolkit.ImageInfo;
import com.google.common.collect.Lists;
import com.oxygen.library.entity.Face;
import com.oxygen.library.entity.UserCompareInfo;
import com.oxygen.library.enums.ErrorCodeEnum;
import com.oxygen.library.exception.BusinessException;
import com.oxygen.library.factory.FaceEngineFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;


import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


public class FaceUtil {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FaceUtil.class);

    public String sdkLibPath = "D:/libs/WIN64";
    public String appId = "53LZk3a9LTATb2vVrtobjAGo6EdboSe2ZzTCSegJ9XV5";
    public String sdkKey = "GEjXjRw3FR4SubQvGsRnWF6zdixsuAUJ1F1PW7BNK9bG";


    public Integer detectPooSize = 5;
    public Integer comparePooSize = 5;

    private ExecutorService compareExecutorService;

    //通用人脸识别引擎池
    private GenericObjectPool<FaceEngine> faceEngineGeneralPool;

    //人脸比对引擎池
    private GenericObjectPool<FaceEngine> faceEngineComparePool;

    private List<Face> userInfoList;

    public FaceUtil() {
        this.init();
        this.userInfoList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM face";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Face face = new Face();
                face.setStuId(rs.getInt("stu_id"));
                face.setFaceId(rs.getBytes("face_id"));
                if (face.getFaceId() != null)
                    userInfoList.add(face);
            }
//            this.userInfoList = null;
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        GenericObjectPoolConfig detectPoolConfig = new GenericObjectPoolConfig();
        detectPoolConfig.setMaxIdle(detectPooSize);
        detectPoolConfig.setMaxTotal(detectPooSize);
        detectPoolConfig.setMinIdle(detectPooSize);
        detectPoolConfig.setLifo(false);
        EngineConfiguration detectCfg = new EngineConfiguration();
        FunctionConfiguration detectFunctionCfg = new FunctionConfiguration();
        // 开启人脸检测功能
        detectFunctionCfg.setSupportFaceDetect(true);
        // 开启人脸识别功能
        detectFunctionCfg.setSupportFaceRecognition(true);
        // 开启年龄检测功能
        detectFunctionCfg.setSupportAge(true);
        // 开启性别检测功能
        detectFunctionCfg.setSupportGender(true);
        // 开启活体检测功能
        detectFunctionCfg.setSupportLiveness(true);
        detectCfg.setFunctionConfiguration(detectFunctionCfg);
        // 图片检测模式，连续帧的视频流图片，VIDEO模式
        detectCfg.setDetectMode(DetectMode.ASF_DETECT_MODE_VIDEO);
        // 人脸旋转角度
        detectCfg.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);
        // 底层库算法对象池
        faceEngineGeneralPool = new GenericObjectPool(
                new FaceEngineFactory(sdkLibPath, appId, sdkKey, null, detectCfg),
                detectPoolConfig);

        // 初始化特征比较线程池
        GenericObjectPoolConfig comparePoolConfig = new GenericObjectPoolConfig();
        comparePoolConfig.setMaxIdle(comparePooSize);
        comparePoolConfig.setMaxTotal(comparePooSize);
        comparePoolConfig.setMinIdle(comparePooSize);
        comparePoolConfig.setLifo(false);
        EngineConfiguration compareCfg = new EngineConfiguration();
        FunctionConfiguration compareFunctionCfg = new FunctionConfiguration();
        // 开启人脸识别功能
        compareFunctionCfg.setSupportFaceRecognition(true);
        compareCfg.setFunctionConfiguration(compareFunctionCfg);
        // 图片检测模式，连续帧的视频流图片，VIDEO模式
        compareCfg.setDetectMode(DetectMode.ASF_DETECT_MODE_VIDEO);
        // 人脸旋转角度
        compareCfg.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);
        // 底层库算法对象池
        faceEngineComparePool = new GenericObjectPool(new FaceEngineFactory(sdkLibPath, appId, sdkKey, null,
                compareCfg), comparePoolConfig);
        compareExecutorService = Executors.newFixedThreadPool(comparePooSize);
    }


    public List<FaceInfo> detectFaces(ImageInfo imageInfo) {
        FaceEngine faceEngine = null;
        try {
            faceEngine = faceEngineGeneralPool.borrowObject();
            if (faceEngine == null) {
                throw new BusinessException(ErrorCodeEnum.FAIL, "获取引擎失败");
            }

            // 人脸检测得到人脸列表
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            // 人脸检测
            int errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(),
                    imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
            if (errorCode == 0) {
                return faceInfoList;
            } else {
                log.error("人脸检测失败，errorCode：" + errorCode);
            }
        } catch (Exception e) {
            log.info("", e);
        } finally {
            if (faceEngine != null) {
                //释放引擎对象
                faceEngineGeneralPool.returnObject(faceEngine);
            }
        }
        return null;
    }



    public Float compareFace(ImageInfo imageInfo1, ImageInfo imageInfo2) {
        List<FaceInfo> faceInfoList1 = detectFaces(imageInfo1);
        List<FaceInfo> faceInfoList2 = detectFaces(imageInfo2);

        if (CollectionUtil.isEmpty(faceInfoList1) || CollectionUtil.isEmpty(faceInfoList2)) {
            throw new BusinessException(ErrorCodeEnum.FAIL,"未检测到人脸");
        }

        byte[] feature1 = extractFaceFeature(imageInfo1, faceInfoList1.get(0));
        byte[] feature2 = extractFaceFeature(imageInfo2, faceInfoList2.get(0));

        FaceEngine faceEngine = null;
        try {
            faceEngine = faceEngineGeneralPool.borrowObject();
            if (faceEngine == null) {
                throw new BusinessException(ErrorCodeEnum.FAIL, "获取引擎失败");
            }

            FaceFeature faceFeature1 = new FaceFeature();
            faceFeature1.setFeatureData(feature1);
            FaceFeature faceFeature2 = new FaceFeature();
            faceFeature2.setFeatureData(feature2);
            //提取人脸特征
            FaceSimilar faceSimilar = new FaceSimilar();
//            System.out.println(Arrays.toString(faceFeature1.getFeatureData()));
            int errorCode = faceEngine.compareFaceFeature(faceFeature1, faceFeature2, faceSimilar);
            if (errorCode == 0) {
                return faceSimilar.getScore();
            } else {
                log.error("特征提取失败，errorCode：" + errorCode);
            }
        } catch (Exception e) {
            log.info("", e);
        } finally {
            if (faceEngine != null) {
                //释放引擎对象
                faceEngineGeneralPool.returnObject(faceEngine);
            }
        }
        return null;
    }


    /**
     * 人脸特征
     *
     * @param imageInfo
     * @return
     */
    public byte[] extractFaceFeature(ImageInfo imageInfo, FaceInfo faceInfo) {
        FaceEngine faceEngine = null;
        try {
            faceEngine = faceEngineGeneralPool.borrowObject();
            if (faceEngine == null) {
                throw new BusinessException(ErrorCodeEnum.FAIL, "获取引擎失败");
            }
            FaceFeature faceFeature = new FaceFeature();
            //提取人脸特征
            int errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(),
                    imageInfo.getWidth(), imageInfo.getHeight(),
                    imageInfo.getImageFormat(), faceInfo, faceFeature);
            if (errorCode == 0) {
                return faceFeature.getFeatureData();
            } else {
                log.error("特征提取失败，errorCode：" + errorCode);
            }
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (faceEngine != null) {
                //释放引擎对象
                faceEngineGeneralPool.returnObject(faceEngine);
            }
        }
        return null;
    }


    public List<UserCompareInfo> faceRecognition(byte[] faceFeature, float passRate) {
        // 识别到的人脸列表
        List<UserCompareInfo> resultUserInfoList = Lists.newLinkedList();

//        List<Face> userInfoList = faceMapper.selectAll();
        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature);
        // 分成1000一组，多线程处理
        List<List<Face>> faceUserInfoPartList = Lists.partition(userInfoList, 1000);
        CompletionService<List<UserCompareInfo>> completionService = new
                ExecutorCompletionService(compareExecutorService);
        for (List<Face> part : faceUserInfoPartList) {
            completionService.submit(new CompareFaceTask(part, targetFaceFeature, passRate));
        }
        for (int i = 0; i < faceUserInfoPartList.size(); i++) {
            List<UserCompareInfo> faceUserInfoList = null;
            try {
                faceUserInfoList = completionService.take().get();
            } catch (InterruptedException | ExecutionException e) {
            }
            if (CollectionUtil.isNotEmpty(userInfoList)) {
                resultUserInfoList.addAll(faceUserInfoList);
            }
        }

        resultUserInfoList.sort((h1, h2) -> h2.getSimilar().compareTo(h1.getSimilar()));//从大到小排序

        return resultUserInfoList;
    }


    private class CompareFaceTask implements Callable<List<UserCompareInfo>> {

        private List<Face> userInfoList;
        private FaceFeature targetFaceFeature;
        private float passRate;


        public CompareFaceTask(List<Face> faceInfoList, FaceFeature targetFaceFeature, float passRate) {
            this.userInfoList = faceInfoList;
            this.targetFaceFeature = targetFaceFeature;
            this.passRate = passRate;
        }

        @Override
        public List<UserCompareInfo> call() throws Exception {
            FaceEngine faceEngine = null;
            List<UserCompareInfo> resultUserInfoList = Lists.newLinkedList();//识别到的人脸列表
            try {
                faceEngine = faceEngineComparePool.borrowObject();
                for (Face userInfo : userInfoList) {
                    FaceFeature sourceFaceFeature = new FaceFeature();
                    sourceFaceFeature.setFeatureData(userInfo.getFaceId());
                    FaceSimilar faceSimilar = new FaceSimilar();
                    faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
                    if (faceSimilar.getScore() > passRate) {
                        // 相似值大于配置预期，加入到识别到人脸的列表
                        UserCompareInfo info = new UserCompareInfo();
                        info.setName(String.valueOf(userInfo.getStuId()));
                        info.setSimilar(faceSimilar.getScore());
                        resultUserInfoList.add(info);
                    }
                }
            } catch (Exception e) {
                log.error("", e);
            } finally {
                if (faceEngine != null) {
                    faceEngineComparePool.returnObject(faceEngine);
                }
            }
            return resultUserInfoList;
        }
    }
}
