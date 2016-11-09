package com.ssm.strategy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.ssm.strategy.*;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired*/
/*	private Myprovider provider;*/
	
	
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
		/*http.authorizeRequests()
		
		.antMatchers(StaticParams.PATHREGX.API, 
				StaticParams.PATHREGX.CSS,StaticParams.PATHREGX.JS,StaticParams.PATHREGX.IMG).permitAll()//无需访问权限
		
		.antMatchers(StaticParams.PATHREGX.ADMIN).hasAuthority(StaticParams.USERROLE.ROLE_ADMIN)//admin角色访问权限
		
		.antMatchers(StaticParams.PATHREGX.VIEW).hasAuthority(StaticParams.USERROLE.ROLE_USER)//user角色访问权限
		
		.anyRequest()//all others request authentication
		.authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		
		
		.and()
		.logout().permitAll();*/
		
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
		
		

		http.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/css/**", "/fonts/**", "/image/**", "/js/**", "/","model","modle").permitAll()
				.anyRequest().authenticated().and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
		
		
		
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//将验证过程交给自定义验证工具
		/*auth.authenticationProvider(provider);*/

		auth.userDetailsService(userDetailsService);	

/*	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from table_user where username=?")
		.authoritiesByUsernameQuery("select username, role from table_user where username=?");*/
}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
