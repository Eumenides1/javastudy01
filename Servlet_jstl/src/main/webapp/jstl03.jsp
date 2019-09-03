<%@ page import="bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-14
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>jstl案例</title>
    <style>
        .row1{
            background-color: #fff8dc;
        }
        .row2{
            background-color: #f0f0f0;
        }
    </style>
</head>
<body style="font-size: 30px">
    <%
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 8; i++) {
            User user= new User();
            user.setUsername("用户"+i);
            user.setGender("m");
            user.setAge(20+i);
            users.add(user);
        }
        request.setAttribute("users",users);
    %>
    <table width="60%" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>用户名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>index</td>
            <td>count</td>
        </tr>
        <c:forEach items="${users}" var="u" varStatus="s">
            <tr class="row${s.index%2+1}">
                <td>${u.username}</td>
                <td>${u.gender}</td>
                <td>${u.age}</td>
                <td>${s.index}</td>
                <td>${s.count}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
