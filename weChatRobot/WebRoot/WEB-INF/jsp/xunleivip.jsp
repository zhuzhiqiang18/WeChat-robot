<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>迅雷VIP</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<script src="js/util.js" type="text/javascript" charset="utf-8"></script>
		<script>
			$(function(){
			
			            var height = $(window).height();
			
			            $("button").height(height*0.2);
			
			        });
		</script>

	</head>

	<body>
	<h1 align="center">强子公众平台迅雷会员分享</h1>
	<h4 align="right" style="color: red;"><span style="color: blue;">每天不定时更新号码，力求号码最新</span></h4>
     <div align="center" style="background-color:#337ab7;">
    ${XunLeiVIP}
    ${error}
     </div>
   <h2 align="left" style="color: red;"><strong>免责声明：</strong></h2>
    <h4 align="left"><strong>本平台号码均来自于网络，本平台不承担任何责任！</strong></h4>
	</body>

</html>