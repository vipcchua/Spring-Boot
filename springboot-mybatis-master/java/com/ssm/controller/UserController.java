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




import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.mapper.TableInfoMapper;
import com.ssm.mapper.UserMapper;

import com.ssm.model.TableInfo;
import com.ssm.model.User;

import springfox.documentation.annotations.ApiIgnore;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@ApiIgnore
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	/*
	 * @Autowired private UserService userService;
	 */ 
	
	@Autowired
	private UserMapper userMapper;
	
	
	

	@RequestMapping("/Userinsert")
	@ResponseBody
	public int greeting(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "age", required = false) int age, Model model) {

		/**
		 * http://localhost:8080/insert?name=11&age=11
		 */
		int user = this.userMapper.insert(name, age);
		System.out.println("但是");
		return user;

	}

	@RequestMapping("/UserUpdate")
	@ResponseBody
	public int Update(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "age", required = false) Integer age, Model model) {

		/**
		 * http://localhost:8080/Update?name=11&age=77 OK
		 * 
		 */

		/*
		 * model.addAttribute("name", name); model.addAttribute("age", age);
		 * userMapper.update(name, age); List<User> u =
		 * userMapper.findByName(name); return u;
		 */

		int user = this.userMapper.update(name, age);

		return user;

	}

	@RequestMapping("/UserSelect")
	@ResponseBody
	public List<User> Select(@RequestParam(value = "name", required = false) String name, Model model) {
		/* logger.info("hello"); */
		/*
		 * 
		 * http://localhost:8080/UserSelect?name=11 Ok json 过
		 */
		/* ArrayList<User> list = new ArrayList<User>(); */
		/* List<User> users = userMapper.finAll(); */

		/*
		 * model.addAttribute("name", name); userMapper.findByName(name);
		 * List<User> u = userMapper.findByName(name);
		 */

		List<User> user = this.userMapper.findByName(name);
		return user;
	}

	@RequestMapping("/UserDelete")
	@ResponseBody
	public int Delete(@RequestParam(value = "id", required = false) Long id, Model model) {
		/* logger.info("hello"); */

		/*
		 * model.addAttribute("id", id); userMapper.delete(id);
		 * System.out.println(model);
		 */

		/* List<User> u = userMapper.findByName(name); */

		int user = this.userMapper.delete(id);
		return user;

	}

	@RequestMapping("/Deletename")
	@ResponseBody
	public List<User> Deletename(@RequestParam(value = "name", required = false) String name, Model model) {

		/*
		 * 
		 * http://localhost:8080/Deletename?name=11 Ok
		 * 
		 */

		List<User> user = this.userMapper.deletename(name);

		
		
		
		
		return user;

	}



	
	
	
	
	
	
}
