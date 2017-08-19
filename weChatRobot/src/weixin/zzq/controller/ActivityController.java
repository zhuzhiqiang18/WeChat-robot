package weixin.zzq.controller;

import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.zzq.model.Email;
import weixin.zzq.util.RandomChar;
@Controller
@RequestMapping("/activitypage")
public class ActivityController {
     @RequestMapping("/activity")
     public String getRandomChar(HttpServletResponse response,@ModelAttribute Email email) throws Exception{
    	String random= RandomChar.getChars(4, 8);
    	//System.out.println(random);
    	 response.getWriter().print(random);
    	 return null;
     }
     @RequestMapping("/TXSP")
     public String txsp() throws Exception{
    	 return "txsp";
     }
}
