package com.mth.bookonline.servlet;
/**
 * @ProjectName: JavaWebDev
 * @ClassName: ${NAME}
 * @Author: mth
 * @Description:
 * @Date: 2022/2/24
 * @Version: 1.0
 **/


import com.mth.bookonline.entity.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/detail/*")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的Uri，并去除空格 /detail/2
        String requestPath = request.getRequestURI().trim();
        //获得最后一个"/"的位置
        int position = requestPath.lastIndexOf("/");
        //从该位置到最后取子串，也就是"/detail/3"中的3，有了这个id，就可以取集合中找到匹配的图书对象
        String id = requestPath.substring(position + 1);
        //从全局变量中取出图书list
        ServletContext sc = this.getServletContext();
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //遍历查找指定id的图书
        for (Book book : bookList) {
            if (Integer.parseInt(id) == book.getId()) {
                //找到匹配的id，存入request，页面转发到图书详情页，地址栏不变
                request.setAttribute("book", book);
                //设置相应对象类型为纯文本
                response.setContentType("text/plain;charset=utf-8");
                //book转成字符串
                response.getWriter().println(book);
                request.getRequestDispatcher("/book_detail.jsp").forward(request, response);
            }
        }
    }

}
