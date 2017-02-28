package com.ssm.strategy;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6975601077710753878L;
	
	
	private final String Interface;
	
	
	String SessionCode ;
	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		
		Interface = request.getParameter("Interface");

		SessionCode = request.getSession().getAttribute("ValidateCode").toString();
	}

	
	
	
	
	









	
	





	public String getInterface() {
		return Interface;
	}






















	public String getSessionCode() {
		return SessionCode;
	}

	public void setSessionCode(String sessionCode) {
		SessionCode = sessionCode;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append(super.toString()).append("Interface: ").append(this.getInterface());
		return data.toString();
	}
}