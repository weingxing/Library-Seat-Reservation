package com.oxygen.library.entity;

public class Library {
    private Integer lid;

    private String libraryName;

    private Integer seatsNum;

    private String status;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName == null ? null : libraryName.trim();
    }

    public Integer getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(Integer seatsNum) {
        this.seatsNum = seatsNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String toString() {
        return "Library(lid=" + this.getLid() + ", libraryName=" + this.getLibraryName() + ", seatsNum=" + this.getSeatsNum() + ", status=" + this.getStatus() + ")";
    }
}