package com.ssm.strategy;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ssm.mapper.TableUserMapper;
import com.ssm.model.TableUser;
import com.ssm.model.User;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	private TableUserMapper tableUserMapper;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


            	
              /*  auth
                .inMemoryAuthentication()
            	 .withUser("123").password("123").roles("USER");*/
         
    	
    	InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> auths = 
    			
        		auth.inMemoryAuthentication();
    	
    	
    	
          
    /*	JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> auths = 
    			
    		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema();*/
      
   
    	UserDetailsManagerConfigurer<AuthenticationManagerBuilder, 
    	InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>>.UserDetailsBuilder authsadd 
    	= auths.withUser("user").password("123").roles("USER");      
    	List<TableUser> users = tableUserMapper.Loginuser();
    	/*authsdd.and()*/
        
    	
 	/*   for(int a= 0;a<user.size();a++){ }*/
   
			for(TableUser user : users){
				
				String name = user.getUsername();
				String password =user.getPassword();
				String pole =user.getRole();
				
				/*
				  auths.withUser("user").password("password").roles("USER").
				
			*/
					
				authsadd. and()
					
					.withUser(name).password(password).roles(pole);
				
				
				  
			}
		
 		
      	
           
    
        
        
        
        
    }
    
    

}