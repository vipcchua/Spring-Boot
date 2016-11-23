package com.ssm.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/*
import com.rails.core.frame.security.userdetails.MyUserDetails;
import com.rails.core.frame.security.userdetails.MyUserDetailsService;
*/
import com.ssm.mapper.TableUserMapper;
import com.ssm.model.TableUser;

@Component
public class Myprovider implements AuthenticationProvider {

	/*@Autowired
	private MyUserDetailsService userService;*/
	
	@Autowired
	 private TableUserMapper tableUserMapper;
	/**
	 * 自定义验证方式
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
	/*	System.out.println(authentication.getCredentials()+"dsada"
				+	
		authentication.getPrincipal()
        );*/
		
		String username = authentication.getPrincipal().toString();	
		String password = (String) authentication.getCredentials();	
		System.out.println("username:"+username+"/n password:"+password);
  
		
    	List<TableUser> users = tableUserMapper.Loginusers(username,password);
    	

		if (users.size() == 0&& users!=null) {
			System.out.println("User.is unknow");
			throw new UsernameNotFoundException("not found");
		}

		else{
			
			
		
		/*	RSAUtil.decryptStr(users.get(0).getPassword(), g.toString());*/
			
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			
			
			authorities.add(new SimpleGrantedAuthority("USER"));		
			
			
			
		return new UsernamePasswordAuthenticationToken(users.get(0).getUsername(), users.get(0).getPassword(), authorities);

		
			
		}      
      
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}