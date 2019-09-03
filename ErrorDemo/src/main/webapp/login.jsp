<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userServlet?flag=login" method="post">
		<p>
			<label for="">用户名:</label> <input type="text" id="userName"
				name="account"><span></span>
		</p>
		<p>
			<label for="">密码:</label> <input type="password" id="pwd" name="pwd">
			<span></span>
		</p>
		<p>
			<label for=""></label> <input type="submit" value="登录"> <input
				type="reset" value="重置">
		</p>
	</form>
	<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null){
			out.println(msg);
		}
	%>
</body>
</html>