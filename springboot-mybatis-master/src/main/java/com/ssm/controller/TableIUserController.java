package com.ssm.controller;

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
import com.ssm.mapper.TableInfoMapper;
import com.ssm.mapper.TableUserMapper;
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
@Controller
@Api(value = "用户信息表", description = "用户信息的相关操作")

public class TableIUserController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	@Autowired
	private TableUserMapper tableUserMapper;
	@Resource
	private Application application;

	/* 在用 */

	  @ApiOperation(value = "查询所有用户信息", notes = "无条件查询所有的用户信息", response = TableProduction.class) 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> selectmodel(@RequestBody String users, Model model) {

		List<TableUser> user = tableUserMapper.Loginuser();

		return user;
	}

	
	
	  @ApiOperation(value = "使用用户名查询用户信息", notes = "使用用户名查询用户所有信息", response = TableProduction.class) 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	
	/* 在用 */
	@RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> Loginusers(@RequestBody String UserInfo, Model model) {

		List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);

		List<TableUser> user = tableUserMapper.UserInfo(json.get(0).getUsername());

		return user;
	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
