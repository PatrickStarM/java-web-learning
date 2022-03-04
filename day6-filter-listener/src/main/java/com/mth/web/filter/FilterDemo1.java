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

@WebFilter(urlPatterns = "/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器1被执行");
    }
    @Override
    public void destroy() {

        System.out.println("过滤器1被销毁");
    }


}
