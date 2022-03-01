package com.mth.bookonline.servlet;
/**
 * @ProjectName: JavaWebDev
 * @Author: mth
 * @Description: 拦截/Login.do请求，获得表单传递的参数，进行登陆功能验证
 * @Date: 2022/2/24
 * @Version: 1.0
 **/

import com.mth.bookonline.entity.User;
import com.mth.bookonline.service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单参数取出账号密码
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        //调用userservice生成一组数据
        UserService userService = new UserService();
        //通过全局变量获得用户列表数据
        ServletContext sc = this.getServletContext();
        List<User> userList = (List<User>) sc.getAttribute("userList");
        //将数据传到userService,这样才能对数据表进行遍历
        userService.setUserList(userList);
        //调用signin方法得到一个user对象，如果不是空的，，就把session当中整个对象记下来，然后将页面重定向到/index
        User user = userService.signIn(account, password);
        if (user != null) {
            //登录成功，将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //重定向到/index，进入IndexServlet
            resp.sendRedirect("/index");
        } else {
            //登录失败，设置好响应对象字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            //获得response对象的字符输出流
            PrintWriter out = resp.getWriter();
            //输出js脚本，弹出登录失败的信息,并重定向登录页面
            out.print("<script>alert('账号或密码错误');location.href='/login';</script>");
        }
    }
}
