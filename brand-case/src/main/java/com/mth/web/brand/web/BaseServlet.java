package com.mth.web.brand.web;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/4
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    /**
     * 根据请求的最后一段路径来进行方法分发
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        // /brand-case/brand/selectAll
        String url = req.getRequestURI();
        //2.获取最后一段路径，方法名
        int index = url.lastIndexOf("/");
        // /selectAll? selectAll?
        String methodName = url.substring(index + 1);


        //2执行方法
        //2.1获取BrandServlet /UserServlet 字节码对象 Class
        Class<? extends BaseServlet> cls = this.getClass();
        //2.2获取方法 method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //2.3执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            exception.printStackTrace();
        }

    }

}