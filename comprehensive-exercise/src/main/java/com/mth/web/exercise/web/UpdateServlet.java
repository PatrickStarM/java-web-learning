package com.mth.web.exercise.web;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/1
 * @Version: 1.0
 **/

import com.mth.web.exercise.entity.Brand;
import com.mth.web.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/updateBrand")
public class UpdateServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        System.out.println(id);
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        System.out.println(brand);

        //调用service完成修改
        brandService.update(Integer.parseInt(id),brandName,companyName,Integer.parseInt(ordered),description,Integer.parseInt(status));

        //3. 重定向到查询所有Servlet
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/index");
    }
}
