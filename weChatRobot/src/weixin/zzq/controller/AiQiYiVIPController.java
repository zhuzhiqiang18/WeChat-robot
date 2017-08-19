package weixin.zzq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.zzq.AIqiyi.AiqyVIP;
import weixin.zzq.AIqiyi.AiqyVIP2;
import weixin.zzq.XunLei.util.FindVip;

@Controller
@RequestMapping("/AIQIYI")
public class AiQiYiVIPController {
	 private static AiqyVIP aiqyVIP;
     private static String vip;
     private static long startTime=System.currentTimeMillis(); //时间戳
  /**
   * 同步线程
   * @param request
   * @return
   * @throws Exception
   */
  @RequestMapping("/vip")
  public synchronized String getVIP(HttpServletRequest request) throws Exception{
	  try {
		  cache(System.currentTimeMillis()-startTime,System.currentTimeMillis());
   	      //System.out.println(startTime);	
		  request.setAttribute("vip",vip);	
	} catch (Exception e) {
		request.setAttribute("vip", "爱奇艺VIP获取失败，请稍后重试或联系管理员 QQ:1048222543 ");
	}
	  return "aiqiyi";
  }
  
  
  /**
   * 缓存辅助 30分钟重新更新缓存
   * @return
  * @throws Exception 
   */
  public synchronized void cache(long end_start_time,long newTime) throws Exception{
 	 if(end_start_time>1800000){
 		aiqyVIP= new AiqyVIP();
 		   vip=aiqyVIP.getVIP();
 		   startTime= newTime;  
 	 }else
 	 if(aiqyVIP==null||vip==null){
 		aiqyVIP= new AiqyVIP();
		   vip=aiqyVIP.getVIP();
		 startTime= System.currentTimeMillis(); 
	   }
  }
}
