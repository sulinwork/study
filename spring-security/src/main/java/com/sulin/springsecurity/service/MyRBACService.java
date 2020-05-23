package com.sulin.springsecurity.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sulin
 */
@Service("rbacService")
public class MyRBACService {

    /**
     * spring security提供的工具类
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断某用户是否具有改request资源的权限
     *
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        final Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            final String username = userDetails.getUsername();
            //通过username 查询数据库的对应的资源权限
            //read database;
            List<String> urls = null;
            return urls.stream().anyMatch(url -> antPathMatcher.match(url, request.getRequestURI()));
        }
        return false;
    }
}
