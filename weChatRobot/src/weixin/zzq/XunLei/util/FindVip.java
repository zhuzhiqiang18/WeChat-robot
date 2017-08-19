package weixin.zzq.XunLei.util;

//正则  "\"\\[ZH=\".*?\\<br\\s*\\/\\s*\\>"
public class FindVip {
    public String getVip() throws Exception {
    	String URl=Html.splitJointUrl();
    	String viphtml=Html.getHTML(URl);
    	int start=viphtml.indexOf("<div class=\"message\">");
    	int end=viphtml.indexOf("<div class=\"locked\">");
    	return viphtml.substring(start,end)//
    			.replaceAll("独享不挤迅雷白金会员账号一年只要18元，点击查看", "")//
    			.replaceAll("(近期购买最高可加送会员20天，支持快鸟)","请把强子公众推荐给身边的朋友，谢谢！在使用过程中遇到问题请联系QQ：1048222543")//
    			.replaceAll("【", "").replaceAll("】","");
    }
    
    public static void main(String[] args) throws Exception {
    	String URl=Html.splitJointUrl();
    	String viphtml=Html.getHTML(URl);
    	//System.out.println(viphtml);
    	int beginIndex=viphtml.indexOf("<div class=\"message\">");
    	int end=viphtml.indexOf("<div class=\"locked\">");
    	System.out.println(viphtml.subSequence(beginIndex, end));
//    	String str1=viphtml.substring(beginIndex+30);//, endIndex);                                                         //str1.replaceAll("老冰棍VIP分享网M码", "M");
//    	int start=str1.indexOf("迅雷会员账号");
//    	int end1=str1.indexOf("</div>");
//    	System.out.println(str1.substring(start, end1).replaceAll("独享不挤迅雷白金会员账号一年只要18元，点击查看", "").replaceAll("(近期购买最高可加送会员20天，支持快鸟)",""));
    	//String regex="\"\\[ZH=\".*?\\<br\\s*\\/\\s*\\>";
	}
}
