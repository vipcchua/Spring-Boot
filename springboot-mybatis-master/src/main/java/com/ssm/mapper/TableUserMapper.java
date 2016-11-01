package com.ssm.mapper;

import com.ssm.model.TableUser;


import java.util.List;



import org.apache.ibatis.annotations.*;











@Mapper

public interface TableUserMapper {
	
	@Select("SELECT * FROM table_user")
	List<TableUser> Loginuser ();


	
}
