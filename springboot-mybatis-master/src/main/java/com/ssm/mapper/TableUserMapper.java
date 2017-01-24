package com.ssm.mapper;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import com.ssm.model.TableInfo;
import com.ssm.model.TableProduction;
import com.ssm.model.TableProductionSql;
import com.ssm.model.TableUser;
import com.ssm.model.TableUserSql;

import java.util.List;



import org.apache.ibatis.annotations.*;











@Mapper

public interface TableUserMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/
	@Select("SELECT *,(select COUNT(*) from table_user)as 'table_total' FROM table_user order by table_user.role limit #{page},#{pageRow}")
	List<TableUser> alluser(@Param("page") int page,@Param("pageRow") int pagerow);
	

	@Select("SELECT * FROM table_user")
	List<TableUser> allusers();
	
	
	@Select("select COUNT(*) as table_total FROM table_user")
	List<TableUser> alluserNumber();
	
	@SelectProvider(type = TableUserSql.class, method = "SelectUserCondition")  
	public List<TableUser> SelectUserCondition(TableUser tableUser);
	
	
	

	@Select("SELECT * FROM table_user where username = #{username}")
	List<TableUser> Loginusers (@Param("username") String username);
	
	
	@Select("SELECT * FROM table_user where id = #{id}")
	List<TableUser> SelectuserID (@Param("id") String id);
	
	
	@Select("SELECT id,username,name,role,enabled FROM table_user where username = #{username}")
	List<TableUser> UserInfo (@Param("username") String username);
	
	@Select("SELECT username FROM table_user where username = #{username}")
	List<TableUser> SelectUsername (@Param("username") String username);
	
	@Select("SELECT table_user.password FROM table_user where username = #{id}")
	List<TableUser> SelectUserpassword (@Param("id") String id);
	
	
/*--------------- -----<----*增加*---->--- ----------------------*/
	
	
	
	
	@Insert("INSERT INTO table_user"
			+ "(table_user.id,table_user.username,table_user.`password`,table_user.`name`,table_user.role,table_user.enabled) "
			+ "value (#{id},#{username},#{password},#{name},#{role},#{enabled})")
	
	public void UserInsert(TableUser tableUser);
	



	/*--------------- -----<----*删除*---->--- ----------------------*/
	@Delete("Delete FROM table_user where table_user.id=#{id}")
	int DeleteUserid (@Param("id") String uuid);
	
	
	@Delete("Delete FROM table_user where table_user.id=#{username}")
	int DeleteUserName (@Param("username") String username);


	/*--------------- -----<----*修改*---->--- ----------------------*/

	@UpdateProvider(type = TableUserSql.class, method = "UpdateUser")
	public void UpdateUser(TableUser tableUser);
	
	

	@UpdateProvider(type = TableUserSql.class, method = "AdminUpdateUser")
	public void AdminUpdateUser(TableUser tableUser);



	
	@Update("UPDATE table_user set table_user.`password`= #{newpassword} "
			+ "where table_user.`password`= #{password} and table_user.id= #{id} and table_user.username=#{username} ")
	public void userudpassword(TableUser tableUser);
	
	
	
	
	
	
	
	
	
	
}
