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
import com.ssm.model.TableProduction;
import com.ssm.model.TableProductionSql;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.sound.midi.MidiDevice.Info;

import org.apache.ibatis.annotations.*;

@Mapper

public interface TableProductionMapper {
	public TableProduction findUserInfo();
/*--------------- -----<----*查询*---->--- ----------------------*/
	@Select("SELECT * FROM table_production WHERE order_number = #{orderNumber}")
	List<TableProduction> productionorderNumber (@Param("orderNumber") String string);

	@Select("SELECT * FROM table_production WHERE mould_number = #{mouldNumber}")
	List<TableProduction> productionmouldNumber (@Param("mouldNumber") String string);
	
	@Select("SELECT * FROM table_production WHERE production_id = #{productionId}")
	List<TableProduction> selectproductionid (@Param("productionId") String string);
	
	@Select("SELECT * FROM   table_production")
	List<TableProduction> productionall();
	
	
	@Select("SELECT * FROM  table_production order by table_production.production_time limit #{page},#{pageRow}")
	List<TableProduction> productionallpage(@Param("page") int page,@Param("pageRow")  int pagerow);
	
	
	@SelectProvider(type = TableProductionSql.class, method = "SelectTableProductionPage")  
	public List<TableProduction> SelectTableProductionPage(TableProduction tableProduction);
	
	

/*--------------- -----<----*增加*---->--- ----------------------*/
	
	
	
	@InsertProvider(type = TableProductionSql.class, method = "InsertTableProduction")  
	public void InsertTableProduction(TableProduction tableProduction);
	


/*--------------- -----<----*删除*---->--- ----------------------*/
	
	
	
	
	
	@Delete("Delete FROM table_production where table_production.production_id=#{productionId}")
	int Deleteproduction (@Param("productionId") String uuid);
	

	

/*--------------- -----<----*修改*---->--- ----------------------*/
	
	@UpdateProvider(type = TableProductionSql.class, method = "UpdateTableProduction")
	public void UpdateTableProduction(TableProduction tableProduction);
	
	
	


	
}
