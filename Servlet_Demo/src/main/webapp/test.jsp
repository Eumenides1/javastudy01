<%@ page import="java.util.List" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-11
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>简单的Web缓存</title>
</head>
<body style="font-size: 30px">
    <%
        List<User> user = (List<User>) application.getAttribute("users");
        for (User u : user){
            out.println(u.getUsername()+""+u.getPhone()+"<br/>");
        }
    %>
</body>
</html>
