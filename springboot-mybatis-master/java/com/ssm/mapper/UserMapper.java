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


import com.ssm.model.User;

import java.util.List;

import org.apache.ibatis.annotations.*;


@Mapper

public interface UserMapper {
    public User findUserInfo();
    
  /*  @Select("select *from USER")
    public List<User> finAll();*/
    
   
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    List<User> findByName(@Param("name") String name);
    
    
    
    @Select("SELECT * FROM USER WHERE NAME = #{name} and passwork =#{password}")
    List<User> login(@Param("name") String name,@Param("password") String passwork);

    
 
    
    
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    int update(@Param("name") String name, @Param("age") Integer age);
    
    @Delete("DELETE FROM user WHERE id =#{id}")
    int delete(Long id);
    
    @Delete("DELETE FROM user WHERE name=#{id}")
    List<User> deletename(String name);


    
}
