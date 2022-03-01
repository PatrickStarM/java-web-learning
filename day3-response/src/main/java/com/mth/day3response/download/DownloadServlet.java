package com.mth.day3response.download;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: Response对象：文件下载
 * @Date: 2022/2/27
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件到内存
        //2.1找到文件的服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //2.2用字节流读入
        InputStream is = new FileInputStream(realPath);

        //3.设置响应头的打开方式
        response.setHeader("content-disposition", "attachment;filename" + filename);

        //4.将输入流中的数据写道输出流（借助缓冲）
        ServletOutputStream sos = response.getOutputStream();
        //缓冲区
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = is.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        sos.flush();
        sos.close();
        is.close();



    }
}
