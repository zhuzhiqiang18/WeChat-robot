package weixin.zzq.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.zzq.model.Email;
import weixin.zzq.service.EmailService;
import weixin.zzq.util.RandomChar;
import weixin.zzq.util.SendEmail;

@Controller
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService emailService;

	/**
	 * 发送雁书
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @throws
	 * @throws Exception
	 */
	@RequestMapping("/sendEmail")
	public String hello(HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e3) {
			throw new RuntimeException("编码失败", e3);
		}
		String formemail = request.getParameter("formemail");
		String message = request.getParameter("message");
		String youremail = request.getParameter("youremail");
		String usermessage = youremail.equals("") ? "***" : youremail;
		Email email = new Email();
		email.setFormemail(formemail);
		email.setMessage(message);
		email.setYouremail(usermessage);
		email.setCreateTime(new Date());
		try {
			SendEmail
					.sendEmail("null", "null", formemail, message, usermessage);
			response.getWriter().print("OK");
			email.setBeizhu("OK");
		} catch (Exception e) {
			try {
				response.getWriter().print("0");
				email.setBeizhu("NO");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}// 表示发送失败
		}
		emailService.save(email);
		System.out.println(formemail + "---" + message + "---" + usermessage);
		return null;
	}

	/**
	 * 转到雁书页面
	 * 
	 * @return
	 */
	@RequestMapping("/sendEmailPage")
	public String activity() {
		return "mail";
	}

	/**
	 * 活动码页面
	 * 
	 * @return
	 */
	@RequestMapping("/randompage")
	public String randompage() {
		return "activity";
	}

	/**
	 * 获取活动码
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRandomChar")
	public String getRandomChar(HttpServletResponse response) throws Exception {
		String random = RandomChar.getChars(4, 8);
		System.out.println(random);
		response.getWriter().print(random);
		return null;
	}
}
