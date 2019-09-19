<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 97307
  Date: 2019/8/18
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>

</div>

<div class="loginbody">

    <span class="systemlogo"></span>
    <br/>

    <c:if test="${sessionScope.reg == 1}">
        <div style="text-align: center">
            <span style="font-size: 15px; color: darkred; font-weight: bold">注册成功</span>
        </div>
    </c:if>
    <c:remove var="reg" scope="session"/>

    <%
        // 声明Java代码块进行错误提示语逻辑校验
        Object obj = request.getAttribute("flag");
        if (obj != null) {
    %>
    <div style="text-align: center">
        <span style="font-size: 15px; color: darkred; font-weight: bold">用户名或密码错误</span>
    </div>
    <%}%>

    <%
        Object pwd = session.getAttribute("newPwd");
        if (pwd != null) {
    %>
    <div style="text-align: center">
        <span style="font-size: 15px; color: darkred; font-weight: bold">密码修改成功</span>
    </div>
    <%}
        session.removeAttribute("newPwd");
    %>

    <div class="loginbox loginbox1">
        <form action="user" method="post">
            <li><input name="oper" type="hidden" value="login"/></li>
            <ul>
                <li><input name="id" type="text" placeholder = "用户名" class="loginuser" /></li>
                <li><input name="password" type="password" placeholder = "密码" class="loginpwd"  /></li>
                <select name="accountType">
                    <option value="" selected="selected">--请选择--</option>
                    <option value="农户">农户</option>
                    <option value="机手">机手</option>
                    <option value="农机管理部门">农机管理部门</option>
                    <option value="系统管理员">系统管理员</option>
                </select>
                <li class="yzm">
                <span><input name="" type="text" value="验证码"
                             onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"
                           onclick="javascript:window.location='main.html'"/>
                    <label><a href="user/signup.jsp">注册</a></label>
                    <label><a href="#">忘记密码？</a></label>
                </li>
            </ul>
        </form>


    </div>

</div>


<div class="loginbm">版权所有 河北农业大学信息学院<a href="http://www.hebau.edu.cn/"> hebau.edu.cn</a> </div>


</body>

</html>

