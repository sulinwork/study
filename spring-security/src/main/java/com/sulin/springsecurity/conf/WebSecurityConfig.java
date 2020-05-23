package com.sulin.springsecurity.conf;

import com.sulin.springsecurity.conf.filter.CustomAuthenticationFilter;
import com.sulin.springsecurity.conf.filter.JwtTokenAuthenticationFilter;
import com.sulin.springsecurity.conf.handler.LoginAuthenticationProvider;
import com.sulin.springsecurity.conf.handler.UserAuthAccessDeniedHandler;
import com.sulin.springsecurity.conf.handler.UserAuthenticationEntryPointHandler;
import com.sulin.springsecurity.service.MyUserDetailsService;
import com.sulin.springsecurity.utils.Api;
import com.sulin.springsecurity.utils.ResJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sulin
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public JwtTokenAuthenticationFilter getJwtTokenAuthenticationFilter() {
//        return new JwtTokenAuthenticationFilter();
//    }

    @Autowired
    JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/orders/test", "/coupons/test").hasAnyRole("operator", "admin")
//                .antMatchers("/login").permitAll()
//                .antMatchers("/**").hasAnyRole("admin")
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler((req, res, accessEx) -> {
//                    final Api api = Api.builder().code(401).message("你的权限不足").build();
//                    ResJsonUtil.write(res, api);
//                })
//                .and()
//                .formLogin().disable()
//                .cors()
//                .and()
//                .csrf().disable();
//
//        http.sessionManagement().disable();
//        http.headers().cacheControl();
//        http.addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/doLogin").permitAll()
                .antMatchers("/index").authenticated()
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .successHandler((req, res, auth) -> {
                    res.getWriter().write("success");
                })
                .failureHandler((req, res, ex) -> {
                    res.getWriter().write("failure");
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req, res, ex) -> {
                    res.getWriter().write("no login");
                })
                .accessDeniedHandler((req, res, ex) -> {
                    res.getWriter().write("no assess");
                })
                .and()
                .cors().and().csrf().disable();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl("/login.html")
                .sessionFixation().migrateSession()
                .maximumSessions(1) //只允许一个用户登录
                .maxSessionsPreventsLogin(false)//同一个账号两个地方登录时 踢出第一个账号
                .expiredSessionStrategy(new MyExpiredSessionStrategy());
    }


    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存模拟用户
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser("sulin")
//                .password(bCryptPasswordEncoder.encode("123456"))
//                .roles("admin")
//                .and()
//                .passwordEncoder(bCryptPasswordEncoder);


        auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}
