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


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


public class SecurityHandler {
/*	@Component
	public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	    @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
	 	userMapper.incrementFailedLogin(request.getParameter("sec-user"));
	
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print("{\"success\": false}");
		response.getWriter().flush();
	    }
	}

	

	@Component
	public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	    @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws ServletException, IOException {
		userMapper.updateUserOnAuthSuccess(request.getParameter("sec-user"));
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().print("{\"success\": true}");
		response.getWriter().flush();
	    }
	}


*/

}
