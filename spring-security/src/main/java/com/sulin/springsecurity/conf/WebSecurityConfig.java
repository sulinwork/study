package com.sulin.springsecurity.conf;

import com.sulin.springsecurity.conf.filter.CustomAuthenticationFilter;
import com.sulin.springsecurity.conf.filter.JwtTokenAuthenticationFilter;
import com.sulin.springsecurity.conf.handler.LoginAuthenticationProvider;
import com.sulin.springsecurity.conf.handler.UserAuthAccessDeniedHandler;
import com.sulin.springsecurity.conf.handler.UserAuthenticationEntryPointHandler;
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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public JwtTokenAuthenticationFilter getJwtTokenAuthenticationFilter() {
//        return new JwtTokenAuthenticationFilter();
//    }

    @Autowired
    JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/orders/test", "/coupons/test").hasAnyRole("operator", "admin")
                .antMatchers("/**").hasAnyRole("admin")
                .and()
                .exceptionHandling()
                .accessDeniedHandler((req, res, accessEx) -> {
                    final Api api = Api.builder().code(401).message("你的权限不足").build();
                    ResJsonUtil.write(res, api);
                })
                .and()
                .formLogin().disable()
                .cors()
                .and()
                .csrf().disable();

        http.sessionManagement().disable();
        http.headers().cacheControl();
        http.addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
