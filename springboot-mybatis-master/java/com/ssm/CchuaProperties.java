package com.ssm;
/*
 * 
 * 	
		Author: Cchua
		GitHub: https://github.com/vipcchua
		Blog  : weibo.com/vipcchua
 * 
 * 
 * */
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "CchuaProperties")    
public class CchuaProperties {

	 private String UpfilePosition;
	 private String HtmlPosition;
	 private String HtmlPower;
	 private String Upfiledoc;
	 private String Upfileimg;
	 private String Upfilecompanyinfo;
	 
	 
	 
	public String getUpfiledoc() {
		return Upfiledoc;
	}

	public void setUpfiledoc(String upfiledoc) {
		Upfiledoc = upfiledoc;
	}

	public String getUpfileimg() {
		return Upfileimg;
	}

	public void setUpfileimg(String upfileimg) {
		Upfileimg = upfileimg;
	}

	public String getUpfilecompanyinfo() {
		return Upfilecompanyinfo;
	}

	public void setUpfilecompanyinfo(String upfilecompanyinfo) {
		Upfilecompanyinfo = upfilecompanyinfo;
	}

	public String getUpfilePosition() {
		return UpfilePosition;
	}

	public void setUpfilePosition(String upfilePosition) {
		UpfilePosition = upfilePosition;
	}

	public String getHtmlPosition() {
		return HtmlPosition;
	}

	public void setHtmlPosition(String htmlPosition) {
		HtmlPosition = htmlPosition;
	}

	public String getHtmlPower() {
		return HtmlPower;
	}

	public void setHtmlPower(String htmlPower) {
		HtmlPower = htmlPower;
	}    

	
	
	
	
	
	
}
