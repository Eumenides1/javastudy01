<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019-6-3
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>№天空¤→之城</title>
    <style type="text/css">
        body{
            background: #1f1f2b;
            color: #fff;
        }
        .box{
            width: 400px;
            margin: 70px auto;
            padding: 30px;
            background: rgba(247,247,247,0.15);
            box-shadow: 0px 0px 50px 0px #fff;
            border-radius: 16px;
        }
        .content{
            background: rgba(88,144,160,0.08);
            height: 200px;
        }
        h3{
            text-align: center;
            text-shadow: 0px 0px 50px #000;
        }
        .controller{
            margin-top: 20px;
            padding-left: 20px;
            padding-top: 20px;
        }
        input{
            background: none;
            border: none;
            outline: none;
            border-bottom: 1px solid #968f8f;
            color: #fff;
        }
        a{
            color: #999;
            margin-left: 20px;
        }
        button{
            width: 100px;
            font-size: 20px;
            background: #54a5a1;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 65px;
            cursor: pointer;
            outline: none;
            margin: 0 auto;
        }
        button:hover{
            box-shadow: 0px 0px 2px 2px #fff;
        }
    </style>


</head>
<body>
    <div class="box">
        <h3>[№天空¤→之城]登录短信验证测试</h3>
        <div class="content">
            <div class="controller">手机号码：
                <input type="text" id="phone">
            </div>
            <div class="controller">
                <input type="text" id="code">
                <a href="javascript:void(0)" id="getCode">获取验证码</a>
            </div>
            <div class="controller" style="text-align: center">
                <button>提交</button>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var obj = document.getElementById("getCode");
        var flag = 10;
        obj.onclick = function(){
            if(flag<10){
                return;
            }
            //注册点击事件
            timer();
        }
        function timer() {
            flag--;
            obj.innerHTML = flag+"秒以后重新获取";
            if(flag == 0) {
                obj.innerHTML = "获取验证码";
                flag = 10;
            }else {
                setTimeout("timer()", 1000);
            }
        }
    </script>
</body>
</html>
