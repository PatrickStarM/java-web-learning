package com.mth.day3response.servlet;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: 重定向
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo1........");
        //访问/responseDemo1，会自动跳转到/responseDemo2资源
        //1. 设置状态码为302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location", "/day03/responseDemo2");
        request.setAttribute("msg", "response");
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo2");
        // 重定向可以跨域访问
        //response.sendRedirect("https://www.baidu.cn");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}