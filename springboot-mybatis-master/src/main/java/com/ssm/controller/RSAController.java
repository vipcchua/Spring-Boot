package com.ssm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ssm.currency.RSAUtils;
import com.ssm.model.User;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@RestController
public class RSAController {
	/*@RequestMapping("/Rsa")
    @ResponseBody
	public ResponseEntity<User> getRSAPublicKey(){
		User result=new User();
	
		String thePubKey=RSAUtils.generateBase64PublicKey();
		result.setName(thePubKey);

		return new ResponseEntity<User>(result,HttpStatus.OK);
					
		
	}*/
	
	
	@RequestMapping("/Rsa")
    @ResponseBody
	public JSONObject getRSAPublicKey(){
		JSONObject result = new JSONObject();	
		String thePubKey=RSAUtils.generateBase64PublicKey();	
		result.put("thePubKey", thePubKey);
		return result;
					
		
	}
	
	
	
	


}
