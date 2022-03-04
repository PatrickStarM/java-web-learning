package com.mth.web.ajaxexercise.servlet;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/3
 * @Version: 1.0
 **/

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/param")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得参数部分字符串
        String str = request.getQueryString();
        //按 & 分割成若干组
        String[] params = str.split("&");
        Map<String, String> map = new HashMap<>(4);
        for (String s : params) {
            //每组按 = 割，得到参数名和参数值
            String[] split = s.split("=");
            //如果参数值包含编码后的中文，需要解码
            if (split[1].contains("%")) {
                //URLDecoder解码
                split[1] = URLDecoder.decode(split[1], StandardCharsets.UTF_8);
            }
            //这一组参数的键值对存入map
            map.put(split[0], split[1]);
        }
        //将结果以JSON形式回显给客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(map));
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
