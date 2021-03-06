<%--
  Author: mth
  Date: 2022/3/1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
    <link href="css/login-regist.css" rel="stylesheet">
</head>
<body>
<div class="back">
    <div class="ball-1"></div>
    <div class="ball-2"></div>
    <div class="ball-3"></div>
    <div class="ball-4"></div>
</div>
    <div class="container-login">

<div class="container">
    <div class="values">
        <h2>添加品牌</h2>
    <form action="${pageContext.request.contextPath}/addBrand" method="post">
        <table>
            <tr>
                <td>
                    <label for="brandName">
                        品牌名称
                    </label>
                </td>
                <td><input name="brandName" id="brandName" type="text"></td>
            </tr>

            <tr>
                <td>
                    <label for="companyName">
                        企业名称
                    </label>
                </td>
                <td><input name="companyName" id="companyName" type="text"></td>
            </tr>

            <tr>
                <td>
                    <label for="ordered">
                        排序
                    </label>
                </td>
                <td><input name="ordered" id="ordered" type="text"></td>
            </tr>

            <tr>
                <td>
                    <label for="description">
                        描述信息
                    </label>
                </td>
                <td>
                    <textarea rows="10" cols="50" name="description" id="description">
                  </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    状态
                </td>
                <td>
                    <input name="status" type="radio" id="ok" value="1" checked>
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0">
                    <label for="no">
                        禁用
                    </label>
                </td>
            </tr>

        </table>

        <div >
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</div>
    </div>

</body>
</html>
