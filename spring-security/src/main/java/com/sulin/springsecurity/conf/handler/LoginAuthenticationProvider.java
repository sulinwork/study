package com.sulin.springsecurity.conf.handler;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sulin
 */
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取前端传入的name 和 password
        String name = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        if (name.equals("admin") && password.equals("123456")) {
            ArrayList<GrantedAuthority> mList = new ArrayList<>();
            mList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new UsernamePasswordAuthenticationToken(name, password, mList);
        }
        throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
