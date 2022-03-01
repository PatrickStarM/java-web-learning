package com.mth.day3response.servlet;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: responseDemo4 ：响应字符集设置
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
        // response.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");
        //简单形式设置编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
        //pw.write("<h1>hello response</h1>");
        pw.write("你好啊 response");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}