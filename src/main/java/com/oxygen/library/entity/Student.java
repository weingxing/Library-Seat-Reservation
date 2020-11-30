package com.oxygen.library.entity;

public class Student {
    private Integer stuId;

    private String sname;

    private String openid;

    private Integer reputation;

    private String status;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String toString() {
        return "Student(stuId=" + this.getStuId() + ", sname=" + this.getSname() + ", openid=" + this.getOpenid() + ", reputation=" + this.getReputation() + ", status=" + this.getStatus() + ")";
    }
}