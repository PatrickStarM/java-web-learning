package com.mth.bookonline.servlet;
/**
 * @ProjectName: JavaWebDev
 * @ClassName: ${NAME}
 * @Author: mth
 * @Description: 拦截/index请求，获取所有图书数据，并通过服务器端转发跳转到主页
 * @Date: 2022/2/24
 * @Version: 1.0
 **/

import com.mth.bookonline.entity.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得各个Servlet共享的对象
        ServletContext sc = this.getServletContext();
        //取得全局应用对象中的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //存入request
        request.setAttribute("bookList", bookList);
        //设置相应对象类型为纯文本
        response.setContentType("text/plain;charset=utf-8");
        //booklist转成字符串
//        response.getWriter().println(bookList.toString());
        //通过服务器端转发，将数据带过去，并保持地址栏不变
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

}
