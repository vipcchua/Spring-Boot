package com.ssm.controller;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.api.Session;
import com.ssm.mapper.TableInfoMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.model.TableInfo;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class Test {
	/*public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream inputStream =null;
		try {
			inputStream= Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		sqlSessionFactory.getConfiguration().addMapper(TableInfoMapper.class);
		TableInfoMapper tableInfoMapper = session.getMapper(TableInfoMapper.class);
		Tableinfo tableinfo=new Tableinfo();
		String jsonStr = "[{'id':'4041e51e-24d5-48e4-b6a7-cbdfdfb6f9f9','mouldNumber':'12','rfid':'12','productName':'12','customerName':'12','length':'12','width':'12','height':'12','cavityNumber':'12','applicableModels':'12','useRequirements':'12','mouldLife':'12','status':'12','remarks':'12'}]";
		List<Tableinfo> json = JSON.parseArray(jsonStr, Tableinfo.class);
		tableInfoMapper.addEmployeer(json.get(0));
		session.commit();
	}*/
    
}
