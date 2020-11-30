package com.oxygen.library.entity;

public class Seat {
    private Integer sid;

    private Integer lid;

    private String position;

    private String status;

    private String available;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getPositio() {
        return position;
    }

    public void setPositio(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    public String toString() {
        return "Seat(sid=" + this.getSid() + ", lid=" + this.getLid() + ", positio=" + this.getPositio() + ", status=" + this.getStatus() + ", available=" + this.getAvailable() + ")";
    }
}