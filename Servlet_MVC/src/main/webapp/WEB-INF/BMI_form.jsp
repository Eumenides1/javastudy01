<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-16
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>BMI指数</title>
</head>
<body style="font-size: 30px;">

    <form action="bmi.do" method="post">
        身高（米）：<input name="height"/><br/>
        体重（千克）:<input name="weight"/><br/>
        <input type="submit" value="确定">
    </form>

</body>
</html>
