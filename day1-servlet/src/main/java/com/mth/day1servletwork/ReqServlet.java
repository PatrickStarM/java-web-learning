package com.mth.day1servletwork;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/req")
public class ReqServlet extends HttpServlet {


    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Protocol:" + request.getProtocol());
        System.out.println("ContextPath" + request.getContextPath());
        System.out.println("ServletPath" + request.getServletPath());
        System.out.println("QueryString" + request.getQueryString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Protocol:" + req.getProtocol());
        System.out.println("ServletPath" + req.getServletPath());
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("password"));
    }

    @Override
    public void destroy() {


    }
}