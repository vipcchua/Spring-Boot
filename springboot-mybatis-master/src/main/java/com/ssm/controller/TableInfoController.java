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

import com.ssm.model.TableInfo;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
public class TableInfoController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	@Autowired
	private TableInfoMapper tableInfoMapper;;
	@Resource
	private Application application;

	/* 在用 */
	@RequestMapping("/insertmodelinfo")
	@ResponseBody
	public List<TableInfo> insertmodelinfo(@RequestBody String insertmodelinfo, Model model) {

		String jsonStr = "[{'mouldNumber':'12','rfid':'12','productName':'12','customerName':'12','length':'12','width':'12','height':'12','cavityNumber':'12','applicableModels':'12','useRequirements':'12','mouldLife':'12','status':'12','remarks':'12'}]";

		List<TableInfo> json = JSON.parseArray(insertmodelinfo, TableInfo.class);
		json.get(0).setId(uuid());
		tableInfoMapper.addEmployeer(json.get(0));

		return json;

	}

	/* 在用 */
	@RequestMapping("/udtableinfo")
	@ResponseBody
	public List<TableInfo> udtableinfo(@RequestBody String insertmodelinfo, Model model) {

		String jsonStr = "[{'id':'5488b55d-7be0-48a2-acea-6683df775fd7','mouldNumber':'13'}]";

		List<TableInfo> json = JSON.parseArray(insertmodelinfo, TableInfo.class);

	
		tableInfoMapper.Udtableinfo(json.get(0));

		return json;

	}

	
	
	
	
	
	/*
	 * 
	 * 
	  var a
	  ="[{'mouldNumber':'12','rfid':'12','productName':'12','customerName':'12','length':'12','width':'12','height':'12','cavityNumber':'12','applicableModels':'12','useRequirements':'12','mouldLife':'12','status':'12','remarks':'12'}]"
	 $.ajax({ type:"post", contentType: "application/json", //必须有 url:
	  'http://10.3.13.212:8080/insertmodelinfo', dataType: 'json', data:a,
	  success: function(data){ console.log(data) } });
	 * 
	 * 
	 */

	/* 在用 */
	@RequestMapping(value = "/selectmodeid", method = RequestMethod.POST)
	@ResponseBody
	public List<TableInfo> selectmodel(@RequestBody String selectallmodel, Model model) {

		String text = "[{'mouldNumber':'12'}]";
		/*
		 * TableInfo json = JSON.parseObject(text, TableInfo.class);
		 * List<TableInfo> user =
		 * this.tableInfoMapper.selectallmodel(json.getMouldNumber());
		 */

		List<TableInfo> json = JSON.parseArray(selectallmodel, TableInfo.class);

		List<TableInfo> user = tableInfoMapper.selectallmodel(json.get(0).getMouldNumber());

		return user;
	}
	
	
	
	@RequestMapping(value = "/selectmodeuid", method = RequestMethod.POST)
	@ResponseBody
	public List<TableInfo> selectmodeuid(@RequestBody String selectallmodel, Model model) {

		String text = "[{'id':'8de27004-d087-416b-891a-af88250204bc'}]";


		List<TableInfo> json = JSON.parseArray(selectallmodel, TableInfo.class);

		List<TableInfo> TableInfo = tableInfoMapper.selectmodeuid(json.get(0).getId());

		return TableInfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	/* 在用 */
	@RequestMapping(value = "/Dmouldinfo", method = RequestMethod.POST)
	@ResponseBody
	public int Dmouldinfo(@RequestBody String selectallmodel) {
		String text = "[{'id':'f3f64e83-e731-42d4-a165-50dbefab841c'}]";
		List<TableInfo> json = JSON.parseArray(selectallmodel, TableInfo.class);
		int user = tableInfoMapper.Dmouldinfo(json.get(0).getId());
		return user;
	}
	
	
	
	
	

	@RequestMapping("/selectmodelall")
	@ResponseBody
	public List<TableInfo> selectmodelall(
			@RequestParam(value = "selectallmodel", required = false) String selectallmodel, Model model) {
		List<TableInfo> TableInfo = this.tableInfoMapper.modelall();
		System.out.println();
		return TableInfo;

	}
	
	
	

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
