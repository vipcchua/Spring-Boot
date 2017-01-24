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

import java.io.File;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssm.Application;
import com.ssm.CchuaProperties;
import com.ssm.mapper.TableInfoMapper;
import com.ssm.mapper.TableProductionMapper;
import com.ssm.model.TableInfo;
import com.ssm.model.TableProduction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller	 
@Api(value = "产品生产表", description = "产品生产表的相关操作")


public class TableProductionController {

	private static SqlSessionFactory sqlSessionFactory;

	@Autowired
	private TableProductionMapper tableProductionMapper;

	@Resource
	private Application application;

	/*--------------- -----<----*查询*---->--- ----------------------*/

	  @ApiOperation(value = "精确的使用订单ID查询生产信息", notes = "以OnorderNumber查询生产信息", response = TableProduction.class) 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	@RequestMapping(value = "/selectProductiOnorderNumber", method = RequestMethod.POST)
	@ResponseBody
	public List<TableProduction> selectProductionMapper(@RequestBody String selectmodeid, Model model) {

		List<TableProduction> json = JSON.parseArray(selectmodeid, TableProduction.class);

		List<TableProduction> user = tableProductionMapper.productionorderNumber(json.get(0).getOrderNumber());

		return user;
	}

	
	   @ApiOperation(value = "精确的使用模具ID查询生产信息", notes = "以MouldNumber查询生产信息", response = TableProduction.class) 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	
	@RequestMapping(value = "/selectProductionMouldNumber", method = RequestMethod.POST)
	@ResponseBody
	public List<TableProduction> selectmodel(@RequestBody String selectmodeid, Model model) {

		List<TableProduction> json = JSON.parseArray(selectmodeid, TableProduction.class);

		List<TableProduction> user = tableProductionMapper.productionmouldNumber(json.get(0).getOrderNumber());

		return user;
	}

	

	   @ApiOperation(value = "精确的使用生产ID查询生产信息", notes = "以ProductionId查询生产信息", response = TableProduction.class) 
	
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	
	@RequestMapping(value = "/selectProductionId", method = RequestMethod.POST)
	@ResponseBody
	public List<TableProduction> selectproductionid(@RequestBody String selectmodeid, Model model) {
		List<TableProduction> json = JSON.parseArray(selectmodeid, TableProduction.class);
		List<TableProduction> user = tableProductionMapper.selectproductionid(json.get(0).getProductionId());

		return user;
	}
	
	
	   @ApiOperation(value = "查询所有生产信息", notes = "查询生产的所有信息 无分页功能") 
		
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	@RequestMapping("/selectProductionAll")
	@ResponseBody
	public List<TableProduction> selectmodelall(
			@RequestParam(value = "selectProductionAll", required = false) String selectmodelall, Model model) {
		   
		   
		   
		List<TableProduction> TableInfo = this.tableProductionMapper.productionall();

		return TableInfo;

	}
	   
	   
	   @ApiOperation(value = "查询所有生产信息并且分页", notes = "查询生产的所有信息 分页功能") 
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	@RequestMapping("/selectProductionAllPage")
	@ResponseBody
	public List<TableProduction> selectProductionAllPage(@RequestBody String selectmodeid, Model model) {

		   
			List<TableProduction> json = JSON.parseArray(selectmodeid, TableProduction.class);
			List<TableProduction> user = tableProductionMapper.productionallpage(json.get(0).getPage(),json.get(0).getPageRow());
		   
		   


		return user;

	}
	   
	   
	   
	   
	   
		@ApiOperation(value = "模糊查询条件筛选出模具订单信息并分页", notes = "模糊查询条件筛选出模具订单信息并分页，并且按照选择排序方式", response = TableProduction.class)
		@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "page", dataType = "int", required = true, value = "分页起始序号", defaultValue = "1"),
			@ApiImplicitParam(paramType = "header", name = "pageRow", dataType = "int", required = true, value = "刷多少条数据", defaultValue = "2"),	
	})
		
		
		@RequestMapping(value = "/SelectTableProductionPagem", method = RequestMethod.POST)
		@ResponseBody
		public List<TableProduction> SelectTableProductionPagem(@RequestBody String selectmodelallpaging, Model model) {

			List<TableProduction> json = JSON.parseArray(selectmodelallpaging, TableProduction.class);

			List<TableProduction> tableProduction = tableProductionMapper.SelectTableProductionPage(json.get(0));

			/* List<TableInfo> TableInfo = this.tableInfoMapper.modelallpaging(); */

			System.out.println();
			return tableProduction;

		}
	   
	   

	/*--------------- -----<----*增加*---->--- ----------------------*/
	
	   @ApiOperation(value = "增加生产信息", notes = "增加生产信息 时间请使用毫秒数来增加 例如", response = TableProduction.class) 
	
	   @ApiResponses({
	       @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	   })
	
	
	@RequestMapping("/insertroduction")
	@ResponseBody
	public List<TableProduction> udtableinfo(@RequestBody String insertroduction, Model model) {

		List<TableProduction> json = JSON.parseArray(insertroduction, TableProduction.class);

		json.get(0).setProductionId(uuid());

		tableProductionMapper.InsertTableProduction(json.get(0));

		return json;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
    @ApiOperation(value = "删除生产信息", notes = "删除生产信息", response = TableProduction.class) 
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="id",name="production_id",dataType="String",required=true,value="production_id",defaultValue="必要条件为production_id"),
     
    })
   @ApiResponses({
       @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
   })
	/* 在用 */
	@RequestMapping(value = "/Deleteproduction", method = RequestMethod.POST)
	@ResponseBody
	public String Deleteproduction(@RequestBody String Dmouldinfo) {
		List<TableProduction> json = JSON.parseArray(Dmouldinfo, TableProduction.class);
		int Dmouldinfos = tableProductionMapper.Deleteproduction(json.get(0).getProductionId());
		if (Dmouldinfos == 1)
			return "Success";
		else
			return "Error";

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

    @ApiOperation(value = "修改生产信息", notes = "修改生产信息", response = TableProduction.class) 
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="id",name="production_id",dataType="String",required=true,value="production_id",defaultValue="必要条件为production_id"),
     
    })
   @ApiResponses({
       @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
   })
	@RequestMapping("/UDproduction")
	@ResponseBody
	public List<TableProduction> UDproduction(@RequestBody String udtableinfo, Model model) {

		List<TableProduction> json = JSON.parseArray(udtableinfo, TableProduction.class);

		tableProductionMapper.UpdateTableProduction(json.get(0));

		return json;

	}
	
	
	
	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
