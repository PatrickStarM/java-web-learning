package com.mth.day1servletwork;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(urlPatterns = "/pic-servlet")
public class PictureServlet extends HttpServlet {
    @Override
    public void init() {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpg");
        String path = request.getServletContext().getRealPath("");
        System.out.println(path);
        File file = new File(path+"img/back.jpg");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }

        out.flush();
        in.close();
        out.close();

    }

}
