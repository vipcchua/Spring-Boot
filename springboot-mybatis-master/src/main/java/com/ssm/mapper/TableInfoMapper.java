package com.ssm.mapper;

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
	@Results({  
		@Result(id=true, column="stud_id", property="studId"),  
		@Result(column="name", property="name"),  
		@Result(column="email", property="email"),  
		@Result(column="addr_id", property="address.addrId")  
	})  
	
	
	List<TableInfo> selectallmodel (@Param("mouldNumber") String string);



	
	
	@Update("UPDATE table_info SET #{mouldNumber},#{rfid},#{productName},#{customerName},#{length},"
			+ "#{width},#{height},#{cavityNumber}," + "#{applicableModels},#{useRequirements},"
			+ "#{mouldLife},#{status}," + "#{remarks}  WHERE table_info.id= #{id}")
	public void udtableinfos(TableInfo tableinfo);	
	


	@UpdateProvider(type = TableInfoSql.class, method = "UpdateTableInfo")
	public void udtableinfo(TableInfo tableInfo);
	
	/*
	int udtableinfo(TableInfoUpdate tableInfoUpdate);  
	
	*/

	
	
	
	
	
	
	@Select("SELECT * from table_info")
	List<TableInfo> deb();

	@Select("SELECT * from table_info")
	List<TableInfo> dec();

	@Select("SELECT * FROM  table_info")
	List<TableInfo> modelall();
	
	@Delete("Delete FROM table_info where table_info.id=#{id}")
	int Dmouldinfo (@Param("id") String uuid);
	
	

	@Insert("INSERT INTO table_info VALUES(#{id},#{mouldNumber},#{rfid},#{productName},#{customerName},#{length},"
			+ "#{width},#{height},#{cavityNumber}," + "#{applicableModels},#{useRequirements},"
			+ "#{mouldLife},#{status}," + "#{remarks})")
	int insertmould(@Param("id") String uuid, @Param("mouldNumber") String mouldNumber, @Param("rfid") String rfid,
			@Param("productName") String productName, @Param("customerName") String customerName,
			@Param("width") Double width, @Param("length") Double length, @Param("height") Double height,
			@Param("cavityNumber") Long cavityNumber, @Param("applicableModels") String applicableModels,
			@Param("useRequirements") String useRequirements, @Param("mouldLife") String mouldLife,
			@Param("status") String status, @Param("remarks") String remarks);

	
	
	
	
	
	/*
	@Insert("INSERT INTO table_info VALUES(#{mouldlist})")

	public int bb(@Param("mouldlist") List<Tableinfo> json

	);*/

	/*
	 * int bb(@Param("id")String uuid,
	 * 
	 * @Param("mouldNumber") String mouldNumber,
	 * 
	 * @Param("rfid") String rfid,
	 * 
	 * @Param("productName") String productName,
	 * 
	 * @Param("customerName") String customerName,
	 * 
	 * @Param("width") Double width,
	 * 
	 * @Param("length") Double length,
	 * 
	 * @Param("height") Double height,
	 * 
	 * @Param("cavityNumber") Long cavityNumber,
	 * 
	 * @Param("applicableModels") String applicableModels,
	 * 
	 * @Param("useRequirements") String useRequirements,
	 * 
	 * @Param("mouldLife") String mouldLife,
	 * 
	 * @Param("status") String status,
	 * 
	 * @Param("remarks") String remarks);
	 */

	@Insert("INSERT INTO table_info VALUES(#{id},#{mouldNumber},#{rfid},#{productName},#{customerName},#{length},"
			+ "#{width},#{height},#{cavityNumber}," + "#{applicableModels},#{useRequirements},"
			+ "#{mouldLife},#{status}," + "#{remarks})")
	public void addEmployeer(TableInfo tableinfo);




	
	
	
	
	
}
