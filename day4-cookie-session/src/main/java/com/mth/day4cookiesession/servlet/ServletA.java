package com.mth.day4cookiesession.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: ServletA存Cookie
 * @Date: 2022/2/28
 * @Version: 1.0
 **/
@WebServlet(urlPatterns = "/ServletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //发送Cookie
        //1.创建Cookie对象
        Cookie cookie = new Cookie("username", "张三");
        //2.通过response发送Cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
