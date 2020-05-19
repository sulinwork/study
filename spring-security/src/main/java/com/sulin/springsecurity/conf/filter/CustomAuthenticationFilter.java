package com.sulin.springsecurity.conf.filter;

import cn.hutool.json.JSONUtil;
import com.sulin.springsecurity.utils.Api;
import com.sulin.springsecurity.utils.ResJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;


/**
 * @author sulin
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) ||
                request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)) {

            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream inputStream = request.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            ) {
                StringBuffer sb = new StringBuffer();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                final Map map = JSONUtil.toBean(sb.toString(), Map.class);
                authRequest = new UsernamePasswordAuthenticationToken(map.get(this.getUsernameParameter()), map.get(this.getPasswordParameter()));
            } catch (IOException e) {
                e.printStackTrace();
                authRequest = new UsernamePasswordAuthenticationToken("", "");
            }
            return this.getAuthenticationManager().authenticate(authRequest);
        } else {
            return super.attemptAuthentication(request, response);
        }
    }


//    @Bean
//    public CustomAuthenticationFilter customAuthenticationFilter() {
//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
////        customAuthenticationFilter.setPasswordParameter("password");
////        customAuthenticationFilter.setUsernameParameter("name");
////        customAuthenticationFilter.setAuthenticationSuccessHandler((req, res, auth) -> {
////            Api<Object> success = Api.builder().message("login success").code(200).build();
////            ResJsonUtil.write(res, success);
////        });
////        customAuthenticationFilter.setAuthenticationFailureHandler((req, res, authEx) -> {
////            Api<Object> success = Api.builder().message(authEx.getMessage()).code(401).build();
////            ResJsonUtil.write(res, success);
////        });
//        customAuthenticationFilter.setAuthenticationManager(getAuthenticationManager());
//        return customAuthenticationFilter;
//    }
}
