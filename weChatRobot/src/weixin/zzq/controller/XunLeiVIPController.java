package weixin.zzq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.zzq.XunLei.util.FindVip;
import weixin.zzq.service.XunLeiVIPService;

@Controller
@RequestMapping("/XUNLEI")
public class XunLeiVIPController {
     @Autowired
     private XunLeiVIPService xunLeiVIPService;
     private static FindVip findVip;
     private static String vip;
     private static long startTime=System.currentTimeMillis(); //时间戳
     /**
      * 同步线程 避免每次都要爬取下缓存
      * @param httpServletRequest
      * @return
      * @throws Exception
      */
     @RequestMapping("/vip")
     public synchronized  String getVIP(HttpServletRequest httpServletRequest) throws Exception{
    	 try {
    	   cache(System.currentTimeMillis()-startTime,System.currentTimeMillis());
    	  // System.out.println(startTime);
        	httpServletRequest.setAttribute("XunLeiVIP", vip);	
	} catch (Exception e) {
		httpServletRequest.setAttribute("error", "今日迅雷VIP还没有发布请稍后重试！");
	}    	    	return "xunleivip";
     }
     /**
      * 缓存辅助
      * @return
     * @throws Exception 
      */
     public synchronized String cache(long end_start_time,long newTime) throws Exception{
    	 if(end_start_time>1800000){
    		 findVip= new FindVip();
    		   vip=findVip.getVip();
    		   startTime= newTime;  
    	 }else
    	 if(findVip==null||vip==null){
  		   findVip= new FindVip();
  		   vip=findVip.getVip();
  		 startTime= System.currentTimeMillis(); 
  	   }
		return null;
     }
}
