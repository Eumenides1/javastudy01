<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-5-7
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h3>用户登录</h3>
    <form method="post" action="handleLogin.do">
        <p>用户名：</p>
        <p><input type="text" name="username"/></p>

        <p>密码：</p>
        <p><input type="text" name="password"/></p>

        <p><input type="submit" value="登录"/></p>
    </form>
</body>
</html>
