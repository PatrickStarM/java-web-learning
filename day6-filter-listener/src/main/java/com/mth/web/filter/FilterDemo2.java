package com.mth.web.filter;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/4
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器2初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("44444");
        //放行，放请求访问其本该访问额资源
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("55555");

    }

    @Override
    public void destroy() {
        System.out.println("过滤器2销毁");
    }
}
