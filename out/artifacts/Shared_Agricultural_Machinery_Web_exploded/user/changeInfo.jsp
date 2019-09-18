<%--
  Created by IntelliJ IDEA.
  User: 97307
  Date: 2019/9/17
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Basic ValidateBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<h2>用户信息更改</h2>
<p>请在文本框中填写相关信息</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="用户注册" style="width:600px;padding:10px 60px 20px 60px">
    <form action="user" method="post">
        <input type="hidden" name="oper" value="signup"/>
        <table cellpadding="5">
            <tr>
                <td>姓名:</td>
                <td><input name="name" value="${sessionScope.info.name}" class="easyui-validatebox textbox" data-options="required:true"></td>
            </tr>

            <tr>
                <td>联系电话:</td>
                <td><input name="tel" class="easyui-validatebox textbox" data-options="required:true"></td>
            </tr>
            <tr>
                <td>出生年月:</td>
                <td><input name="birthday" class="easyui-datebox textbox" value=""></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input name="address" class="easyui-validatebox textbox" data-options="required:true"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    男<input name="sex" type="radio" name="sex" value="男" checked="checked"/> 女<input type="radio" name="sex" value="女"/>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <input type="submit" value="注册"/>
                </td>
            </tr>
        </table>
    </form>

</div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>

</body>
</html>