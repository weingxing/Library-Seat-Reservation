package com.oxygen.library.service;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.SysUser;

public interface SysUserService {

    public SysUser getSysUserByUid(int uid) throws Exception;

    public PageInfo<SysUser> getSysUserByPage(PageRequest request) throws Exception;

    public boolean addSysUser(SysUser sysUser) throws Exception;

    public boolean deleteSysUserByUid(int uid) throws Exception;

    public boolean updateSysUser(SysUser sysUser) throws Exception;
    
}
