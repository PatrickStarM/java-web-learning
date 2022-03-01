package com.mth.day1servletwork;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/json-servlet")
public class JsonServlet extends HttpServlet {
    private String message;
    @Override
    public void init() {
        message = "Hello World!";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String Json="{\"name\":\"mth\",\"age\":\"22\",\"job\":\"student\"}";
        out.println(message);
        out.println(Json);
        out.flush();
        out.close();


    }

}
