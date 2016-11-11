package com.ssm.model;

import org.apache.ibatis.jdbc.SQL;
import com.ssm.model.*;
public class TableInfoSql {
	public String UpdateTableInfo(final TableInfo tableInfo) {
		return new SQL() {
			{
				UPDATE("table_Info");
				
				if (tableInfo.getMouldNumber() != null) {
					SET("table_info.mould_number = #{mouldNumber}");
				}
			
				/*if (tableInfo.getRfid() != null) {
					SET("table_info.rfid = #{Rfid}");
				}
				if (tableInfo.getProductName()!= null) {
					SET("table_info.product_name = #{productName}");
				}
				if (tableInfo.getCustomerName() != null) {
					SET("table_info.customer_name = #{customerName}");
				}
				if (tableInfo.getLength() != null) {
					SET("table_info.length = #{length}");
				}
				if (tableInfo.getWidth() != null) {
					SET("table_info.width = #{width}");
				}
				if (tableInfo.getHeight() != null) {
					SET("table_info.height = #{height}");
				}
				if (tableInfo.getCavityNumber() != null) {
					SET("table_info.cavity_number = #{cavityNumber}");
				}
				if (tableInfo.getApplicableModels() != null) {
					SET("table_info.applicable_models = #{applicableModels}");
				}
				if (tableInfo.getUseRequirements() != null) {
					SET("table_info.use_requirements = #{useRequirements}");
				}
				
				if (tableInfo.getMouldLife() != null) {
					SET("table_info.mould_life = #{mouldLife}");
				}
				
				if (tableInfo.getStatus() != null) {
					SET("table_info.status = #{status}");
				}
				
				if (tableInfo.getRemarks() != null) {
					SET("table_info.remarks = #{remarks}");
				}*/
	
				
				WHERE("id = #{id}");
			}
		}.toString();
	}
}