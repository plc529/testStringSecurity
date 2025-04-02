package com.plctest.securitydemo.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
//@Component
public class SecurityFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取http请求
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取验证码
        String code = (String) request.getSession().getAttribute("captcha");
        String userCode = request.getParameter("captcha");
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/user/login")){
            //判断验证码是否为空
            if (!StringUtils.hasText(userCode)){
                System.out.println("验证码为空");
                response.sendRedirect("/");
            }else if (!code.equals(userCode)){
                System.out.println("验证码输入错误");
                response.sendRedirect("/");
            }else{
                filterChain.doFilter(request,response);
            }
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
