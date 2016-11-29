package com.ssm;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "CchuaProperties")    
public class CchuaProperties {

	 private String UpfilePosition;
	 private String HtmlPosition;
	 private String HtmlPower;
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
