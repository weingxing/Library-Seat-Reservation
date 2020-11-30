package com.oxygen.library.dto;


public class SeatInfo {
    private Integer sid;

    private String libraryName;

    private String position;

    private String status;

    private String available;

    public SeatInfo(Integer sid, String libraryName, String position, String status, String available) {
        this.sid = sid;
        this.libraryName = libraryName;
        this.position = position;
        this.status = status;
        this.available = available;
    }

    public SeatInfo() {
    }

    public Integer getSid() {
        return this.sid;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getPosition() {
        return this.position;
    }

    public String getStatus() {
        return this.status;
    }

    public String getAvailable() {
        return this.available;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SeatInfo)) return false;
        final SeatInfo other = (SeatInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$sid = this.getSid();
        final Object other$sid = other.getSid();
        if (this$sid == null ? other$sid != null : !this$sid.equals(other$sid)) return false;
        final Object this$libraryName = this.getLibraryName();
        final Object other$libraryName = other.getLibraryName();
        if (this$libraryName == null ? other$libraryName != null : !this$libraryName.equals(other$libraryName))
            return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$available = this.getAvailable();
        final Object other$available = other.getAvailable();
        if (this$available == null ? other$available != null : !this$available.equals(other$available)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SeatInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $sid = this.getSid();
        result = result * PRIME + ($sid == null ? 43 : $sid.hashCode());
        final Object $libraryName = this.getLibraryName();
        result = result * PRIME + ($libraryName == null ? 43 : $libraryName.hashCode());
        final Object $position = this.getPosition();
        result = result * PRIME + ($position == null ? 43 : $position.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $available = this.getAvailable();
        result = result * PRIME + ($available == null ? 43 : $available.hashCode());
        return result;
    }

    public String toString() {
        return "SeatInfo(sid=" + this.getSid() + ", libraryName=" + this.getLibraryName() + ", position=" + this.getPosition() + ", status=" + this.getStatus() + ", available=" + this.getAvailable() + ")";
    }
}
