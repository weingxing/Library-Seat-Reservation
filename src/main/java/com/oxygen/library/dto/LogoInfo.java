package com.oxygen.library.dto;

/**
 * 后台管理菜单数据封装类
 */
public class LogoInfo {
    private String title;
    private String image;
    private String href;

    public LogoInfo(String title, String image, String href) {
        this.title = title;
        this.image = image;
        this.href = href;
    }

    public LogoInfo() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getImage() {
        return this.image;
    }

    public String getHref() {
        return this.href;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LogoInfo)) return false;
        final LogoInfo other = (LogoInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        final Object this$href = this.getHref();
        final Object other$href = other.getHref();
        if (this$href == null ? other$href != null : !this$href.equals(other$href)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LogoInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        final Object $href = this.getHref();
        result = result * PRIME + ($href == null ? 43 : $href.hashCode());
        return result;
    }

    public String toString() {
        return "LogoInfo(title=" + this.getTitle() + ", image=" + this.getImage() + ", href=" + this.getHref() + ")";
    }
}
