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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

import com.alibaba.fastjson.JSONStreamAware;
import com.mysql.cj.core.exceptions.PasswordExpiredException;

import org.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssm.Application;
import com.ssm.currency.AesUtils;
import com.ssm.currency.RSAUtils;
import com.ssm.mapper.TableInfoMapper;
import com.ssm.mapper.TableUserMapper;
import com.ssm.model.TableInfo;
import com.ssm.model.TableProduction;
import com.ssm.model.TableUser;

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
@Api(value = "用户信息表", description = "用户信息的相关操作")

public class TableUserController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	@Autowired
	private TableUserMapper tableUserMapper;
	@Resource
	private Application application;

	/* 在用 */



	

	


	
	
	@ApiOperation(value = "查询所有用户", notes = "无条件查询所有的用户信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping("/Selectalluser")
	@ResponseBody

	
	public List<TableUser> alluser(@RequestBody String selectmodeid, Model model) {

		   
		List<TableUser> json = JSON.parseArray(selectmodeid, TableUser.class);
		List<TableUser> user = tableUserMapper.alluser(json.get(0).getPage(),json.get(0).getPageRow());
	   
	return user;

}
   
   
   
	@ApiOperation(value = "查询所有用户数量", notes = "无条件查询所有的用户数量", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping("/SelectalluserNumber")
	@ResponseBody

	
	public List<TableUser> alluserNumber() {

		   
	
		List<TableUser> user = tableUserMapper.alluserNumber();
	   
	return user;

}
   
	
	
	
	
	
	
	
   
   
	
	@ApiOperation(value = "查询所有用户", notes = "无条件查询所有的用户信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping("/Selectallusers")
	@ResponseBody

	
	public List<TableUser> allusers() {

		   
		
		List<TableUser> user = tableUserMapper.allusers();
	   
	return user;

}
   
   
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@ApiOperation(value = "使用用户名查询指定用户信息", notes = "使用用户名查询用户所有信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> Loginusers(@RequestBody String UserInfo, Model model) {

		List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);

		List<TableUser> user = tableUserMapper.UserInfo(json.get(0).getUsername());

		return user;
	}
	@ApiOperation(value = "使用用户名查询指定用户信息", notes = "使用用户名查询用户所有信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/SelectuserID", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> SelectuserID(@RequestBody String UserInfo, Model model) {

		List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);

		List<TableUser> user = tableUserMapper.SelectuserID(json.get(0).getId());

		return user;
	}
	
	
	
	
	
	
	

	@ApiOperation(value = "使用多重条件查询指定用户信息", notes = "使用多重条件查询指定用户", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/SelectUserCondition", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> SelectUserCondition(@RequestBody String UserInfo, Model model) {

		List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);

		List<TableUser> user = tableUserMapper.SelectUserCondition(json.get(0));

		return user;
	}
	
	
	

	@ApiOperation(value = "查询用户名是否存在", notes = "使用用户名查询用户名是否存在", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/SelectUsername", method = RequestMethod.POST)
	@ResponseBody
	public List<TableUser> SelectUsername(@RequestBody String UserInfo, Model model) {

		List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);

		List<TableUser> user = tableUserMapper.SelectUsername(json.get(0).getUsername());

		return user;
	}

	@ApiOperation(value = "新增一名用户", notes = "（需要管理员权限）新增一名用户  需要指定role :ROLE_ADMIN为管理员，ROLE_USER为用户 , enabled=1开启用户使用,=0未开启使用", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping("/UserInsert")
	@ResponseBody

	public List<TableUser> UserInsert(@RequestBody String UserInsert, Model model) {

		List<TableUser> json = JSON.parseArray(UserInsert, TableUser.class);

		json.get(0).setId(uuid());

		String rsausername = json.get(0).getUsername().toString();
		String rsapassword = json.get(0).getPassword().toString();
		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rsausername = RSAUtils.decryptBase64(rsausername);
		/* username.replaceAll("\"",""); */

		rsapassword = RSAUtils.decryptBase64(rsapassword);

		JSONObject usernameobj = new JSONObject(rsausername.toString()); // 在这里转换。
		JSONObject passwordobj = new JSONObject(rsapassword.toString()); // 在这里转换。

		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();

		json.get(0).setUsername(rsausername);
		json.get(0).setPassword(rsapassword);

		tableUserMapper.UserInsert(json.get(0));

		return json;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@ApiOperation(value = "使用ID删除用户", notes = "（需要管理员权限）使用用户ID删除用户", response = TableUser.class)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "id"),

	})
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	/* 在用 */
	@RequestMapping(value = "/DeleteUserid", method = RequestMethod.POST)
	@ResponseBody
	public String DeleteUserid(@RequestBody String Dmouldinfo) {
		List<TableUser> json = JSON.parseArray(Dmouldinfo, TableUser.class);
		int Dmouldinfos = tableUserMapper.DeleteUserid(json.get(0).getId());
		if (Dmouldinfos == 1)
			return "Success";
		else
			return "Error";

	}

	@ApiOperation(value = "使用用户名删除用户", notes = "（需要管理员权限）使用用户名删除用户", response = TableUser.class)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "id"),

	})
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	/* 在用 */
	@RequestMapping(value = "/DeleteUserName", method = RequestMethod.POST)
	@ResponseBody
	public String DeleteUserName(@RequestBody String Dmouldinfo) {
		List<TableUser> json = JSON.parseArray(Dmouldinfo, TableUser.class);
		int Dmouldinfos = tableUserMapper.DeleteUserName(json.get(0).getUsername());
		if (Dmouldinfos == 1)
			return "Success";
		else
			return "Error";
	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "以管理员身份修改用户信息", notes = "（需要管理员权限）以管理员身份修改用户信息，无需原始密码就可以修改用户密码,如需修改用户密码 请加密", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping("/AdminUpdateUser")
	@ResponseBody

	public List<TableUser> AdminUpdateUser(@RequestBody String UserInsert, Model model) throws UnsupportedEncodingException {

		String decodeStr = URLDecoder.decode(UserInsert.toString(),"UTF-8");
	
	
	
	
		
		List<TableUser> json = JSON.parseArray(decodeStr, TableUser.class);

		String rsausername = json.get(0).getUsername().toString();
		String rsapassword = json.get(0).getPassword().toString();
		String rsanewpassword = json.get(0).getNewpassword().toString();

		
		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");
			rsanewpassword = AesUtils.aesDecrypt(rsanewpassword, "abcdefgabcdefghi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rsausername = RSAUtils.decryptBase64(rsausername);
		/* username.replaceAll("\"",""); */

		rsapassword = RSAUtils.decryptBase64(rsapassword);
		rsanewpassword = RSAUtils.decryptBase64(rsanewpassword);
		
		
		
		
		JSONObject usernameobj = new JSONObject(rsausername.toString()); // 在这里转换。
		JSONObject passwordobj = new JSONObject(rsapassword.toString()); // 在这里转换。
		JSONObject newpasswordobj = new JSONObject(rsanewpassword.toString()); // 在这里转换。
		
		
		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();
		rsanewpassword = newpasswordobj.get("newpassword").toString();
		
		

		json.get(0).setUsername(rsausername);
		json.get(0).setPassword(rsapassword);
		json.get(0).setNewpassword(rsapassword);
		

		tableUserMapper.AdminUpdateUser(json.get(0));

		return json;

	}

	@ApiOperation(value = "用户身份修改用户信息", notes = "（需要管理员权限）以用户员身份修改用户信息", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping("/UpdateUser")
	@ResponseBody
	public List<TableUser> UpdateUser(@RequestBody String UserInsert, Model model) {
		List<TableUser> json = JSON.parseArray(UserInsert, TableUser.class);
		tableUserMapper.UpdateUser(json.get(0));

		return json;

	}

	@ApiOperation(value = "用户身份修改密码", notes = "以用户身份修改个人密码，需要个人原密码，需加密Post", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping("/Modifypassword")
	@ResponseBody
	public JSONObject Modifypassword(@RequestBody String UserInsert, Model model) {

		List<TableUser> json = JSON.parseArray(UserInsert, TableUser.class);

		String rsausername = json.get(0).getUsername().toString();
		String rsapassword = json.get(0).getPassword().toString();
		String rsanewpassword = json.get(0).getNewpassword().toString();
		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");
			rsanewpassword = AesUtils.aesDecrypt(rsanewpassword, "abcdefgabcdefghi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rsausername = RSAUtils.decryptBase64(rsausername);
		rsapassword = RSAUtils.decryptBase64(rsapassword);
		rsanewpassword = RSAUtils.decryptBase64(rsanewpassword);

		JSONObject usernameobj = new JSONObject(rsausername.toString()); // 在这里转换。
		JSONObject passwordobj = new JSONObject(rsapassword.toString()); // 在这里转换。
		JSONObject newpasswordobj = new JSONObject(rsanewpassword.toString()); // 在这里转换。

		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();
		rsanewpassword = newpasswordobj.get("newpassword").toString();

		json.get(0).setUsername(rsausername);
		json.get(0).setPassword(rsapassword);

		List<TableUser> olduserpassword = tableUserMapper.SelectUserpassword(json.get(0).getId());

		JSONObject ModifyPassword = new JSONObject();

		if (olduserpassword != null && olduserpassword.size() > 0) {
			if (rsapassword.equals(olduserpassword.get(0).getPassword())) {

				tableUserMapper.userudpassword(json.get(0));

				ModifyPassword.put("Modify_Password", "Success");
				return ModifyPassword;

			} else {

				ModifyPassword.put("Modify_Password", "Error");
				return ModifyPassword;

			}

		} else {

			ModifyPassword.put("Modify_Password", "Error");
			return ModifyPassword;

		}

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
