package weixin.zzq.AIqiyi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AiqyVIP2 {
	final static String HTML_URL= "http://wljx.net/forum-36-1.html";
	static String VIP_URL="http://wljx.net/thread-?-1-1.html";
	/**
	 * 获取目标网址上的HTML
	 * @return
	 * @throws Exception
	 */
   public static String getHTML(String HTML_URL) throws Exception {
	   
	   StringBuffer html = new StringBuffer();
	   URL url = new URL(HTML_URL);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	   conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	   InputStreamReader isr = new InputStreamReader(conn.getInputStream(),"utf-8");
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
	   int beginIndex=html.toString().indexOf("<th class=\"new\">");
	  // int endIndex=html.toString().indexOf("</h3>");
	   try {
		  s=html.toString().substring(beginIndex);
		  //int endIndex=s.indexOf("<td class=\"by\">");
		  s=html.toString().substring(beginIndex);
	   } catch (Exception e) {
		 throw new RuntimeException("目标网站出错！", e);
	    }
	   int tdiIndex=s.indexOf("tid");
	  // System.out.println(s.substring(tdiIndex+5, tdiIndex+10));
	   String tid=s.substring(tdiIndex+4, tdiIndex+9);
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
   public static  String getVIP() throws Exception {
	   String html=getHTML(splitJointUrl());
	   int start=html.indexOf("电脑请用客户端观看，网页看不了");
	   int end=html.indexOf("<div class=\"ptg mbm mtn\">");
	   return html.substring(start,end);
}
   public static void main(String[] args) throws Exception {
	//System.out.println(getHTML("http://wljx.net/forum-36-1.html"));
	  // System.out.println(getTid(getHTML("http://wljx.net/forum-36-1.html")));
	   System.out.println(getVIP());
}
}
