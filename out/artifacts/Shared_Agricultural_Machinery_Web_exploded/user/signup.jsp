<%--
  Created by IntelliJ IDEA.
  User: 97307
  Date: 2019/9/10
  Time: 21:08
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
<h2>用户注册</h2>
<p>请在文本框中填写相关信息</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="用户注册" style="width:600px;padding:10px 60px 20px 60px">
    <form action="user" method="post">
        <input type="hidden" name="oper" value="signup"/>
        <table cellpadding="5">
            <tr>
                <td>用户类型:</td>
                <td>
                    <select name="accountType">
                        <option value="" selected="selected">--请选择--</option>
                        <option value="农户">农户</option>
                        <option value="机手">机手</option>
                        <option value="农机管理部门">农机管理部门</option>
                        <option value="系统管理员">系统管理员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input name="name" class="easyui-validatebox textbox" data-options="required:true"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" class="easyui-validatebox textbox" data-options="required:true"></td>
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
