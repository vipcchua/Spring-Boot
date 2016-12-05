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
	
	@RequestMapping("/VerifySuccess")
	@ResponseBody
	public JSONObject VerifySuccess(){
		JSONObject Succress = new JSONObject();	
		Succress.put("UserLogin","Success");
		return Succress;
					
		
	}
	
	
	@RequestMapping("/VerifyFailure")
	@ResponseBody
	public JSONObject VerifyFailure(){
		JSONObject Error = new JSONObject();		
		Error.put("UserLogin","Error Or Fail");
		return Error;
					
	}
	
	@RequestMapping("/LogoutSuccess")
	@ResponseBody
	public JSONObject LogoutSuccess(){
		JSONObject LogoutSuccess = new JSONObject();		
		LogoutSuccess.put("UserLogin","Error Or Fail");
		return LogoutSuccess;
					
	}
	
	
	
	
	
}
