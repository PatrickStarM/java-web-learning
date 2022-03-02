package com.mth.web.exercise.web;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/1
 * @Version: 1.0
 **/

import com.mth.web.exercise.entity.User;
import com.mth.web.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //获取用户输入的验证码
        String inputCode = request.getParameter("inputCode");
        //程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String verifyCode = (String) session.getAttribute("verifyCode");
        response.setContentType("text/html;charset=utf-8");
        String contextPath = request.getContextPath();
        //忽略大小写比对
        if (!verifyCode.equalsIgnoreCase(inputCode)) {
            //验证码错误,跳回注册页面
            response.getWriter().write("<script>alert('验证码错误');location='/register.html';</script>");
        }
        //2.调用service注册
        boolean flag = userService.register(user);

        //3.判断注册成功与否
        if (flag) {
            //注册成功，跳到登录界面
            response.getWriter().write("<script>alert('注册成功');location='/login.html';</script>");

        } else {
            //用户名已存在，注册失败，跳回注册页面
            response.getWriter().write("<script>alert('用户名已存在');location='/register.html';</script>");
        }
    }
}
