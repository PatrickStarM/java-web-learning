package com.mth.web.exercise.web;

import com.mth.web.exercise.util.VerifyCodeUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/1
 * @Version: 1.0
 **/

@WebServlet(urlPatterns = "/verifyCode")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 生成验证码
        ServletOutputStream os = response.getOutputStream();
        String verifyCode = VerifyCodeUtil.outputVerifyImage(100, 50, os, 4);
        // 2. 存入Session
        HttpSession session = request.getSession();
        session.setAttribute("verifyCode", verifyCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}