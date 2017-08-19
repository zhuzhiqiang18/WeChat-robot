<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
		<title>强子公众</title>
	<style>
		body,ol,ul,h1,h2,h3,h4,h5,h6,p,th,td,dl,dd,form,fieldset,legend,input,textarea,select{margin:0;padding:0}
		body{font-size:16px; font-family: "微软雅黑";background:#fff;-webkit-text-size-adjust:100%;color: #353535;overflow: hidden;}
		a{color:#2d374b;text-decoration:none}
		em{font-style:normal}
		li{list-style:none}
		img{border:0;vertical-align:middle}
		table{border-collapse:collapse;border-spacing:0}
		p{word-wrap:break-word}
		h1,h2,h3,h4,h5,h6{font-weight: normal;}
		html,body{height: 100%;}
		#autoHide{background: url(img/qiangzigz.jpg) no-repeat;background-size: 100% 100%;position: fixed;top: 0;right: 0;bottom: 0;left: 0;z-index: 2222;}

	</style>
	</head>
	<body ontouchstart="toggleSound()">
		<div align="center">
		<img alt="图片丢失" src="img/qiangzigz.jpg">
		<h1>微信扫一扫，关注强子公众。更多欢乐等你来体验</h1>
		</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#autoHide').fadeOut(3000),$('#autoShow').fadeIn(1500);
		});
		function toggleSound() {
        	var music = document.getElementById("audio");//è·åID
        	if (music.paused) { 
                music.play(); 
        	}
		}
	</script>
	</body>
</html>
