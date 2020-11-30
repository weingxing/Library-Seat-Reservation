package com.oxygen.library.dto;

/**
 * 分页请求封装类
 */
public class PageRequest {
    //  当前页码
    private int pageNum;
    //  每页数量
    private int pageSize;

    public PageRequest(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageRequest() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PageRequest)) return false;
        final PageRequest other = (PageRequest) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPageNum() != other.getPageNum()) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPageNum();
        result = result * PRIME + this.getPageSize();
        return result;
    }

    public String toString() {
        return "PageRequest(pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ")";
    }
}
