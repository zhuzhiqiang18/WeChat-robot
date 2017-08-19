<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>爱奇艺VIP分享</title>
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
	<h1 align="center">强子公众平台爱奇艺会员分享</h1>
	<h4>记得把强子公众分享给身边的人哦！在使用过程中，如遇到问题请联系强子QQ：1048222543<br/><span style="color: blue;">注：30分钟更新一次号码</span></h4>
     <div align="center" style="background-color:#337ab7;">
    ${vip}
     </div>
   <h2 align="left" style="color: red;"><strong>免责声明：</strong></h2>
    <h4 align="left"><strong>本平台号码均来自于网络，本平台不承担任何责任！</strong></h4>
	</body>

</html>