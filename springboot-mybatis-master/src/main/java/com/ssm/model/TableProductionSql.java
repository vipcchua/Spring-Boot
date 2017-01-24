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

public class TableProductionSql {

	public String UpdateTableProduction(final TableProduction tableProduction) {
		return new SQL() {
			{
				UPDATE("table_production");

				if (tableProduction.getOrderNumber() != null) {
					SET("table_production.order_number = #{orderNumber}");
				}

				if (tableProduction.getMouldNumber() != null) {
					SET("table_production.mould_number = #{mouldNumber}");
				}
				
				if (tableProduction.getProductionLifenumber() != null) {
					SET("table_production.production_lifeNumber = #{productionLifenumber}");
				}
				
				if (tableProduction.getProductionMaintain() != null) {
					SET("table_production.production_maintain = #{productionMaintain}");
				}
				
				if (tableProduction.getProductionModify() != null) {
					SET("table_production.production_modify = #{productionModify}");
				}
				
				if (tableProduction.getProductionTime() != null) {
					SET("table_production.production_time = #{productionTime}");
				}
				
				if (tableProduction.getCreateDate() != null) {
					SET("table_production.create_date = #{createDate}");
				}

				if (tableProduction.getUpdateDate() != null) {
					SET("table_production.update_date = #{updateDate}");
				}

				
				

				WHERE("table_production.production_id = #{productionId}");
			}
		}.toString();
	}

	
	
	
	
	
	public String InsertTableProduction(final TableProduction tableProduction) {

		return new SQL() {
			{
				INSERT_INTO("table_production");

				if (tableProduction.getProductionId() != null) {
					VALUES("table_production.production_id", "#{productionId}");
				}

				
				
				if (tableProduction.getOrderNumber() != null) {
					VALUES("table_production.order_number ", " #{orderNumber}");
				}

				if (tableProduction.getMouldNumber() != null) {
					VALUES("table_production.mould_number ", "#{mouldNumber}");
				}
				
				if (tableProduction.getProductionLifenumber() != null) {
					VALUES("table_production.production_lifeNumber ", " #{productionLifenumber}");
				}
				
				if (tableProduction.getProductionMaintain() != null) {
					VALUES("table_production.production_maintain ", " #{productionMaintain}");
				}
				
				if (tableProduction.getProductionModify() != null) {
					VALUES("table_production.production_modify ", " #{productionModify}");
				}
				
				
				
				if (tableProduction.getProductionTime() != null) {
					VALUES("table_production.production_time  ", "#{productionTime}");
				}
				
				if (tableProduction.getCreateDate() != null) {
					VALUES("table_production.create_date  ", " #{createDate}");
				}

				if (tableProduction.getUpdateDate() != null) {
					VALUES("table_production.update_date  ", " #{updateDate}");
				}

				
				
				
				
				

			}
		}.toString();
	}

	
	
	
	
	
	
	
	public String SelectTableProductionPage(final TableProduction tableProduction) {

		String SelectTableProductionPage = new SQL() {
			{
				SELECT("*");
				FROM("table_production");

			
				
				
				
				
				if (tableProduction.getProductionId() != null) {
	
					
					WHERE("table_production.production_id like CONCAT('%',#{productionId},'%')");
					
				}

				
				
				if (tableProduction.getOrderNumber() != null) {

					
					WHERE("table_production.order_number like CONCAT('%',#{orderNumber},'%')");
					
				}

				if (tableProduction.getMouldNumber() != null) {
		
					WHERE("table_production.mould_number like CONCAT('%',#{mouldNumber},'%')");
				}
				
				if (tableProduction.getProductionLifenumber() != null) {

					WHERE("table_production.production_lifeNumber like CONCAT('%',#{productionLifenumber},'%')");
				}
				
				if (tableProduction.getProductionMaintain() != null) {
			
					WHERE("table_production.production_maintain like CONCAT('%',#{productionMaintain},'%')");
				}
				
				if (tableProduction.getProductionModify() != null) {
			
					WHERE("table_production.production_modify like CONCAT('%',#{productionModify},'%')");
				}
				
				
				
				if (tableProduction.getProductionTime() != null) {
			
					WHERE("table_production.production_time like CONCAT('%',#{productionTime},'%')");
				}
				
				if (tableProduction.getCreateDate() != null) {
	
					WHERE("table_production.create_date like CONCAT('%',#{createDate},'%')");
				}

				if (tableProduction.getUpdateDate() != null) {
		
					WHERE("table_production.update_date like CONCAT('%',#{updateDate},'%')");
				}
				
			

			}
		}.toString();

		String page = " limit #{page},#{pageRow}";

		SelectTableProductionPage = SelectTableProductionPage + page;

		System.out.println(SelectTableProductionPage);
		return SelectTableProductionPage;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
