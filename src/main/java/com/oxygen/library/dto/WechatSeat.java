package com.oxygen.library.dto;

public class WechatSeat {
    private int num;
    private String src;

    public WechatSeat(int num, String src) {
        this.num = num;
        this.src = src;
    }

    public WechatSeat() {
    }

    public int getNum() {
        return this.num;
    }

    public String getSrc() {
        return this.src;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WechatSeat)) return false;
        final WechatSeat other = (WechatSeat) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getNum() != other.getNum()) return false;
        final Object this$src = this.getSrc();
        final Object other$src = other.getSrc();
        if (this$src == null ? other$src != null : !this$src.equals(other$src)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WechatSeat;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getNum();
        final Object $src = this.getSrc();
        result = result * PRIME + ($src == null ? 43 : $src.hashCode());
        return result;
    }

    public String toString() {
        return "WechatSeat(num=" + this.getNum() + ", src=" + this.getSrc() + ")";
    }
}
