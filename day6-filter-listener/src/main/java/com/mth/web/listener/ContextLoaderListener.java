package com.mth.web.listener;
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

import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextLoaderListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private static Map<String, Object> sessionMap;

    public ContextLoaderListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener初始化，加载资源……");
        sessionMap = new HashMap<>(8);
        sce.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("sessionCreated销毁，释放资源");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(session.getAttribute("username") + "上线了");
        sessionMap.put(session.getId(), session.getAttribute("username"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(session.getAttribute("username") + "下线了");
        sessionMap.put(session.getId(), session.getAttribute("username"));
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated,创建了新的会话");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed,销毁了会话");
    }
}