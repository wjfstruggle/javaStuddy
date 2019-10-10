package com.cdc.ecommerce.config;

import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.AccessDeniedException;

/**
 * @Author wujf
 * @ClassName AuthenticationAccessDeniedHandler
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    public void handle(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest, AccessDeniedException e) throws IOException,SecurityException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("权限不足,请联系管理员!");
        out.flush();
        out.close();
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, org.springframework.security.access.AccessDeniedException e) throws IOException, ServletException {

    }
}
