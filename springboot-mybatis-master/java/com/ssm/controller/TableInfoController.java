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
import java.util.Date;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.ssm.model.TableInfo;
import com.ssm.model.TableProduction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@Api(value = "模具信息表", description = "模具信息表的相关操作")
public class TableInfoController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */
	@Autowired
	CchuaProperties CchuaProperties;
	@Autowired
	private TableInfoMapper tableInfoMapper;;
	@Resource
	private Application application;

	/* 在用 */
	/*
	 * @RequestMapping("/insertmodelinfo")
	 * 
	 * @ResponseBody public List<TableInfo> insertmodelinfo(@RequestBody String
	 * insertmodelinfo, Model model) {
	 * 
	 * String jsonStr =
	 * "[{'mouldNumber':'12','rfid':'12','productName':'12','customerName':'12','length':'12','width':'12','height':'12','cavityNumber':'12','applicableModels':'12','useRequirements':'12','mouldLife':'12','status':'12','remarks':'12'}]";
	 * 
	 * List<TableInfo> json = JSON.parseArray(insertmodelinfo, TableInfo.class);
	 * json.get(0).setId(uuid()); tableInfoMapper.addEmployeer(json.get(0));
	 * 
	 * 
	 * 
	 * 
	 * return json;
	 * 
	 * }
	 */

	@ApiOperation(value = "插入一条新的模具信息数据", notes = "插入一条新的模具信息数据", response = TableInfo.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping("/inserttableinfo")
	@ResponseBody

	public List<TableInfo> InsertTableInfo(@RequestBody String insertmodelinfo, Model model) {

		String jsonStr = "[{'mouldNumber':'12','rfid':'12','productName':'12','customerName':'12','length':'12','width':'12','height':'12','cavityNumber':'12','applicableModels':'12','useRequirements':'12','mouldLife':'12','status':'12','remarks':'12'}]";

		/*
		 * List<TableInfo> json = JSON.parseArray(insertmodelinfo,
		 * TableInfo.class); json.get(0).setId(uuid());
		 * tableInfoMapper.addEmployeer(json.get(0));
		 */

		List<TableInfo> json = JSON.parseArray(insertmodelinfo, TableInfo.class);

		json.get(0).setId(uuid());

		json.get(0).setUpdateDate(attime());
		tableInfoMapper.InsertTableInfo(json.get(0));

		return json;

	}

	@ApiOperation(value = "使用模具的Uid精确的修改一条数据", notes = "使用模具的Uid精确的修改一条数据，支持动态数据", response = TableInfo.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping("/udtableinfo")
	@ResponseBody
	public List<TableInfo> udtableinfo(@RequestBody String udtableinfo, Model model) {

		String jsonStr = "[{'id':'5488b55d-7be0-48a2-acea-6683df775fd7','mouldNumber':'13'}]";

		List<TableInfo> json = JSON.parseArray(udtableinfo, TableInfo.class);

		tableInfoMapper.Udtableinfo(json.get(0));

		return json;

	}

	/*
	 * 
	 * 
	 * var a
	 * ="[{'mouldNumber':'12','rfid':'12','productName':'12','customerName':'12','length':'12','width':'12','height':'12','cavityNumber':'12','applicableModels':'12','useRequirements':'12','mouldLife':'12','status':'12','remarks':'12'}]"
	 * $.ajax({ type:"post", contentType: "application/json", //必须有 url:
	 * 'http://10.3.13.212:8080/insertmodelinfo', dataType: 'json', data:a,
	 * success: function(data){ console.log(data) } });
	 * 
	 * 
	 */

	/*--------------- -----<----*查询*---->--- ----------------------*/

	@ApiOperation(value = "模具ID精确查询模具信息", notes = "使用模具ID精确查询模具的所有信息", response = TableInfo.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/selectmodeid", method = RequestMethod.POST)
	@ResponseBody
	public List<TableInfo> selectmodel(@RequestBody String selectmodeid, Model model) {

		String text = "[{'mouldNumber':'12'}]";
		/*
		 * TableInfo json = JSON.parseObject(text, TableInfo.class);
		 * List<TableInfo> user =
		 * this.tableInfoMapper.selectallmodel(json.getMouldNumber());
		 */

		List<TableInfo> json = JSON.parseArray(selectmodeid, TableInfo.class);

		List<TableInfo> user = tableInfoMapper.selectallmodel(json.get(0).getMouldNumber());

		return user;
	}

	@ApiOperation(value = "UID精确查询模具信息", notes = "使用模具的UID精确查询模具的所有信息", response = TableInfo.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/selectmodeuid", method = RequestMethod.POST)
	@ResponseBody
	public List<TableInfo> selectmodeuid(@RequestBody String selectmodeuid, Model model) {

		String text = "[{'id':'8de27004-d087-416b-891a-af88250204bc'}]";

		List<TableInfo> json = JSON.parseArray(selectmodeuid, TableInfo.class);

		List<TableInfo> TableInfo = tableInfoMapper.selectmodeuid(json.get(0).getId());

		return TableInfo;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            要删除的文件的文件名
	 * @return
	 * @return
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return true;
			} /* 失败正常返回true 这里为了让程序继续执行下去所以返回true */
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return true;
		}
	}

	@ApiOperation(value = "使用UID精确的删除一条模具信息", notes = "使用UUID精确的删除一条模具信息并且删除附带的文件", response = TableInfo.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/Dmouldinfo", method = RequestMethod.POST)
	@ResponseBody
	public String Dmouldinfo(@RequestBody String Dmouldinfo) {
		List<TableInfo> json = JSON.parseArray(Dmouldinfo, TableInfo.class);
		List<TableInfo> TableInfo = tableInfoMapper.selectmodeuid(json.get(0).getId());

		String deletefilename = TableInfo.get(0).getMouldPictures();
		JSONArray deleteFile = JSON.parseArray(deletefilename);
		/*
		 * System.out.println("json2Array()方法：jsonArr=="+deleteFile.get(1).
		 * toString());
		 */

		if (deleteFile != null) {
			String file = "D:/ssmimg/data/img/03f12c59-e5f3-4704-b035-87da8fff559f.jpg";
			for (int a = 0; a < deleteFile.size(); a++) {
				deleteFile(CchuaProperties.getUpfilePosition() + CchuaProperties.getUpfiledoc()
						+ deleteFile.get(a).toString());
				break;

			}
		}

		int user = tableInfoMapper.Dmouldinfo(json.get(0).getId());

		return "Success";

	}

	@RequestMapping("/selectmodelall")
	@ResponseBody
	@ApiOperation(value = "查询所有模具信息", notes = "该接口用于查询所有的模具信息")

	public List<TableInfo> selectmodelall(
			@RequestParam(value = "selectallmodel", required = false) String selectmodelall, Model model) {
		List<TableInfo> TableInfo = this.tableInfoMapper.modelall();
		System.out.println();
		return TableInfo;

	}

	@ApiOperation(value = "模糊查询所有模具信息并分页", notes = "分页返回所有模具信息，并且按照选择排序方式 sorting 以数据库字段为标准 ", response = TableInfo.class)
	@RequestMapping(value = "/selectmodelallpaging", method = RequestMethod.POST)
	@ResponseBody
	public List<TableInfo> selectmodelallpaging(@RequestBody String selectmodelallpaging, Model model) {

		List<TableInfo> json = JSON.parseArray(selectmodelallpaging, TableInfo.class);

		List<TableInfo> TableInfo = tableInfoMapper.SelectTableInfoPage(json.get(0));

		/* List<TableInfo> TableInfo = this.tableInfoMapper.modelallpaging(); */

		System.out.println();
		return TableInfo;

	}

	@ApiOperation(value = "动态条件所有模具信息", notes = "动态的查询模具信息，可以模糊的查询多个条件", response = TableInfo.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "mouldNumber", dataType = "String", required = true, value = "模具的ID", defaultValue = "你的模具ID是？？"),

	})
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
	@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/slTableInfo", method = RequestMethod.POST)
	@ResponseBody

	public List<TableInfo> slTableInfo(@RequestBody String slTableInfo, Model model) {

		List<TableInfo> json = JSON.parseArray(slTableInfo, TableInfo.class);

		System.out.println(json.get(0));
		List<TableInfo> TableInfo = tableInfoMapper.SelectTableInfo(json.get(0));

		return TableInfo;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}
	private  String attime()  {
        Date d = new Date();  
        System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d);  
        System.out.println("格式化后的日期：" + dateNowStr);  
          
        String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样  
        Date today;
		try {
			today = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
      /*  System.out.println("字符串转成日期：" + today);*/
		return dateNowStr;  
	}
    
}
