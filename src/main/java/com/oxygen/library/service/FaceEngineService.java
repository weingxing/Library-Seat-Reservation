package com.oxygen.library.service;


import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import com.oxygen.library.entity.UserCompareInfo;


import java.util.List;


public interface FaceEngineService {

    List<FaceInfo> detectFaces(ImageInfo imageInfo);

    Float compareFace(ImageInfo imageInfo1, ImageInfo imageInfo2);

    byte[] extractFaceFeature(ImageInfo imageInfo, FaceInfo faceInfo);

    List<UserCompareInfo> faceRecognition(byte[] faceFeature, float passRate);
}
