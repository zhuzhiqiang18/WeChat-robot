package weixin.zzq.util.dingshi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NFDFlightDataTaskListener implements ServletContextListener {
	  
	 public void contextInitialized(ServletContextEvent event) {
	  new TimerManager();
	 }
	 
	 public void contextDestroyed(ServletContextEvent event) {
	 }
	 
	}
