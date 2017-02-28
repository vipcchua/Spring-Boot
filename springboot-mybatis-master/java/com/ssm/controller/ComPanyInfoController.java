package com.ssm.controller;


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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.html.HTML.Tag;
import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssm.Application;
import com.ssm.mapper.ComPanyMapper;
import com.ssm.mapper.TableInfoMapper;
import com.ssm.mapper.TableUserMapper;
import com.ssm.model.CompanyInfo;
import com.ssm.model.TableInfo;
import com.ssm.model.TableProduction;
import com.ssm.model.TableUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Api(value = "公司基本信息表", description = "公司信息的相关操作")

@Controller
public class ComPanyInfoController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	@Autowired
	private ComPanyMapper  comPanyMapper;
	@Resource
	private Application application;

	   @ApiOperation(value = "查询用户的所有信息", notes = "直接查询", response = TableProduction.class) 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })

	@RequestMapping("/SelectComPany")
	@ResponseBody
	public List<CompanyInfo> selectmodelall(
			@RequestParam(value = "selectallmodel", required = false) String selectmodelall, Model model) {
		List<CompanyInfo> user = comPanyMapper.selectcomoanty();
		System.out.println();
		return user;

	}
	
	
	
	   @ApiOperation(value = "修改的所有信息", notes = "修改用户的基本信息", response = TableProduction.class) 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })

	
	@RequestMapping("/udComPany")
	@ResponseBody
	public List<CompanyInfo> udComoany(@RequestBody String udComoany, Model model) {

		String jsonStr = "[{'id':'5488b55d-7be0-48a2-acea-6683df775fd7','mouldNumber':'13'}]";

		List<CompanyInfo> json = JSON.parseArray(udComoany, CompanyInfo.class);

		comPanyMapper.UpCompanyInfo(json.get(0));

		return json;

	}
	
	
	
	

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
