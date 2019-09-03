<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-13
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size: 30px">

    <%
        User user = new User();
        user.setUsername("Sally");
        user.setAge(20);
        user.setInterest(new String[]{"cooking","fishing"});
        request.setAttribute("user",user);

        User user2 = new User();
        user2.setUsername("Eric");
        user2.setAge(33);
        session.setAttribute("user",user2);
    %>
    username:<%
//        User user1 = (User) request.getAttribute("user");
//        out.println(user1.getUsername());
    %><br/>

    username: ${user.username}<br/>
    username（指定查找范围）：${sessionScope.user.username}<br/>
    username:${user['username']}<br/>

    <%
        request.setAttribute("str1","age");
    %>
    ${user[requestScope.str1]}<br/>
    ${user.interest[1]}
</body>
</html>
