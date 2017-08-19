package weixin.zzq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.zzq.AIqiyi.AiqyVIP2;
import weixin.zzq.XunLei.util.FindVip;
import weixin.zzq.model.XunLeiVIP;

public class XunLeiServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static FindVip findVip;
    private static String vip;
    private static long startTime=System.currentTimeMillis(); //时间戳

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
			}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	    try {
	    	 cache(System.currentTimeMillis()-startTime,System.currentTimeMillis());
			out.print(vip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 缓存
	 * @param end_start_time
	 * @param newTime
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
   		 System.out.println("缓存失效");
 		   findVip= new FindVip();
 		   vip=findVip.getVip();
 		 startTime= System.currentTimeMillis(); 
 	   }
		return null;
    }
}
