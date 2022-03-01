package com.mth.day4cookiesession.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: ServletA存Cookie
 * @Date: 2022/2/28
 * @Version: 1.0
 **/
@WebServlet(urlPatterns = "/ServletB")
@Slf4j
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Cookie
        //1.获取Cookie数组
        Cookie[] cookies = req.getCookies();
        //2.遍历数组
        for (Cookie cookie : cookies) {
            //获取数据
            String name = cookie.getName();
            if ("username".equals(name)) {
                String value = cookie.getValue();
                log.info("name:" + value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
