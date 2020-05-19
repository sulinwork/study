package com.sulin.springsecurity.utils;

import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResJsonUtil {
    public static void write(HttpServletResponse response, Api t) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String json = JSONUtil.toJsonStr(t);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
