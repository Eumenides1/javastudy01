<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-13
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size: 30px">
    <%
        pageContext.setAttribute("username","Sally");
    %>
    <%=pageContext.getAttribute("username")%>
    <!--jsp注释-->
    <%--jsp注释-->
</body>
</html>
