package com.ssm.config;


/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  
@EnableSwagger2
public class SwaggerConfig {  
	  
    @Bean  
    public Docket adminApi(){  
        return new Docket(DocumentationType.SWAGGER_2)  
                .groupName("Admin API")  
                .forCodeGeneration(true)  
                .pathMapping("/")            
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.ssm.controller"))
                .paths(paths())  
                .build()  
                .apiInfo(apiInfo())  
                .useDefaultResponseMessages(false);  
    }  
  
    private Predicate<String> paths(){  
        return Predicates.and(PathSelectors.regex("/.*"), Predicates.not(PathSelectors.regex("/error")));  
    }  
  
  
    private ApiInfo apiInfo(){  
        Contact contact = new Contact("Cchua", "https://github.com/vipcchua", "weibo.com/vipcchua");  
        return new ApiInfoBuilder()  
                .title("模具管理系统 Api")  
                .description("Spring-boot")  
                .license("Apache License Version 2.0")  
                .contact(contact)  
                .version("2.0")  
            
                .build();  
       
    }  
}  