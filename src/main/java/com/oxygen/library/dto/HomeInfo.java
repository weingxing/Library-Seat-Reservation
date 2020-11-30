package com.oxygen.library.dto;


/**
 * 后台管理菜单数据封装类
 */
public class HomeInfo {
    private String title;
    private String href;

    public HomeInfo(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public HomeInfo() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getHref() {
        return this.href;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof HomeInfo)) return false;
        final HomeInfo other = (HomeInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$href = this.getHref();
        final Object other$href = other.getHref();
        if (this$href == null ? other$href != null : !this$href.equals(other$href)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HomeInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $href = this.getHref();
        result = result * PRIME + ($href == null ? 43 : $href.hashCode());
        return result;
    }

    public String toString() {
        return "HomeInfo(title=" + this.getTitle() + ", href=" + this.getHref() + ")";
    }
}
