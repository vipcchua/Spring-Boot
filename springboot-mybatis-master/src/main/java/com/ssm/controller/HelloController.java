package com.ssm.controller;
 
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class HelloController {
 
    private Logger logger = Logger.getLogger(HelloController.class);
 
    /*
    *   http://localhost:8080/hello?name=cn.7player
     */
 /*
    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        logger.info("hello");
        model.addAttribute("name", name);
      System.out.println(name+"撒的撒的很少是uf骄傲啥都if就偶是滴啊佛i啊哈哈赛欧粉红丝带配合的送皮肤上大佛皮1");
        return "hello";
    }
    */

    
	  @RequestMapping("/")
	    public String index() {
	        return "index";
	    }
	    @RequestMapping("/hello")
	    public String hello() {
	        return "hello";
	    }
	    
	    
	    @RequestMapping("/login")
	    public String login() {
	        System.out.println("撒的撒的很少是uf骄傲啥都if就偶是滴啊佛i啊哈哈赛欧粉红丝带配合的送皮肤上大佛皮1");
	        return "login";
	    }
	    
	    

    
    
    
}