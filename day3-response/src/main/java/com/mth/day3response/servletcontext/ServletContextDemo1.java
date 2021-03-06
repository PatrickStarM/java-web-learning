package com.mth.day3response.servletcontext;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: ServletContextDemo1：获取 ServletContext对象
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         ServletContext对象获取：
           1. 通过request对象获取 request.getServletContext();
           2. 通过HttpServlet获取 this.getServletContext();
         */

        //1. 通过request对象获取
        ServletContext context1 = request.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);

        //true
        System.out.println(context1 == context2);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
