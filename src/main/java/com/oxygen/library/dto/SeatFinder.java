package com.oxygen.library.dto;

public class SeatFinder {
    private int lid;
    private String position;

    public SeatFinder(int lid, String position) {
        this.lid = lid;
        this.position = position;
    }

    public SeatFinder() {
    }

    public int getLid() {
        return this.lid;
    }

    public String getPosition() {
        return this.position;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SeatFinder)) return false;
        final SeatFinder other = (SeatFinder) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getLid() != other.getLid()) return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SeatFinder;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getLid();
        final Object $position = this.getPosition();
        result = result * PRIME + ($position == null ? 43 : $position.hashCode());
        return result;
    }

    public String toString() {
        return "SeatFinder(lid=" + this.getLid() + ", position=" + this.getPosition() + ")";
    }
}
