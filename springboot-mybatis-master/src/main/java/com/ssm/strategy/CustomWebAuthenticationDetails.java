package com.ssm.strategy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6975601077710753878L;
	private final String token;
	String Codecookies ;
	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		token = request.getParameter("token");

		Codecookies = request.getSession().getAttribute("code").toString();
	}

	public String getToken() {
		return token;
	}
	
	



	protected String getCodecookies() {
		return Codecookies;
	}

	protected void setCodecookies(String codecookies) {
		Codecookies = codecookies;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("Token: ").append(this.getToken());
		return sb.toString();
	}
}