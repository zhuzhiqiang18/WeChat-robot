package weixin.zzq.util.dingshi;

import java.util.Date;
import java.util.TimerTask;

import javax.ejb.FinderException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import weixin.zzq.XunLei.util.FindVip;
import weixin.zzq.model.XunLeiVIP;
import weixin.zzq.service.XunLeiVIPService;
public class NFDFlightDataTimerTask extends TimerTask {
	 
	 private static Logger log = Logger.getLogger(NFDFlightDataTimerTask.class);
	  @Autowired
	     private XunLeiVIPService xunLeiVIPService;
	 @Override
	 public void run() {
	  try {
	    //每天两点 自动获取网站信息
	  } catch (Exception e) {
	   log.info("-------------解析信息发生异常--------------");
	  }
	 }
	}