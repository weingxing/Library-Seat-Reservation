package com.oxygen.library.dto;


import java.util.List;

/**
 * 后台管理菜单数据封装类
 */
public class MenuInfo {
    private String title;
    private String icon;
    private String href;
    private String target;
    private List<MenuInfo> child;

    public MenuInfo(String title, String icon, String href) {
        this.child = null;
        this.target = "_self";
        this.title = title;
        this.icon = icon;
        this.href = href;
    }

    public MenuInfo(String title, String icon, String href, String target, List<MenuInfo> child) {
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.target = target;
        this.child = child;
    }

    public MenuInfo() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getHref() {
        return this.href;
    }

    public String getTarget() {
        return this.target;
    }

    public List<MenuInfo> getChild() {
        return this.child;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setChild(List<MenuInfo> child) {
        this.child = child;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MenuInfo)) return false;
        final MenuInfo other = (MenuInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$icon = this.getIcon();
        final Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) return false;
        final Object this$href = this.getHref();
        final Object other$href = other.getHref();
        if (this$href == null ? other$href != null : !this$href.equals(other$href)) return false;
        final Object this$target = this.getTarget();
        final Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) return false;
        final Object this$child = this.getChild();
        final Object other$child = other.getChild();
        if (this$child == null ? other$child != null : !this$child.equals(other$child)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MenuInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $icon = this.getIcon();
        result = result * PRIME + ($icon == null ? 43 : $icon.hashCode());
        final Object $href = this.getHref();
        result = result * PRIME + ($href == null ? 43 : $href.hashCode());
        final Object $target = this.getTarget();
        result = result * PRIME + ($target == null ? 43 : $target.hashCode());
        final Object $child = this.getChild();
        result = result * PRIME + ($child == null ? 43 : $child.hashCode());
        return result;
    }

    public String toString() {
        return "MenuInfo(title=" + this.getTitle() + ", icon=" + this.getIcon() + ", href=" + this.getHref() + ", target=" + this.getTarget() + ", child=" + this.getChild() + ")";
    }
}
