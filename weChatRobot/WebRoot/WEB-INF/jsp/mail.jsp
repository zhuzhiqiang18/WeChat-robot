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
		<title>雁书一封，莫相忘</title>
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
		#autoHide{background: url(../img/mail-bg.jpg) no-repeat;background-size: 100% 100%;position: fixed;top: 0;right: 0;bottom: 0;left: 0;z-index: 2222;}
		#autoShow{background: url(../img/mail.jpg) no-repeat;background-size: 100% 100%;position: fixed;top: 0;right: 0;bottom: 0;left: 0;z-index: -1;}
		input{font-size:16px;border: none;border-bottom: solid 1px #d7d7d7;background: transparent;padding: 5px;}
		.to{width: 50%;position: absolute;top: 10px;left: 10px;}
		.comment{font-family: "微软雅黑";font-size: 16px;background: transparent;width: 90%;border: none;resize: none;position: absolute;top: 60px;left: 10px;text-indent: 2em;}
		.form{width: 40%;position: absolute;bottom: 100px;right: 10px;}
		.send{border: none;background: darksalmon;color: white;padding: 10px 30px;margin: auto;transition: all 500ms;}
		.send:active{background: coral;}
	</style>
	</head>
	<body ontouchstart="toggleSound()">
		<!-- <audio id="audio" src="http://www.w3school.com.cn/i/song.mp3"autoplay="autoplay"></audio> -->
		<div id="autoHide"></div>
		<div id="autoShow"></div>
			<input type="text" class="to" name="formemail" id="formemail" placeholder="对方邮箱:"/>
			<textarea class="comment" rows="5" name="message" id="message" placeholder="输入你想说的话"></textarea>
			<input type="text" class="form" name="youremail" id="youremail" placeholder="来自：系统默认***"/>
			<div style="position: absolute;bottom: 20px;width: 100%;">
				<div style="width: 88px;margin: auto;">
				<button class="send" onclick="return yanzheng();">发送</button>								
				</div>
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
     function yanzheng(){
     var reg=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
     if(!reg.test($("#formemail").val())){
     alert("请输入正确的邮箱地址");
     return false;
     }
     var url="sendEmail";
     var data={"formemail":$("#formemail").val(),"message":$("#message").val(),"youremail":$("#youremail").val()};
     $.post(url,data,function(result){
     if(result=="OK"){
     alert("发送成功。如果你觉得强子公众还不错的话，请推荐给身边的朋友，谢谢！");
     return false;
     }else{
      alert("发送失败，请联系管理员 QQ：1048222543");
     return false;
     }
     });
     }
	</script>
	</body>
</html>
