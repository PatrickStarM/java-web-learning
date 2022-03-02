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
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.io.IOException;

@WebServlet(urlPatterns = "/selectById")
@Slf4j
public class SelectByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受id
        String id = request.getParameter("id");
        log.info(id);
        //2.调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        //3.存储到request中
        request.setAttribute("brand", brand);
        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
