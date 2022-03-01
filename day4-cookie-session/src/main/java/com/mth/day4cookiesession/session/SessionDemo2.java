package com.mth.day4cookiesession.session;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/2/28
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet("/demo2")
@Slf4j
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取Session对象
        HttpSession session = request.getSession();
        log.info(String.valueOf(session));
        //2.获取数据
        String username = (String) session.getAttribute("username");
        log.info(username);
//        //3.销毁session
//        session.invalidate();
//        log.info((String) session.getAttribute("username"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
