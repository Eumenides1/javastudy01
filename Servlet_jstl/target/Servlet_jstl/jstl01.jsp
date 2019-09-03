<%@ page import="bean.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-14
  Time: 15:07
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
        user.setUseranme("Sally");
        user.setGender("f");
        request.setAttribute("user",user);
    %>
    用户名：${user.useranme}<br/>
    性别:<c:if test="${user.gender == 'm'}">男</c:if>
        <c:if test="${user.gender != 'm'}">女</c:if>

    性别:<c:if test="${user.gender=='m'}" var="rs" scope="request">男</c:if>
        <c:if test="${!rs}">女</c:if>


</body>
</html>
