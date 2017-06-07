<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录系统</title>
  </head>
  
  <body>
    <p> 请输入账户和密码：</p><br>
    <form action="showsession" method="post">
    <table>
    	<tr>
    		<td>账户</td>
    		<td><input type="text" name="account" size="30"></td>
    	</tr>
    	<tr>
    		<td>密码</td>
    		<td><input type="password" name="password" size="30"></td>
    	</tr>
    </table>
    <input type="submit" value="登录">&nbsp;&nbsp;
    <input type="reset" value="重输">
    </form>
    
  </body>
</html>