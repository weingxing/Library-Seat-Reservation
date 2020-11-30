package com.oxygen.library.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxygen.library.config.CommonConfig;
import com.oxygen.library.dao.SysUserMapper;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.SysUser;
import com.oxygen.library.service.SysUserService;
import com.oxygen.library.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUserByUid(int uid) throws Exception {
        return sysUserMapper.selectByPrimaryKey(uid);
    }

    @Override
    public PageInfo<SysUser> getSysUserByPage(PageRequest request) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> content = sysUserMapper.selectAll();
        return new PageInfo<SysUser>(content);
    }

    @Override
    public boolean addSysUser(SysUser sysUser) throws Exception {
        return sysUserMapper.insert(sysUser) > 0;
    }

    @Override
    public boolean deleteSysUserByUid(int uid) throws Exception {
        return sysUserMapper.deleteByPrimaryKey(uid) > 0;
    }

    @Override
    public boolean updateSysUser(SysUser sysUser) throws Exception {
        String rawPassword = RSAUtil.decrypt(CommonConfig.privateKey, sysUser.getPassword());
        assert rawPassword != null;
        String password = new BCryptPasswordEncoder().encode(rawPassword);
        sysUser.setPassword(password);
        return sysUserMapper.updateByPrimaryKeySelective(sysUser) > 0;
    }
}
