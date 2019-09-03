<%@ page import="com.sun.openpisces.Dasher" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib uri="test" prefix="d"%>
<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-16
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date</title>
</head>
<body style="font-size: 30px">
    <p>
        <d:date pattern="yyyy-MM-dd"/>
    </p>
    <p>
        <%
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        %>
        <%=sdf.format(date)%>
    </p>
</body>
</html>
