<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019-5-29
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<html>
<head>
    <title>AJAX - Login</title>

    <script type="text/javascript">
        function $(id) {
            return document.getElementById(id);
        }
        // 获取XMLHttpRequest
        function getXMLHttpRequest() {
            var xhr;
            if (window.XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            } else {
                xhr = new ActiveXObject("Microsoft.XMLHttp");
            }
            return xhr;
        }

        // 发出请求并处理响应结果
        function handleLogin() {
            // 日志
            console.log("handleLogin() -> start.");

            // 1. 获取XMLHttpRequest
            var xhr = getXMLHttpRequest();
            // 2. 获取用户输入的数据
            var u = $("username").value;
            var p = $("password").value;

            // 3. 确定提交到的URL
            var url = "handle_login.do";
            var params = "username=" + u + "&password=" + p;

            // 4. 配置onreadystatechange
            xhr.onreadystatechange = function() {
                // 判断是否得到响应
                if (xhr.readyState == 4
                    && xhr.status == 200) {
                    // 响应正确
                    if(xhr.responseText == "1"){

                        //登录成功
                        location.href="index.do";

                    }else{
                        //登录失败
                        //alert("登录失败！");
                        $("message").innerHTML
                            = "登录失败，用户名或密码错误";
                        $("message").style.display
                            = "block";
                    }
                }
                //else {
                //	// 响应错误
                //	alert("出错啦！！！" + xhr.status);
                //}
            };
            // 5. 调用open()
            xhr.open("POST", url, true);
            // 6. 调用send()
            xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
            xhr.send(params);
        }
        function clearMessage() {
            $("message").style.display = "none";
        }

        function checkUsername() {
            var xhr = getXMLHttpRequest();
            var u = $("username").value;
            var url = "check_username.do";
            var params = "username"+u;

            xhr.onreadystatechange = function(){

                if(xhr.readyState == 4 && xhr.status == 200){
                    var jsonObj = JSON.parse(xhr.responseText);
                    var message;
                    if(jsonObj.state == "1"){
                         message ="<font color=green>" + jsonObj.message + "</font>";
                    } else {
                         message = "<font color=red>" + jsonObj.message + "</font>";
                    }
                    $("username_hint").innerHTML = message;
                }

            };

            xhr.open("POST",url,true);
            xhr.setRequestHeader("content-type",
                "application/x-www-form-urlencoded");
            xhr.send(params);
        }
    </script>

    <style type="text/css">
        #message {
            color: #f00;
            display: none;
        }

    </style>
</head>
<body>
<form action="handle_login.do" method="post">
    <h3>用户登录</h3>
    <p>用户名</p>
    <p><input id="username"
              type="text"
              name="username"
              value="ajax"
              onfocus="clearMessage()"
              onblur="checkUsername()"/>

    <span id = "username_hint"></span>

    </p>
    <p>密码</p>
    <p><input id="password"
              type="text"
              name="password"
              value="ajax888"
              onfocus="clearMessage()"/></p>
    <p id="message">提示信息</p>
    <p><input type="button" value="登录"
              onclick="handleLogin()" /></p>
</form>
</body>
</html>
