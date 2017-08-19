package weixin.zzq.AIqiyi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AiqyVIP {
	final static String HTML_URL= "http://www.yudi8.com";
	static String VIP_URL="http://www.yudi8.com/vip/?.html";
	/**
	 * 获取目标网址上的HTML
	 * @return
	 * @throws Exception
	 */
   public static String getHTML(String HTML_URL) throws Exception {
	   StringBuffer html = new StringBuffer();
	   URL url = new URL(HTML_URL);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	   InputStreamReader isr = new InputStreamReader(conn.getInputStream(),"gb2312");
	   BufferedReader br = new BufferedReader(isr);
	   String temp;
	   while ((temp = br.readLine()) != null) {
	   html.append(temp).append("\n");
	   }
	   br.close();
	   isr.close();
	  // System.out.println(html);
	   return html.toString();
}
    /**
     * 解析的得到的HTML 返回重要值 tid
     * @param html
     * @return
     */
   public static String getTid(String html){
	   String s = null;
	   int beginIndex=html.toString().indexOf("<div class=\"clear\">");
	   int endIndex=html.toString().indexOf("</h3>");
	   try {
		  s=html.toString().substring(beginIndex, endIndex);
	   } catch (Exception e) {
		 throw new RuntimeException("目标网站出错！", e);
	    }
	   int tdiIndex=s.indexOf("/vip/");
	  // System.out.println(s.substring(tdiIndex+5, tdiIndex+10));
	   String tid=s.substring(tdiIndex+5, tdiIndex+9);
	   return tid;
   }
   /**
    * 拼接会员所在网页URL
    * @return
 * @throws Exception 
    */
   public static String splitJointUrl() throws Exception{
	   
	   String HTML = getHTML(HTML_URL);
	   String TID=getTid(HTML);
	   return VIP_URL.replace("?",TID);
	   
   }
   public  String getVIP() throws Exception {
	   String html=getHTML(splitJointUrl());
	   int start=html.indexOf("账号----密码");
	   int end=html.indexOf("<section class=\"ad300x250\">");
	   return html.substring(start,end);
}
   public static void main(String[] args) throws Exception {
	AiqyVIP aiqyVIP = new AiqyVIP();
	   System.out.println(aiqyVIP.getVIP());
	
}
}
