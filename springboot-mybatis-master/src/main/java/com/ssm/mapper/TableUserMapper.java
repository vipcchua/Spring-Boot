package com.ssm.mapper;

import com.ssm.model.TableUser;


import java.util.List;



import org.apache.ibatis.annotations.*;











@Mapper

public interface TableUserMapper {
	
	@Select("SELECT * FROM table_user")
	List<TableUser> Loginuser ();


	@Select("SELECT * FROM table_user where username = #{username}")
	List<TableUser> Loginusers (@Param("username") String username);
	
	@Select("SELECT id,username,name,role,enabled FROM table_user where username = #{username}")
	List<TableUser> UserInfo (@Param("username") String username);
	
	
	
}
