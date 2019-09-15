<%--
  Created by IntelliJ IDEA.
  User: 97307
  Date: 2019/8/26
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="team.hau.sam.pojo.vo.*" %>
<%@ page import="team.hau.sam.factory.ServiceFactory" %>
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
    <script language="JavaScript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
            //退出功能
            $("#out").click(function () {
                var flag = window.confirm("你真的要退出吗？");
                if (flag) {
                    window.top.location.href = "user?oper=out"
                }
            })
        })
    </script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
</div>

<div class="topright">
    <ul>
        <li><a href="javascript:void(0)" id="out">退出</a></li>  <!--javascript:void(0)这一句的效果就是跳过href这个属性，让a标签不通过href跳转-->
    </ul>
    <%
        User user = (User)session.getAttribute("user");
        Object teapUser = null;
        if ("农户".equals(user.getAccountType())) {
            teapUser = ServiceFactory.getPeasantHouseholdServiceInstance().getPeasantHouseholdInfoService(user);
        }
    %>
    <div class="user">
        <span><%=((PeasantHouseholdVo) teapUser).getName()%></span>
    </div>

</div>

</body>
</html>
