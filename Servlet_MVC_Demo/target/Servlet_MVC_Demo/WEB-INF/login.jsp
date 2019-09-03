<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-20
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body style="font-size: 30px">
    <form action="login.do" method="post">
        用户名：<input name="username"/><br/>
        密码：<input type="password" name="pwd"/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
