package com.mth.web.exercise.web;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/3
 * @Version: 1.0
 **/

import com.alibaba.fastjson.JSON;
import com.mth.web.exercise.entity.Brand;
import com.mth.web.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/newBrand")
public class NewBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getParameter不能接受Json数据
        //String brandName = request.getParameter("brandName");
        //System.out.println(brandName);

        //1.用缓冲字符输入流来获取请求体数据
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        //2.将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(json.toString(), Brand.class);
        //3.调用service添加
        brandService.add(brand);
        //4.响应成功'
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
