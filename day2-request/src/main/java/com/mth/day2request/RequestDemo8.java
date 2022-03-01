package com.mth.day2request;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: Request对象：forward转发
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8被访问了...");
        //存储数据到request域中
        request.setAttribute("msg", "hello");
        //转发到requestDemo9资源
        request.getRequestDispatcher("/requestDemo9").forward(request, response);
        // 无法跨域转发
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
