<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>便民超市登陆界面</title>
</head>
<body>
<form action = "NewFile3d.jsp">
欢迎来到便民超市，请输入会员号:
<br><br><input type="text" name="su">

<input type="submit" value="提交">
</form>
<%
    String id = request.getParameter("su");
    session.setAttribute("Id",id);
%>

</body>
</html>