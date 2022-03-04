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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "CharacterFilter", urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterFilter初始化");
    }

    @Override
    public void destroy() {
        System.out.println("CharacterFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}