<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-5-14
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC - User Management</title>
</head>
<body>
    <form method="post" action="TODO">
        <h3>用户登录</h3>
        <p>用户名</p>
        <p><input type="text" name="username"></p>
        <p>密码</p>
        <p><input type="password" name="password"></p>
        <p><input type="submit" value="登录"></p>
        <p>如果还没有账号，请先<a href="/Spring/register.do">注册</a></p>

    </form>
</body>
</html>
