<%--
  Created by IntelliJ IDEA.
  User: 97307
  Date: 2019/9/4
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="team.hau.sam.pojo.vo.*" %>
<%@ page import="team.hau.sam.factory.ServiceFactory" %>
<%@ page import="java.lang.reflect.Method" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">查看个人信息</a></li>
    </ul>
</div>
<%
    Object teapUser =  request.getAttribute("userInfo");
    Class c = teapUser.getClass();

    Method m1 = c.getMethod("getId");
    Method m2 = c.getMethod("getName");
    Method m3 = c.getMethod("getAccountType");
    Method m4 = c.getMethod("getSex");
    Method m5 = c.getMethod("getBirthday");
    Method m6 = c.getMethod("getTel");
    Method m7 = c.getMethod("getAddress");
    Method m8 = c.getMethod("getRemark");

%>
<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <tr>
            <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
            <th>用户名</th>
            <th>用户类型</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>电话</th>
            <th>地址</th>
            <th>备注</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%=m1.invoke(teapUser)%></td>
            <td><%=m2.invoke(teapUser)%></td>
            <td><%=m3.invoke(teapUser)%></td>
            <td><%=m4.invoke(teapUser)%></td>
            <td><%=m5.invoke(teapUser)%></td>
            <td><%=m6.invoke(teapUser)%></td>
            <td><%=m7.invoke(teapUser)%></td>
            <td><%=m8.invoke(teapUser)%></td>
        </tr>
        </tbody>
    </table>



    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
