package com.oxygen.library.dto;

import java.util.List;

/**
 * 后台管理菜单数据封装类
 */
public class Menu {
    private HomeInfo homeInfo;
    private LogoInfo logoInfo;
    private List<MenuInfo> menuInfo;

    public Menu(HomeInfo homeInfo, LogoInfo logoInfo, List<MenuInfo> menuInfo) {
        this.homeInfo = homeInfo;
        this.logoInfo = logoInfo;
        this.menuInfo = menuInfo;
    }

    public Menu() {
    }

    public HomeInfo getHomeInfo() {
        return this.homeInfo;
    }

    public LogoInfo getLogoInfo() {
        return this.logoInfo;
    }

    public List<MenuInfo> getMenuInfo() {
        return this.menuInfo;
    }

    public void setHomeInfo(HomeInfo homeInfo) {
        this.homeInfo = homeInfo;
    }

    public void setLogoInfo(LogoInfo logoInfo) {
        this.logoInfo = logoInfo;
    }

    public void setMenuInfo(List<MenuInfo> menuInfo) {
        this.menuInfo = menuInfo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Menu)) return false;
        final Menu other = (Menu) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$homeInfo = this.getHomeInfo();
        final Object other$homeInfo = other.getHomeInfo();
        if (this$homeInfo == null ? other$homeInfo != null : !this$homeInfo.equals(other$homeInfo)) return false;
        final Object this$logoInfo = this.getLogoInfo();
        final Object other$logoInfo = other.getLogoInfo();
        if (this$logoInfo == null ? other$logoInfo != null : !this$logoInfo.equals(other$logoInfo)) return false;
        final Object this$menuInfo = this.getMenuInfo();
        final Object other$menuInfo = other.getMenuInfo();
        if (this$menuInfo == null ? other$menuInfo != null : !this$menuInfo.equals(other$menuInfo)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Menu;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $homeInfo = this.getHomeInfo();
        result = result * PRIME + ($homeInfo == null ? 43 : $homeInfo.hashCode());
        final Object $logoInfo = this.getLogoInfo();
        result = result * PRIME + ($logoInfo == null ? 43 : $logoInfo.hashCode());
        final Object $menuInfo = this.getMenuInfo();
        result = result * PRIME + ($menuInfo == null ? 43 : $menuInfo.hashCode());
        return result;
    }

    public String toString() {
        return "Menu(homeInfo=" + this.getHomeInfo() + ", logoInfo=" + this.getLogoInfo() + ", menuInfo=" + this.getMenuInfo() + ")";
    }
}
