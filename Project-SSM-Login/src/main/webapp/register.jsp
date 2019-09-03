<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019-6-3
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
.

<html>
<head>
    <title>注册案例</title>
    <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
    <script type="text/javascript">

        function checkUsername() {
            //确定url
            var url = "check_username.do";
            //确定请求参数
            var params = "username=" + $("#username").val();
            //调用jQuery的ajax函数
            $.ajax({
               "url":url,
               "data":params,
               "type":"GET",
               "dataType":"json",
               "success":function (obj) {
                   if(obj.state == 1){
                       $("#username_hint").css("color","green");
                   }else {
                       $("#username_hint").css("color","red");
                   }
                   $("#username_hint").html(obj.message);
               }
            });
        }
    </script>
</head>
<body>
    <h3>用户注册</h3>

    <p>用户名</p>
    <p>
        <input type="text"
               id="username" name="username"
               value="admin"
               onblur="checkUsername()"/>
        <span id="username_hint"></span>
    </p>

    <p>密码</p>
    <p><input type="text"
              id="password" name="password" /></p>
    <p>手机号码</p>
    <p><input type="text"
              id="phone" name="phone" /></p>
    <p>电子邮箱</p>
    <p><input type="text"
              id="email" name="email" /></p>
    <p><input type="button" value="注册" /></p>
</body>
</html>
