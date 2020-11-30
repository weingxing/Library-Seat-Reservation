package com.oxygen.library.entity;

public class ChooseSeat {
    private Integer cid;

    private Integer sid;

    private Integer stuId;

    private String date;

    private String hour;

    private String leaveNum;

    private String leaveDate;

    private String enterDate;

    private String pause;

    public String getPause() {
        return pause;
    }

    public void setPause(String pause) {
        this.pause = pause;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour == null ? null : hour.trim();
    }

    public String getLeaveNum() {
        return leaveNum;
    }

    public void setLeaveNum(String leaveNum) {
        this.leaveNum = leaveNum == null ? null : leaveNum.trim();
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate == null ? null : leaveDate.trim();
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate == null ? null : enterDate.trim();
    }

    public String toString() {
        return "ChooseSeat(cid=" + this.getCid() + ", sid=" + this.getSid() + ", stuId=" + this.getStuId() + ", date=" + this.getDate() + ", hour=" + this.getHour() + ", leaveNum=" + this.getLeaveNum() + ", leaveDate=" + this.getLeaveDate() + ", enterDate=" + this.getEnterDate() + ", pause=" + this.getPause() + ")";
    }
}