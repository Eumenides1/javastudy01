<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>便民超市清算界面</title>
</head>
<body>


<br>
您的会员卡号：<%String userid = (String) session.getAttribute("Id");
                out.println(userid);
            %>

<br>

您买的物品：<br>
            <%
                Enumeration enumGoods= session.getAttributeNames();
                while (enumGoods.hasMoreElements()){
                    String key = (String) enumGoods.nextElement();
                    String goods = (String) session.getAttribute(key);
                    if(!(goods.equals(userid))){
                        out.println(goods+"<br>");
                    }
                }
            %>



</body>
</html>