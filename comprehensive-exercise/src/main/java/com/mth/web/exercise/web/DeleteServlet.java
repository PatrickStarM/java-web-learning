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

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        boolean b = brandService.deleteById(id);
        response.setContentType("text/html;charset=utf-8");
        if (b) {
            response.getWriter().write("<script>alert('删除成功');location='/index';</script>");
        } else {
            response.getWriter().write("<script>alert('删除失败');location='/index';</script>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
