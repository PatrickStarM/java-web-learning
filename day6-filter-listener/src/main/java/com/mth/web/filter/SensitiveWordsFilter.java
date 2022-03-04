package com.mth.web.filter;
/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/4
 * @Version: 1.0
 **/

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;


import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class SensitiveWordsFilter implements Filter {
    private final List<String> list = new ArrayList<>();

    private final String methodName = "getParameter";

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {

            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            InputStreamReader is = new InputStreamReader(new FileInputStream(realPath), StandardCharsets.UTF_8);
            //2.读取文件
            BufferedReader br = new BufferedReader(is);
            //3.将文件的每一行数据添加到List中
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
            System.out.println("你是笨蛋");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                if (methodName.equals(method.getName())) {
                    //增强返回值，并获取
                    String value = (String) method.invoke(request, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                //替换为***
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                //执行目标方法，并返回执行结果
                return method.invoke(request, args);
            }
        });
        //2.放行
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(proxyReq,response);
    }
    @Override
    public void destroy() {
        System.out.println("敏感词过滤器被销毁");
    }

}
