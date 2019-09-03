<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*,vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
主页!<%UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
      if(userInfo!=null){
    	  out.print(userInfo.getUserName());
      }
%>
<div>
<a href="prdServlet?flag=list">查看商品列表</a><br/>
<a href="prdServlet?flag=preAdd">录入新商品</a>
</div>
<%@ include file="logout.jsp" %>
</body>
</html>