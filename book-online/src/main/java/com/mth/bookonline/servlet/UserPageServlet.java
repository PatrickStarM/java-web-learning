package com.mth.bookonline.servlet;
/**
 * @ProjectName: JavaWebDev
 * @ClassName: ${NAME}
 * @Author: mth
 * @Description: 个人中心页面url转发
 * @Date: 2022/2/24
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserPageServlet", value = "/UserPageServlet")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }


}
