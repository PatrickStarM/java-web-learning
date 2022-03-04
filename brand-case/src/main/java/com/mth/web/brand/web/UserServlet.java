package com.mth.web.brand.web;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/4
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    public void selectAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        System.out.println("user selectAll...");
    }
    public void add(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException {
        System.out.println("user add...");
    }
}
