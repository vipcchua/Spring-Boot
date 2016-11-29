package com.ssm.strategy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
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

import com.ssm.currency.RSAUtils;
/*
import com.rails.core.frame.security.userdetails.MyUserDetails;
import com.rails.core.frame.security.userdetails.MyUserDetailsService;
*/
import com.ssm.mapper.TableUserMapper;
import com.ssm.model.TableUser;

import com.ssm.currency.AesUtils;

@Component
public class Myprovider implements AuthenticationProvider {

	/*
	 * @Autowired private MyUserDetailsService userService;
	 */

	@Autowired
	private TableUserMapper tableUserMapper;

	/**
	 * 自定义验证方式
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		/*
		 * System.out.println(authentication.getCredentials()+"dsada" +
		 * authentication.getPrincipal() );
		 */

		/*
		 * String decodeStr = URLDecoder.decode(authentication.toString(),
		 * "UTF-8");
		 */

		String rsausername = authentication.getPrincipal().toString();

		String rsapassword = authentication.getCredentials().toString();

		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String username = RSAUtils.decryptBase64(rsausername);
		/* username.replaceAll("\"",""); */

		String password = RSAUtils.decryptBase64(rsapassword);

		JSONObject usernameobj = new JSONObject(username.toString()); // 在这里转换。
		JSONObject passwordobj = new JSONObject(password.toString()); // 在这里转换。

		username = usernameobj.get("username").toString();
		password = passwordobj.get("password").toString();

		System.out.println("username:" + username + "\r\n password:" + password);

		List<TableUser> users = tableUserMapper.Loginusers(username);

		/* if (users.size() == 0&& users!=null) { */

		System.out.println("SQLpassword:" + users.get(0).getPassword() + "\r\n password:" + password);
		
	

		/* } */

		
		if (password.equals(users.get(0).getPassword())) {

			/* RSAUtil.decryptStr(users.get(0).getPassword(), g.toString()); */

			List<SimpleGrantedAuthority> authorities = new ArrayList<>();

			/*authorities.add(new SimpleGrantedAuthority("USER"));*/
			authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
			
			return new UsernamePasswordAuthenticationToken(users.get(0).getUsername(), users.get(0).getPassword(),
					authorities);

		}	
	else{
			System.out.println("User.is unknow");
			throw new UsernameNotFoundException("not found");
		}

	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}