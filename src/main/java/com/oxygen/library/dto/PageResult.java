package com.oxygen.library.dto;

import java.util.List;

/**
 * 分页结果封装类
 */
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> data;

    public PageResult(int pageNum, int pageSize, long totalSize, int totalPages, List<?> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.totalPages = totalPages;
        this.data = data;
    }

    public PageResult() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public List<?> getData() {
        return this.data;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PageResult)) return false;
        final PageResult other = (PageResult) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPageNum() != other.getPageNum()) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        if (this.getTotalSize() != other.getTotalSize()) return false;
        if (this.getTotalPages() != other.getTotalPages()) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageResult;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPageNum();
        result = result * PRIME + this.getPageSize();
        final long $totalSize = this.getTotalSize();
        result = result * PRIME + (int) ($totalSize >>> 32 ^ $totalSize);
        result = result * PRIME + this.getTotalPages();
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "PageResult(pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", totalSize=" + this.getTotalSize() + ", totalPages=" + this.getTotalPages() + ", data=" + this.getData() + ")";
    }
}