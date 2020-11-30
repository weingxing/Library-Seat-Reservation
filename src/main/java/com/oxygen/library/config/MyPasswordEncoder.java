package com.oxygen.library.config;

import com.oxygen.library.util.RSAUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * SpringSecurity 密码编码配置类
 * @author oxygen
 * @since 2020/03/12
 */
public class MyPasswordEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    // 对密码进行编码
    public String encode(CharSequence charSequence) {
        return encoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        // 对前端传来的RSA加密后的密码解密
        charSequence = RSAUtil.decrypt(CommonConfig.privateKey, charSequence.toString());
        // 返回匹配结果
        return encoder.matches(charSequence, s);
    }
}
