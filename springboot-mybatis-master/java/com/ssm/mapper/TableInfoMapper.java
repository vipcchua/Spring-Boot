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
import com.ssm.model.TableInfoSql;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.sound.midi.MidiDevice.Info;

import org.apache.ibatis.annotations.*;

@Mapper

public interface TableInfoMapper {
	public TableInfo findUserInfo();

	@Select("SELECT * FROM table_info WHERE mould_number = #{mouldNumber}")
	/*@Results({  
		@Result(id=true, column="stud_id", property="studId"),  
		@Result(column="name", property="name"),  
		@Result(column="email", property="email"),  
		@Result(column="addr_id", property="address.addrId")  
	})  */
	
	List<TableInfo> selectallmodel (@Param("mouldNumber") String string);

		
	
	@Select("SELECT * FROM table_info WHERE id = #{id}")
	List<TableInfo> selectmodeuid (@Param("id") String string);
	
	/*
	@Select("SELECT * ,(SELECT count(1) AS counts FROM table_production where table_production.repair_record ='1' AND mould_number = (SELECT table_info.mould_number from table_info where table_info.id = #{id}) ) as 'repair_record',(SELECT   sum(table_production.production_lifeNumber) AS counts  FROM table_production where mould_number = (SELECT table_info.mould_number  from table_info where table_info.id= #{id}) ) as 'mould_lifeNumber' FROM table_info where table_info.id = #{id}")
		List<TableInfo> selectmodeuid (@Param("id") String string);
*/
	
	
	
	@Update("UPDATE table_info SET #{mouldNumber},#{rfid},#{productName},#{customerName},"
			+ "#{cavityNumber}," + "#{applicableModels},#{useRequirements},"
			+ "#{mouldLife},#{status}," + "#{remarks}  WHERE table_info.id= #{id}")
	public void udtableinfos(TableInfo tableinfo);	
	
	@UpdateProvider(type = TableInfoSql.class, method = "UpdateTableInfo")
	public void Udtableinfo(TableInfo tableInfo);
		

	
	/*
	int udtableinfo(TableInfoUpdate tableInfoUpdate);  
	
	*/

	@Select("SELECT * FROM  table_info")
	List<TableInfo> modelall();
	

	
	
	@Delete("Delete FROM table_info where table_info.id=#{id}")
	int Dmouldinfo (@Param("id") String uuid);
	
	

	@Insert("INSERT INTO table_info VALUES(#{id},#{mouldNumber},#{rfid},#{productName},#{customerName},"
			+ "#{cavityNumber}," + "#{applicableModels},#{useRequirements},"
			+ "#{mouldLife},#{status}," + "#{remarks})")
	int insertmould(@Param("id") String uuid, @Param("mouldNumber") String mouldNumber, @Param("rfid") String rfid,
			@Param("productName") String productName, @Param("customerName") String customerName,
			@Param("width") Double width, @Param("length") Double length, @Param("height") Double height,
			@Param("cavityNumber") Long cavityNumber, @Param("applicableModels") String applicableModels,
			@Param("useRequirements") String useRequirements, @Param("mouldLife") String mouldLife,
			@Param("status") String status, @Param("remarks") String remarks);

/*
	@Insert("INSERT INTO table_info VALUES(#{id},#{mouldNumber},#{rfid},#{productName},#{customerName},"
			+ "#,#{cavityNumber}," + "#{applicableModels},#{useRequirements},"
			+ "#{mouldLife},#{status}," + "#{remarks},#{photo})")
	public void addEmployeers(TableInfo tableinfo);
*/

	
	
	@SelectProvider(type = TableInfoSql.class, method = "SelectTableInfo")  
	
	public List<TableInfo> SelectTableInfo(TableInfo tableInfo);
	
	@Select("select *,(select COUNT(*) from table_info)as 'table_total' from table_info order by  table_info.id limit #{page},#{pageRow}")
	List<TableInfo> modelallpaging();
	
	
	
	@SelectProvider(type = TableInfoSql.class, method = "SelectTableInfoPage")  
	
	public List<TableInfo> SelectTableInfoPage(TableInfo tableInfo);
	
	
	/*
	@Select("select * from table_info order by  table_info.id limit #{page},#{pageRow}")
	
	public List<TableInfo> SelectTableInfoPage( @Param("page") int page,@Param("pageRow") int pageRow);
	*/
	
	
	
	
	
	
	@InsertProvider(type = TableInfoSql.class, method = "InsertTableInfo")  
	@Options(useGeneratedKeys=true, keyProperty="tutorId") 
	public void InsertTableInfo(TableInfo tableInfo);
	
	
	
	
	
	@Insert("INSERT INTO table_info(table_info.id,table_info.rfid,table_info.product_name,table_info.customer_name) "
			+ "value (#{id},#{rfid},#{productName},#{customerName}) ")
	public void addEmployeer(TableInfo tableinfo);


	
	
	
	public TableInfoMapper findByName(String username);

	
	
	
	
	
	
	
	
	
	
	
	

	
}
