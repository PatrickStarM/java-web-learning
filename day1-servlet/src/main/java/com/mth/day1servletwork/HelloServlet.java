package com.mth.day1servletwork;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body background=\"img/back.jpg\"><center>");
        out.println("<img width=\"150\" height=\"150\" src=\"img/favicon.ico\">");
        out.println("<h1>" + message + "</h1>");
        out.println("<form><input type=\"text\"><input type=\"button\"value=\"提交\"onclick=\"al()\"></form>");
        out.println("<script>function al(){alert('提交成功')}</script>");
        out.println("</center></body></html>");

    }

    @Override
    public void destroy() {


    }
}