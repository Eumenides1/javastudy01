<%--
  Created by IntelliJ IDEA.
  User: Eumenides
  Date: 2019-4-12
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size: 30px">

    <%!
        int i = 1;
        int sum(int a1,int a2){
            return a1+a2;
        }
    %>
    <%= i+100 %>
    <%=sum(1,1)%>
</body>
</html>
