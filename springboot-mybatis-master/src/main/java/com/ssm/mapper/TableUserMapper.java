package com.ssm.mapper;

import com.ssm.model.TableUser;


import java.util.List;



import org.apache.ibatis.annotations.*;











@Mapper

public interface TableUserMapper {
	
	@Select("SELECT * FROM table_user")
	List<TableUser> Loginuser ();


	@Select("SELECT * FROM table_user where e table_user.username=#{username} ")
	List<TableUser> Loginusers (@Param("username") String username);

	
	
	
}
