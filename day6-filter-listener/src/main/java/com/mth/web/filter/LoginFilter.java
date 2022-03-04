package com.mth.web.filter;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/4
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        //状态校验逻辑代码
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //判断访问资源路径是否和登陆注册相关
        String[] urls = {"/login.jsp", "/img/", "/css/", "/js", "/loginServlet", "register.jsp", "/registerServlet", "/verifyCodeServlet"};
        String url = request.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)) {
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }
        //取出session,并取出user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        String msg = "";
        if (user != null) {
            //    放行
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            msg = "没有登录";
            //    没有登录，直接跳到登录页面
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }


    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
