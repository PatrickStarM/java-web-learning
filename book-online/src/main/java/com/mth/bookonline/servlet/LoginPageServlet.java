package com.mth.bookonline.servlet;
/**
 * @ProjectName: JavaWebDev
 * @ClassName: ${NAME}
 * @Author: mth
 * @Description: 登录界面的url转发
 * @Date: 2022/2/24
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳转到login.html界面
        request.getRequestDispatcher("login.html").forward(request,response);
    }

}
