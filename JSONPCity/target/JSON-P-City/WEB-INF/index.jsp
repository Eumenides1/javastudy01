<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019-6-1
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>基于AJAX+JSON的二级联动</title>

    <style type="text/css">
        #provinces,#cities{width: 100px}
    </style>

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
        function getProvinces() {
            //1.获取XMLHttpRequest对象
            var xhr = getXMLHttpRequest();
            //2.设置URL
            var url = "get_provinces.do";
            //3.配置xhr的onreadystatechange
            xhr.onreadystatechange = function () {
                if(xhr.readyState == 4
                    && xhr.status == 200){
                    //获取数据转化为JSON字符串
                    var obj = JSON.parse(xhr.responseText);
                    //生成省下来菜单项
                    console.log("省列表");
                    console.log(obj);
                    //判断响应的代码
                    if(obj.state == 1) {

                        for (var i = 0; i < obj.data.length; i++) {
                            console.log("第" + i + "次循环生成<option>")
                            //创建<option>节点
                            var op = document.createElement("option");
                            //配置节点属性
                            op.value = obj.data[i].id;
                            op.text = obj.data[i].name;
                            //将节点添加到select中
                            $("provinces").appendChild(op);
                        }
                    }
                }
            };
            //4.调用open()
            xhr.open("GET",url,true);
            //5.调用send()
            xhr.send();
        }

        //获取“市”列表
        function getCities(provincesId) {
            //清空“市”列表中的所有选项
            while($("cities").firstChild){
                $("cities").removeChild($("cities").firstChild);
            }
            //判断当前“省”的ID
            if(provincesId == 0){
                //选取了“请选择”，则无需加载“市”列表
                return;
            }
            //获取XMLHttpRequest对象
            var xhr = getXMLHttpRequest();
            //确定URL配置请求参数：provincesId
            var url = "get_cities.do?provinceId="+provincesId;
            //配置onreadystateChange属性
            xhr.onreadystatechange = function () {
                if(xhr.readyState == 4
                    && xhr.status == 200){
                    //将响应正文转化为JSON对象
                    var obj = JSON.parse(xhr.responseText);
                    //遍历数组，生成option节点
                    for (var i = 0; i < obj.data.length; i++) {
                        var op = document.createElement("option");
                        op.value = obj.data[i].id;
                        op.text = obj.data[i].name;
                        $("cities").appendChild(op);
                    }
                    
                }
            };
            //调用open函数
            xhr.open("GET",url,true);
            //调用send函数
            xhr.send();
            //编写回调函数的函数体
            //alert(provincesId);
        }
    </script>
</head>
<body onload="getProvinces()">
    <p>
        请选择省：
        <select id="provinces"
                onchange="getCities(this.value)">
            <option value="0">----请选择------</option>
        </select>
    </p>
    <p>
        请选择市:
        <select id="cities"></select>
    </p>
</body>
</html>
