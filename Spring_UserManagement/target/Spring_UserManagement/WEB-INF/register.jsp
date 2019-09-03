<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-5-9
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Spring MVC - User Management</title>
</head>
<body >
    <form method="post" action="handleRegister.do">
        <h3>用户注册</h3>
        <p>用户名</p>
        <input type="text" name="username">
        <p>密码</p>
        <input type="text" name="password">
        <p>电话</p>
        <input type="text" name="phone">
        <p>电子邮箱</p>
        <input type="text" name="email">
        <p><input type="submit" value="注册"></p>
        <p>如果已经有账号，则直接<a href="login.do">登录</a></p>
    </form>
</body>
</html>
