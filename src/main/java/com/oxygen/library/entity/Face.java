package com.oxygen.library.entity;

public class Face {
    private Integer stuId;

    private byte[] faceId;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public byte[] getFaceId() {
        return faceId;
    }

    public void setFaceId(byte[] faceId) {
        this.faceId = faceId;
    }
}