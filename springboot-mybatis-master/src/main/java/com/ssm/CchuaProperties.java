package com.ssm;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "CchuaProperties")    
public class CchuaProperties {

	 private String UpfilePosition;

	public String getUpfilePosition() {
		return UpfilePosition;
	}

	public void setUpfilePosition(String upfilePosition) {
		UpfilePosition = upfilePosition;
	}    

	
	
	
	
	
	
}
