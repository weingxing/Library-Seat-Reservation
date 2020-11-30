package com.oxygen.library.service;

import com.oxygen.library.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * SpringSecurity 服务类接口
 * @author Oxygen
 * @since 2020/09/27
 */
public interface SecurityService extends UserDetailsService {

    @Override
    /**
     * 继承自 UserDetailsService ，从数据库查询用户供SpringSecurity登录验证
     */
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    /**
     * 取得用户信息（用户名等）
     * @return
     * @throws Exception
     */
    SysUser getUserInfo() throws Exception;
}
