<%@ page import="bean.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-14
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>jstl案例</title>
</head>
<body style="font-size: 30px">
    <%
        User user = new User();
        user.setUsername("李白");
        user.setGender("x");
        user.setAge(40);
        request.setAttribute("user",user);
    %>

    用户名：${user.username};
    姓别：
        <c:choose>
            <c:when test="${user.gender == 'm'}">男</c:when>
            <c:when test="${user.gender == 'f'}">女</c:when>
            <c:otherwise>保密</c:otherwise>
        </c:choose><br/>
    年龄：
        <c:choose>
            <c:when test="${user.age <= 18}">少年</c:when>
            <c:when test="${user.age >18 && user.age < 60}">中年</c:when>
            <c:when test="${user.age>60}">老年</c:when>
        </c:choose>
</body>
</html>
