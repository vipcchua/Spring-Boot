package com.ssm.strategy;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
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

		
		System.out.println(authentication.getCredentials()+"dsada"
				+
		
		authentication.getPrincipal()
        );
		
		String b = (String) authentication.getCredentials();
		
		System.out.println("b"+b
        );
		
      /*  MyUserDetails user = (MyUserDetails) userService.loadUserByUsername(username);*/
        
    	List<TableUser> users = tableUserMapper.Loginusers(b);
        
    	/*   if (1+1!=3) {
               throw new BadCredentialsException("Wrong password.");
           }
       */
        
        return new UsernamePasswordAuthenticationToken(users.get(0).getUsername(),users.get(0).getPassword());
	
	
     
        
	
	
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
