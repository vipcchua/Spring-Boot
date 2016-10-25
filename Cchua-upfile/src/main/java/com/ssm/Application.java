package com.ssm;

import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan

public class Application {
	private static Logger logger = Logger.getLogger(Application.class);

	/********************************
	 * 2016年10月24日
	 * 
	 * By:Cchua
	 * 
	 ********************************/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("SpringBoot Start Success");
		logger.info("Author:Cchua");
		logger.info("GitHub:https://github.com/vipcchua");
		logger.info("Blog:weibo.com/vipcchua");
	}

}
