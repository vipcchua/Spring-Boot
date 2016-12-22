package com.ssm.strategy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.ssm.strategy.*;


@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	

	
	@Autowired
	private Myprovider provider;
	/*@Autowired
	private MyAuthenticationSuccessHandler authSuccessHandler;*/
	
	
	 
	
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	DataSource dataSource;

	/*@Autowired
	private UserDetailsService userDetailsService;*/
	 
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
	}
	
			
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		
		http.authorizeRequests()
		
		.antMatchers(	StaticParams.PATHREGX.API
				, StaticParams.PATHREGX.CSS
				,StaticParams.PATHREGX.JS
				,StaticParams.PATHREGX.IMG
				,StaticParams.PATHREGX.Fonts
				,StaticParams.PATHREGX.index
				,StaticParams.PATHREGX.data
				,StaticParams.PATHREGX.Image).permitAll()//无需访问权限
		
	.antMatchers(StaticParams.PATHREGX.ADMIN)
		.hasAuthority(StaticParams.USERROLE.ADMIN)//admin角色访问权限
		
		.antMatchers(StaticParams.PATHREGX.VIEW)
		.hasAuthority(StaticParams.USERROLE.USER)//user角色访问权限
		
		.anyRequest()//all others request authentication.permitAll()
		.authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		
		
		.and()
		.logout().permitAll();
		*/
		
		
		/*"/css/**", "/fonts/**", "/image/**", "/js/**","model","modle","data","index"*/
		http
		.csrf()
		.disable()
		.authorizeRequests()
	
		.antMatchers(			
				StaticParams.PATHREGX.API
				, StaticParams.PATHREGX.CSS
				,StaticParams.PATHREGX.JS
				,StaticParams.PATHREGX.IMG
				,StaticParams.PATHREGX.Fonts
				,StaticParams.PATHREGX.index
				,StaticParams.PATHREGX.data
				,StaticParams.PATHREGX.Image
				,"/selectmodeid/**"
				,"/ssmimg/data/**"
				,"/insertmodelinfo/**"
				,"/Rsa/**"
				,"/VerifySuccess/**"
				,"/VerifyFailure/**"
				,"/LogoutSuccess/**"
				,"/SelectComPany/**"
				
		
				,"/SelectComPany/**"
				
				,"/getSysManageLoginCode/**"
				,"/checkimagecode/**"
				
				,"/validateColorServlet/**"
				,"/checkCodeservlet/**"
				
				,"/file/**"
				
				
				)/*无需权限就可以之星的页面*/
		
		
		
		.permitAll()
		
		  .antMatchers("/file").access("hasRole('ADMIN')")/*需要权限为ADMIN*/
		  .antMatchers("/file","/xxx").access("hasRole('USER')")/*需要权限为User*/
		  
		
		
		.antMatchers(StaticParams.PATHREGX.ADMIN)
			.hasAuthority(StaticParams.USERROLE.ADMIN)
			
			.antMatchers(StaticParams.PATHREGX.VIEW)
			.hasAuthority(StaticParams.USERROLE.USER)
		
				.anyRequest()
				.authenticated()
				.and()
				
				.formLogin()	
			
				.successForwardUrl("/VerifySuccess")
				.failureForwardUrl("/VerifyFailure")
			
				.loginPage("/login")
	
				.permitAll()				
				.and()
				.logout()	/*默认范文logout会退出*/
				.invalidateHttpSession(true)/*表示是否要在退出登录后让当前 session 失效，默认为 true 。*/
				.deleteCookies("JSESSIONID")/*指定退出登录后需要删除的 cookie 名称，多个 cookie 之间以逗号分隔。*/
				.logoutSuccessUrl("/login")/*返回登录页*/
			
				.permitAll();
		}

		
	/*	
		http
		.authorizeRequests()
			.antMatchers("/", "/about","/public/**").permitAll()
			.anyRequest().fullyAuthenticated()
			.and()
		.formLogin()
			.usernameParameter("sec-user")
			.passwordParameter("sec-password")
		
			.permitAll()
			.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			
			.deleteCookies("remember-me", "JSESSIONID")
			.permitAll()
			.and()
		.rememberMe();
}
		
		
		
		*/
		
		
		
	/*	http
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();*/
		
		
		
		
		/* http
         .authorizeRequests()
             .antMatchers("/").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
         
             .loginPage("/login")
             
             .permitAll()
             .and()
         .logout()
             .permitAll();
		*/
		
	
	 
	   
	   
	   
	   
	   
	   
	   
	   

	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//将验证过程交给自定义验证工具
		auth.authenticationProvider(provider);

	/*	auth.userDetailsService(userDetailsService);	*/

/*	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from table_user where username=?")
		.authoritiesByUsernameQuery("select username, role from table_user where username=?");*/
}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}