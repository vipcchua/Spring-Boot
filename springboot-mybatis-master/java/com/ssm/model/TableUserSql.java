package com.ssm.model;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import org.apache.ibatis.jdbc.SQL;
import com.ssm.model.*;
public class TableUserSql {
	
	
	public String UpdateUser(final TableUser tableUser) {
		return new SQL() {
			{
				UPDATE("table_user");

				if (tableUser.getName() != null) {
					SET("table_user.name = #{name}");
				}

	
				

				WHERE("table_user.id = #{id}");
			}
		}.toString();
	}
	
	public String AdminUpdateUser(final TableUser tableUser) {
		return new SQL() {
			{
				UPDATE("table_user");

				if (tableUser.getUsername() != null) {
					SET("table_user.username = #{username}");
				}
				
				if (tableUser.getPassword() != null) {
					SET("table_user.password = #{password}");
				}
				
				
				if (tableUser.getName() != null) {
					SET("table_user.name = #{name}");
				}

				if (tableUser.getRole() != null) {
					SET("table_user.role = #{role}");
				}
				
				if (tableUser.getEnabled() != null) {
					SET("table_user.enabled = #{enabled}");
				}
				
				

				WHERE("table_user.id = #{id}");
			}
		}.toString();
	}
	
	
	
	
	public String SelectUserCondition(final TableUser tableUser) {


	
		String SelectUserCondition = new SQL() {
		{
			SELECT("*");
			FROM("table_user");
			
			if (tableUser.getId() != null) {
				WHERE("table_user.id = #{id}");
			}
			
			
			if (tableUser.getUsername() != null) {
				WHERE("table_user.username like CONCAT('%',#{username},'%')");
			}
			
			if (tableUser.getPassword() != null) {
				WHERE("table_user.password = #{password})");
			}
			
			
			if (tableUser.getName() != null) {
				WHERE("table_user.name like CONCAT('%',#{name},'%')");
			}

			if (tableUser.getRole() != null) {
				WHERE("table_user.role  like CONCAT('%',#{role},'%')");
			}
			
			if (tableUser.getEnabled() != null) {
				WHERE("table_user.enabled like CONCAT('%',#{enabled},'%')");
			}
			
			
			
		}
	}.toString();

	 
	String topage=tableUser.getPage() +""; 

	String topagerow=tableUser.getPageRow() +""; 
	

/*	
	if ("".equals(topagerow)
		&& "".equals(topage)
			) {*/
		

	String page = " limit #{page},#{pageRow}";

	SelectUserCondition = SelectUserCondition + page;

	System.out.println(SelectUserCondition);
/*	}*/
	/**/
	
	return SelectUserCondition;
	
	
	
	
	}
		
	
}