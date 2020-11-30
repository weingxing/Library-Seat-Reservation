package com.oxygen.library.dto;


public class ChooseSeatInfo {
    private Integer cid;

    private String SeatPos;

    private String libraryName;

    private String name;

    private String stuId;

    private String date;

    private String hour;

    private String leaveNum;

    private String leaveDate;

    private String enterDate;

    public ChooseSeatInfo(Integer cid, String SeatPos, String libraryName, String name, String stuId, String date, String hour, String leaveNum, String leaveDate, String enterDate) {
        this.cid = cid;
        this.SeatPos = SeatPos;
        this.libraryName = libraryName;
        this.name = name;
        this.stuId = stuId;
        this.date = date;
        this.hour = hour;
        this.leaveNum = leaveNum;
        this.leaveDate = leaveDate;
        this.enterDate = enterDate;
    }

    public ChooseSeatInfo() {
    }

    public Integer getCid() {
        return this.cid;
    }

    public String getSeatPos() {
        return this.SeatPos;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getName() {
        return this.name;
    }

    public String getStuId() {
        return this.stuId;
    }

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public String getLeaveNum() {
        return this.leaveNum;
    }

    public String getLeaveDate() {
        return this.leaveDate;
    }

    public String getEnterDate() {
        return this.enterDate;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setSeatPos(String SeatPos) {
        this.SeatPos = SeatPos;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setLeaveNum(String leaveNum) {
        this.leaveNum = leaveNum;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChooseSeatInfo)) return false;
        final ChooseSeatInfo other = (ChooseSeatInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$cid = this.getCid();
        final Object other$cid = other.getCid();
        if (this$cid == null ? other$cid != null : !this$cid.equals(other$cid)) return false;
        final Object this$SeatPos = this.getSeatPos();
        final Object other$SeatPos = other.getSeatPos();
        if (this$SeatPos == null ? other$SeatPos != null : !this$SeatPos.equals(other$SeatPos)) return false;
        final Object this$libraryName = this.getLibraryName();
        final Object other$libraryName = other.getLibraryName();
        if (this$libraryName == null ? other$libraryName != null : !this$libraryName.equals(other$libraryName))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$stuId = this.getStuId();
        final Object other$stuId = other.getStuId();
        if (this$stuId == null ? other$stuId != null : !this$stuId.equals(other$stuId)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$hour = this.getHour();
        final Object other$hour = other.getHour();
        if (this$hour == null ? other$hour != null : !this$hour.equals(other$hour)) return false;
        final Object this$leaveNum = this.getLeaveNum();
        final Object other$leaveNum = other.getLeaveNum();
        if (this$leaveNum == null ? other$leaveNum != null : !this$leaveNum.equals(other$leaveNum)) return false;
        final Object this$leaveDate = this.getLeaveDate();
        final Object other$leaveDate = other.getLeaveDate();
        if (this$leaveDate == null ? other$leaveDate != null : !this$leaveDate.equals(other$leaveDate)) return false;
        final Object this$enterDate = this.getEnterDate();
        final Object other$enterDate = other.getEnterDate();
        if (this$enterDate == null ? other$enterDate != null : !this$enterDate.equals(other$enterDate)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChooseSeatInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $cid = this.getCid();
        result = result * PRIME + ($cid == null ? 43 : $cid.hashCode());
        final Object $SeatPos = this.getSeatPos();
        result = result * PRIME + ($SeatPos == null ? 43 : $SeatPos.hashCode());
        final Object $libraryName = this.getLibraryName();
        result = result * PRIME + ($libraryName == null ? 43 : $libraryName.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $stuId = this.getStuId();
        result = result * PRIME + ($stuId == null ? 43 : $stuId.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $hour = this.getHour();
        result = result * PRIME + ($hour == null ? 43 : $hour.hashCode());
        final Object $leaveNum = this.getLeaveNum();
        result = result * PRIME + ($leaveNum == null ? 43 : $leaveNum.hashCode());
        final Object $leaveDate = this.getLeaveDate();
        result = result * PRIME + ($leaveDate == null ? 43 : $leaveDate.hashCode());
        final Object $enterDate = this.getEnterDate();
        result = result * PRIME + ($enterDate == null ? 43 : $enterDate.hashCode());
        return result;
    }

    public String toString() {
        return "ChooseSeatInfo(cid=" + this.getCid() + ", SeatPos=" + this.getSeatPos() + ", libraryName=" + this.getLibraryName() + ", name=" + this.getName() + ", stuId=" + this.getStuId() + ", date=" + this.getDate() + ", hour=" + this.getHour() + ", leaveNum=" + this.getLeaveNum() + ", leaveDate=" + this.getLeaveDate() + ", enterDate=" + this.getEnterDate() + ")";
    }
}
