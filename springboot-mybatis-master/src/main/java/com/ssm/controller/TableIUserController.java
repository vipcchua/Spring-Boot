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
import com.ssm.model.TableUser;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
public class TableIUserController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	@Autowired
	private TableUserMapper tableUserMapper;
	@Resource
	private Application application;

	/* 在用 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> selectmodel(@RequestBody String selectallmodel, Model model) {


		List<TableInfo> json = JSON.parseArray(selectallmodel, TableInfo.class);

		List<TableUser> user = tableUserMapper.Loginuser();

		return user;
	}
	
	
	
	

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
