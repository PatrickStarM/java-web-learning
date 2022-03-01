package com.mth.day2request;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: Request对象获取请求头数据：user-agent
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:referer
        String referer = request.getHeader("referer");
        // http://localhost:8080/day02/login.html
        System.out.println(referer);
        //防盗链
        if (referer != null) {
            if (referer.contains("/day02")) {
                //正常访问
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影....");
            } else {
                //盗链
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗？来优酷吧...");
            }
        }
    }
}