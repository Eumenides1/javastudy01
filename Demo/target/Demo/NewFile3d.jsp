<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>便民超市购买页面</title>
</head>
<body>

<form action="NewFile3c.jsp" method="post">
  <input type="checkbox" name="goods" value="柴"/>柴
  <input type="checkbox" name="goods" value="米"/>米
  <input type="checkbox" name="goods" value="油"/>油
  <input type="checkbox" name="goods" value="盐"/>盐
  <br><br><input type="submit" value="购买" />
  
</form>
<%
  String foodname[] = request.getParameterValues("goods");
  if(foodname!=null){
    for(int k=0;k<foodname.length;k++){
      session.setAttribute(foodname[k],foodname[k]);
    }
  }
%>


</form>
</body>
</html>