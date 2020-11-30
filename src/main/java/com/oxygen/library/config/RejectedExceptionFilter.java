package com.oxygen.library.config;


import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 拦截处理地址包含"//"导致的SpringSecurity的RejectedException
 * @author oxygen
 * @since 2020/10/17
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RejectedExceptionFilter extends GenericFilterBean {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RejectedExceptionFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(req, res);
        } catch (RequestRejectedException e) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            log.info("request_rejected: ip={}, user_agent={}, 请求地址={}",
                    request.getRemoteHost(),
                    request.getHeader(HttpHeaders.USER_AGENT),
                    request.getRequestURL());
            // 重定向到404页面
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
