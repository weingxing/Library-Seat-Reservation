package com.oxygen.library.dto;

import java.util.List;

public class LayuiPage {
    private int code;
    private String msg;
    private long count;
    private List<?> data;

    public LayuiPage(int code, String msg, long count, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public LayuiPage() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getCount() {
        return this.count;
    }

    public List<?> getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LayuiPage)) return false;
        final LayuiPage other = (LayuiPage) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getCode() != other.getCode()) return false;
        final Object this$msg = this.getMsg();
        final Object other$msg = other.getMsg();
        if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) return false;
        if (this.getCount() != other.getCount()) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LayuiPage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getCode();
        final Object $msg = this.getMsg();
        result = result * PRIME + ($msg == null ? 43 : $msg.hashCode());
        final long $count = this.getCount();
        result = result * PRIME + (int) ($count >>> 32 ^ $count);
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "LayuiPage(code=" + this.getCode() + ", msg=" + this.getMsg() + ", count=" + this.getCount() + ", data=" + this.getData() + ")";
    }
}
