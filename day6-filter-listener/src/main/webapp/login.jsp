<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Author: mth
  Date: 2022/3/4
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>这里是登录页面user:zhangsan</h2>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("user","zhangsan");
%>

</body>
</html>
