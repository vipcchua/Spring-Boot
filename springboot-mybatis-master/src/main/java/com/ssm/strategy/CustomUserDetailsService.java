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


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ssm.mapper.TableUserMapper;
import com.ssm.model.TableUser;





@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private TableUserMapper tableUserMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.err.println(username);
		
		List<TableUser> users = tableUserMapper.Loginusers(username);	
		
		System.out.println(users.size());
		
		if (users.size() == 0&& users!=null) {
			System.out.println("User.is unknow");
			throw new UsernameNotFoundException("not found");
	
			/* throw new BadCredentialsException("Wrong password."); 	*/
		}

		else{
			
		
			
			/*List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("USER"));*/
			
			
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
		
			
			
			
			
		return new User(users.get(0).getUsername(), users.get(0).getPassword(), authorities);

		
			
		}
		
		
		
		/*if (users.get(0)==null) {
			 throw new BadCredentialsException("Wrong password."); 	
		}
		
		  if (!username.equals(users.get(0).getPassword())) {
		         throw new BadCredentialsException("Wrong password.");			
		      }*/
			
		
		
		
		

	}
	
	





	
}