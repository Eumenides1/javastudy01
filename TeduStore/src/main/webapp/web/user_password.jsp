<%@ page contentType="text/html;charset=UTF-8"
language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <link href="../css/common.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
    <c:import url="header.jsp"></c:import>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt >我的订单
                <img src="../images/myOrder/myOrder2.png">
            </dt>
            <dd class="first_dd"><a href="orders.html">全部订单</a></dd>
            <dd>
                <a href="#">
                    待付款
                    <span><!--待付款数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待收货
                    <span><!--待收货数量-->1</span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待评价<span><!--待评价数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">退货退款</a>
            </dd>
        </dl>

        <dl class="footMark">
            <dt >我的优惠卷<img src="../images/myOrder/myOrder1.png"></dt>
        </dl>
        <dl class="address">
                <dt>收货地址<img src="../images/myOrder/myOrder1.png"></dt>
				<dd><a href="addressAdmin.html">地址管理</a></dd>
            </dl>
            <dl class="count_managment">
                <dt >帐号管理<img src="../images/myOrder/myOrder1.png"></dt>
                <dd class="first_dd"><a href="user_profile.jsp">我的信息</a></dd>
                <dd><a href="user_password.jsp">安全管理</a></dd>
            </dl>
    </div>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="profile.do">我的信息</a></span>
            <span class="rs_header_active"><a href="password.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span>
                <input type="password" id="old_password" maxlength="15"/>
                <span class="change_hint" id="old_password_hint"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span>
                <input type="password" id="new_password" maxlength="15"/>
                <span class="change_hint" id="new_password_hint"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span>
                <input type="password" id="confirm_password" maxlength="15"/>
                <span class="confirm_hint" id="confirm_password_hint"></span>
            </div>
            <div class="button-block">
                <a class="button-blue" href="#" onclick="changePassword()">保存更改</a>
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
    <style>
        .msg-error{ background: #f00;color: #fff;
            padding: 5px;}
        .msg-correct{background:#0f0 ;color: #fff;padding:5px }
    </style>

    <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/index.js"></script>
    <script src="../js/jquery.page.js"></script>
    <script type="text/javascript" src="../js/orders.js"></script>
    <script type="text/javascript">
        function changePassword() {
            //获取密码输入框的值
            var pwd1 = $("#old_password").val();
            var pwd2 = $("#new_password").val();
            var pwd3 = $("#confirm_password").val();
            //基本判断
            if(checkPasswordLength(pwd1)
                &&checkPasswordLength(pwd2)
                &&checkPasswordLength(pwd3)
                &&checkPasswordEquals()){
                //同时满足，提交
                $.ajax({
                    "url":"handle_change_password.do",
                    "data":"old_password="+pwd1+"&new_password="+pwd2,
                    "type":"POST",
                    "dataType":"json",
                    "success":function (obj) {
                        alert(obj.message);
                        $("#old_password").val("");
                        $("#new_password").val("");
                        $("#confirm_password").val("");
                        $("#old_password_hint").hide();
                        $("#new_password_hint").hide();
                        $("#confirm_password_hint").hide();
                    },
                    "error":function () {
                        alert("error!!!");
                        location.href = "../main/index.jsp";
                    }
                });
            }else {
                //不满足规则，提交
                alert("请检查错误信息后提交");
            }
        }
        //修改密码相关的验证
        //至少六位长度，不得超过15位(input 的maxlength验证)
        //两次输入的新密码必须一致
        //事件：当三个密码输入框丢失焦点时，验证长度
        //2.两个新密码输入框丢失焦点时验证规则3
        function checkPasswordLength(pwd) {
            return pwd.length >= 6;
        }
        function checkPasswordEquals() {
            //判断密码一致性
            var pwd1 = $("#new_password").val();
            var pwd2 = $("#confirm_password").val();
            if (pwd1 == pwd2) {
                $("#confirm_password_hint").html("密码可用");
                $("#confirm_password_hint").attr("class", "msg-correct");
                return true;
            } else {
                $("#confirm_password_hint").html("两次输入的密码不一致");
                $("#confirm_password_hint").attr("class", "msg-error");
                return false
            }

        }

        $("#confirm_password").blur(function () {
            //获取原密码
            var pwd = $("#confirm_password").val();
            $("#confirm_password_hint").show();
            //判断长度
            if(checkPasswordLength(pwd)){
                //长度ok
                $("#confirm_password_hint").html("密码格式正确");
                $("#confirm_password_hint").attr("class","msg-correct");
                checkPasswordEquals();
                return true;
            }else {
                //长度不够
                $("#confirm_password_hint").html("密码格式错误，密码长度至少6为数字");
                $("#confirm_password_hint").attr("class","msg-error");
            }
            return false;
        });

        $("#old_password").blur(function () {
            //获取原密码
            var pwd = $("#old_password").val();
            $("#old_password_hint").show();
            //判断长度
            if(checkPasswordLength(pwd)){
                //长度ok
                $("#old_password_hint").html("密码格式正确");
                $("#old_password_hint").attr("class","msg-correct");
            }else {
                //长度不够
                $("#old_password_hint").html("密码格式错误，密码长度至少6为数字");
                $("#old_password_hint").attr("class","msg-error");
            }

        });

        $("#new_password").blur(function () {
            //获取原密码
            var pwd = $("#new_password").val();
            $("#new_password_hint").show();
            //判断长度
            if(checkPasswordLength(pwd)){
                //长度ok
                $("#new_password_hint").html("密码格式正确");
                $("#new_password_hint").attr("class","msg-correct");
                checkPasswordEquals();
                return true;
            }else {
                //长度不够
                $("#new_password_hint").html("密码格式错误，密码长度至少6为数字");
                $("#new_password_hint").attr("class","msg-error");
                return false;
            }

        });


    </script>
</html>