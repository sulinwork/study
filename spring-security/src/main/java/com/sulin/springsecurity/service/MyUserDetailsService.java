package com.sulin.springsecurity.service;

import com.sulin.springsecurity.entity.MyUserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //我先造点假数据
        System.out.println("param->username:" + username);

        //加载基础用户信息
        final MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUsername(username);
        myUserDetails.setPassword(new BCryptPasswordEncoder().encode("123456"));
        myUserDetails.setEnabled(true);
        //加载角色 read databases; 角色是一个特殊权限 需要加入ROLE_前缀
        List<String> roles = new ArrayList<>();
        //加载用户的资源权限列表
        List<String> authorities = new ArrayList<>();
        roles = roles.stream().map(x -> "ROLE_" + x).collect(Collectors.toList());
        authorities.addAll(roles);

        myUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",authorities)));
        return myUserDetails;
    }
}
