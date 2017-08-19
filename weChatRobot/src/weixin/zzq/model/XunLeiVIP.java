package weixin.zzq.model;

import java.util.Date;

public class XunLeiVIP {
    public Integer id;
    public String vipContext;//迅雷会员内容
    public Date createTime;
    public String beizhu;
    public int redu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVipContext() {
		return vipContext;
	}
	public void setVipContext(String vipContext) {
		this.vipContext = vipContext;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
    
}
