package weixin.zzq.XunLei.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
/**
 * 
 * @author zhuzhiqiang
 * 这是一个获取html并处理 可得到tid的类
 */
public class Html implements Serializable{
	//final static String HTML_URL= "http://www.laobinggun.com/forum-37-1.html";
	//static String VIP_URL="http://www.laobinggun.com/thread-?-1-1.html";
	final static String HTML_URL= "http://521xunlei.com/forum-xunleihuiyuan-1.html";
	static String VIP_URL="http://521xunlei.com/thread-?-1-1.html";
	/**
	 * 获取目标网址上的HTML
	 * @return
	 * @throws Exception
	 */
   public static String getHTML(String HTML_URL) throws Exception {
	   
	   StringBuffer html = new StringBuffer();
	   URL url = new URL(HTML_URL);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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
	   int beginIndex=html.toString().indexOf("<div class=\"threadlist\">");
	   int endIndex=html.toString().indexOf("<span class=\"by\"");
	   try {
		  s=html.toString().substring(beginIndex, endIndex);
	   } catch (Exception e) {
		 throw new RuntimeException("目标网站出错！", e);
	    }
	   int tdiIndex=s.indexOf("tid");
	 //  System.out.println(s.substring(tdiIndex+4, tdiIndex+8));
	   String tid=s.substring(tdiIndex+4, tdiIndex+8);
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
	   System.out.println(new Date()+"-----"+TID);
	   return VIP_URL.replace("?",TID);
	   
   }
   
   public static void main(String[] args) throws Exception {
	   //String HTML = getHTML(HTML_URL);
	   //System.out.println(HTML);
	   //String TID=getTid(HTML);
	   System.out.println(splitJointUrl());
}
}
