package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ssm.currency.RSAUtils;
import com.ssm.model.TableInfo;

import net.minidev.json.JSONObject;



@Controller
public class SecurityController {
	/*@RequestMapping("/LgSuccess")
	@ResponseBody
	public JSONObject InsertTableInfo(@RequestBody String insertmodelinfo, Model model) {

		JSONObject UserLogin = new JSONObject();
		UserLogin.put("UserLogin","Succress");

		return UserLogin;
	
	

	}*/
	
	



	
	@RequestMapping("/VerifySuccess")
	@ResponseBody
	public JSONObject LgSuccess(){
		JSONObject Succress = new JSONObject();	
		Succress.put("UserLogin","Succress");
		return Succress;
					
		
	}
	
	
	@RequestMapping("/ValidationFailure")
	@ResponseBody
	public JSONObject LgFailure(){
		JSONObject Succress = new JSONObject();		
		Succress.put("UserLogin","LgFailure");
		return Succress;
					
	}
	
	
	
	
	
	
}
