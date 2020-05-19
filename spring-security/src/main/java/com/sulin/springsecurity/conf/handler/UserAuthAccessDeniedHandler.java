package com.sulin.springsecurity.conf.handler;

import com.sulin.springsecurity.utils.Api;
import com.sulin.springsecurity.utils.ResJsonUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sulin
 * 无权访问JSON格式的数据
 */
@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        Api<Object> api = Api.builder().code(401).message("你没有权限访问").build();
        ResJsonUtil.write(httpServletResponse, api);
    }
}
