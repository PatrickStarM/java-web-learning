package com.mth.day3response.servletcontext;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: ServletContext功能 ：获取MIME类型
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
          ServletContext功能：
            1. 获取MIME类型：
             MIME类型:在互联网通信过程中定义的一种文件数据类型
             格式： 大类型/小类型   text/html		image/jpeg
             获取：String getMimeType(String file)
           2. 域对象：共享数据
           3. 获取文件的真实(服务器)路径
         */

        //2. 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //3. 定义文件名称
        //image/jpeg
        String filename = "a.jpg";
        //4.获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}