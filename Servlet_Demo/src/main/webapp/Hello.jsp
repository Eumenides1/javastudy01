<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-11
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>人数统计</title>
</head>
<body style="font-size: 30px">
    当前系统在线人数：<%= application.getAttribute("count")%>
</body>
</html>
