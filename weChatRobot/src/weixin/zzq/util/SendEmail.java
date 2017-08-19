package weixin.zzq.util;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendEmail {
	public  static void sendEmail(String emailUserName,String  emailPassWord,String yourEmail, String message,String usermessage){
		JavaMailSenderImpl ms = new JavaMailSenderImpl();
		ms.setHost("smtp.qq.com");
		ms.setUsername("1048222543@qq.com");
		ms.setPassword("zzq1995517");
		
		Properties pt = new Properties();
	    pt.setProperty("mail.smtp.auth", "true");
		ms.setJavaMailProperties(pt);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("1048222543@qq.com");//发送方
		msg.setTo(yourEmail);//接收方
		
		msg.setSubject("强子公众雁书平台");
		StringBuilder builder =new StringBuilder();
		builder.append("“雁书不到，蝶梦无凭，漫倚高楼。”").
		append('\n').append('\t').append("--晏几道《诉衷情•凭觞静忆去年秋》")
		.append('\n')
		.append("千言万语，何时能说予你听。万千情思，怎甘心彻生雪藏。")
		.append('\n')
		.append("这里是强子公众“雁书”平台，为你为他为她构建心中那份言语之庭。")
		.append('\n').append("这份留言来自:"+usermessage)
		.append('\n')
		.append("【内容】").append('\n').append("      ")
		.append(message)
		.append('\n').append("                        本消息来自强子公众平台,请不要回复。更多功能请关注微信公众号”强子公众“。");
		msg.setText(builder.toString());
		try{
			ms.send(msg);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

