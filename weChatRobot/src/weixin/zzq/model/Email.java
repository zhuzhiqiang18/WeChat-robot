package weixin.zzq.model;

import java.util.Date;

public class Email {
	private Integer id;// 主键
	private String youremail;// 发送方email
	private String formemail;// 接收方eamil
	private String message;// 发送内容
	private String beizhu;// 备注
	private String dingshi;// 定时
	private Date   createTime;// 定时
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYouremail() {
		return youremail;
	}
	public void setYouremail(String youremail) {
		this.youremail = youremail;
	}
	public String getFormemail() {
		return formemail;
	}
	public void setFormemail(String formemail) {
		this.formemail = formemail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getDingshi() {
		return dingshi;
	}
	public void setDingshi(String dingshi) {
		this.dingshi = dingshi;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}