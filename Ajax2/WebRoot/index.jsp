<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>表单验证</title>
    <script type="text/javascript">
    	var xmlHttp;
    	function createXMLHttpRequest(){
    		if(window.ActiveXObject){
    			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    		}else if(window.XMLHttpRequest){
    			xmlHttp=new XMLHttpRequest();
    		}
    	}
    	function validate(){
    		createXMLHttpRequest();
    		var username=document.getElementById("username");
    		var url="validation.do?username="+escape(username.value);
    		xmlHttp.open("GET",url,true);
    		xmlHttp.onreadystatechange=handleStateChange;
    		xmlHttp.send(null);
    	}
    	
    	function handleStateChange(){
    		if(xmlHttp.readyState==4){
    			if(xmlHttp.status==200){
    				var message=xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
    				var messageArea=document.getElementById("results");
    				messageArea.innerHTML="<p>"+message+"</p>";
    			}
    		}
    	}
    </script>
	
  </head>
  
  <body>
    
    
    
    <table>
    <tr><td>用户名：</td><td><input type="text" size="10" id="username" onBlur="validate();"/></td><td><div id="results"></div></td></tr>
    </table>
  </body>
</html>
