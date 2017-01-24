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

public class TableInfoSql {

	public String UpdateTableInfo(final TableInfo tableInfo) {
		return new SQL() {
			{
				UPDATE("table_info");

				if (tableInfo.getMouldNumber() != null) {
					SET("table_info.mould_number = #{mouldNumber}");
				}

				if (tableInfo.getRfid() != null) {
					SET("table_info.rfid = #{rfid}");
				}
				if (tableInfo.getProductName() != null) {
					SET("table_info.product_name = #{productName}");
				}
				if (tableInfo.getCustomerName() != null) {
					SET("table_info.customer_name = #{customerName}");
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
				}

				if (tableInfo.getUpdateDate() != null) {
					SET("table_info.update_date = #{updateDate}");
				}

				if (tableInfo.getMouldPictures() != null) {
					SET("table_info.mould_pictures = #{mouldPictures}");
				}

				if (tableInfo.getMouldingTable() != null) {
					SET("table_info.moulding_table = #{mouldingTable}");
				}

				if (tableInfo.getMaterialInfo() != null) {
					SET("table_info.material_info = #{materialInfo}");
				}

				if (tableInfo.getOperationGuiding() != null) {
					SET("table_info.operation_guiding = #{operationGuiding}");
				}

				if (tableInfo.getMaintenanceRecords() != null) {
					SET("table_info.maintenance_records = #{maintenanceRecords}");
				}

				if (tableInfo.getSerialNumber() != null) {
					SET("table_info.serial_number = #{serialNumber}");
				}

				WHERE("id = #{id}");
			}
		}.toString();
	}

	public String SelectTableInfo(final TableInfo tableInfo) {

		return new SQL() {
			{
				SELECT("*");
				FROM("table_info");

				if (tableInfo.getId() != null) {
					WHERE("id = #{id}");
				}

				if (tableInfo.getMouldNumber() != null) {
					WHERE("table_info.mould_number = #{mouldNumber}");

				}

				if (tableInfo.getRfid() != null) {
					WHERE("table_info.rfid = #{rfid}");
				}
				if (tableInfo.getProductName() != null) {
					WHERE("table_info.product_name = #{productName}");
				}
				if (tableInfo.getCustomerName() != null) {
					WHERE("table_info.customer_name = #{customerName}");
				}

				if (tableInfo.getCavityNumber() != null) {
					WHERE("table_info.cavity_number = #{cavityNumber}");
				}
				if (tableInfo.getApplicableModels() != null) {
					WHERE("table_info.applicable_models = #{applicableModels}");
				}
				if (tableInfo.getUseRequirements() != null) {
					WHERE("table_info.use_requirements = #{useRequirements}");
				}

				if (tableInfo.getMouldLife() != null) {
					WHERE("table_info.mould_life = #{mouldLife}");
				}

				if (tableInfo.getStatus() != null) {
					WHERE("table_info.status = #{status}");
				}

				if (tableInfo.getRemarks() != null) {
					WHERE("table_info.remarks = #{remarks}");
				}

				if (tableInfo.getUpdateDate() != null) {
					WHERE("table_info.update_date = #{updateDate}");
				}

				if (tableInfo.getMouldPictures() != null) {
					WHERE("table_info.mould_pictures = #{mouldPictures}");
				}

				if (tableInfo.getMouldingTable() != null) {
					WHERE("table_info.moulding_table = #{mouldingTable}");
				}

				if (tableInfo.getMaterialInfo() != null) {
					WHERE("table_info.material_info = #{materialInfo}");
				}

				if (tableInfo.getOperationGuiding() != null) {
					WHERE("table_info.operation_guiding = #{operationGuiding}");
				}

				if (tableInfo.getMaintenanceRecords() != null) {
					WHERE("table_info.maintenance_records = #{maintenanceRecords}");
				}

				if (tableInfo.getSerialNumber() != null) {
					WHERE("table_info.serial_number = #{serialNumber}");
				}

			}
		}.toString();

	}

	public String SelectTableInfoPage(final TableInfo tableInfo) {

		String SelectTableInfoPage = new SQL() {
			{
				SELECT("*");
				FROM("table_info");

				if (tableInfo.getId() != null) {
					WHERE("id = #{id}");
				}

				if (tableInfo.getMouldNumber() != null) {
					WHERE("table_info.mould_number like CONCAT('%',#{mouldNumber},'%')");

				}

				if (tableInfo.getRfid() != null) {
					WHERE("table_info.rfid like CONCAT('%',#{rfid},'%')");
				}
				if (tableInfo.getProductName() != null) {
					WHERE("table_info.product_name like CONCAT('%',#{productName},'%')");
				}
				if (tableInfo.getCustomerName() != null) {
					WHERE("table_info.customer_name like CONCAT('%', #{customerName},'%')");
				}

				if (tableInfo.getCavityNumber() != null) {
					WHERE("table_info.cavity_number like CONCAT('%',#{cavityNumber},'%')");
				}
				if (tableInfo.getApplicableModels() != null) {
					WHERE("table_info.applicable_models like CONCAT('%',#{applicableModels},'%')");
				}
				if (tableInfo.getUseRequirements() != null) {
					WHERE("table_info.use_requirements like CONCAT('%',#{useRequirements},'%')");
				}

				if (tableInfo.getMouldLife() != null) {
					WHERE("table_info.mould_life like CONCAT('%',#{mouldLife},'%')");
				}

				if (tableInfo.getStatus() != null) {
					WHERE("table_info.status like CONCAT('%',#{status},'%')");
				}

				if (tableInfo.getRemarks() != null) {
					WHERE("table_info.remarks like CONCAT('%',#{remarks},'%')");
				}

				if (tableInfo.getUpdateDate() != null) {
					WHERE("table_info.update_date like CONCAT('%',#{updateDate},'%')");
				}

				if (tableInfo.getMouldPictures() != null) {
					WHERE("table_info.mould_pictures like CONCAT('%',#{mouldPictures},'%')");
				}

				if (tableInfo.getMouldingTable() != null) {
					WHERE("table_info.moulding_table like CONCAT('%',#{mouldingTable},'%')");
				}

				if (tableInfo.getMaterialInfo() != null) {
					WHERE("table_info.material_info like CONCAT('%',#{materialInfo},'%')");
				}

				if (tableInfo.getOperationGuiding() != null) {
					WHERE("table_info.operation_guiding like CONCAT('%',#{operationGuiding},'%')");
				}

				if (tableInfo.getMaintenanceRecords() != null) {
					WHERE("table_info.maintenance_records like CONCAT('%',#{maintenanceRecords},'%')");
				}

				if (tableInfo.getSerialNumber() != null) {
					WHERE("table_info.serial_number like CONCAT('%',#{serialNumber},'%')");
				}

				if (tableInfo.getSorting() != null) {
					ORDER_BY("#{sorting}");
				}

			}
		}.toString();

		String page = " limit #{page},#{pageRow}";

		SelectTableInfoPage = SelectTableInfoPage + page;

		System.out.println(SelectTableInfoPage);
		return SelectTableInfoPage;

	}

	/*
	 * 
	 * public String SelectTableInfoPage(final TableInfo tableInfo) {
	 * 
	 * 
	 * 
	 * String SelectTableInfoPage = new SQL() { { SELECT("*");
	 * FROM("table_info");
	 * 
	 * if (tableInfo.getId() != null) { WHERE("id = #{id}"); }
	 * 
	 * 
	 * if (tableInfo.getMouldNumber() != null) {
	 * WHERE("table_info.mould_number = #{mouldNumber}");
	 * 
	 * }
	 * 
	 * if (tableInfo.getRfid() != null) { WHERE("table_info.rfid = #{rfid}"); }
	 * if (tableInfo.getProductName()!= null) {
	 * WHERE("table_info.product_name = #{productName}"); } if
	 * (tableInfo.getCustomerName() != null) {
	 * WHERE("table_info.customer_name = #{customerName}"); }
	 * 
	 * if (tableInfo.getCavityNumber() != null) {
	 * WHERE("table_info.cavity_number = #{cavityNumber}"); } if
	 * (tableInfo.getApplicableModels() != null) {
	 * WHERE("table_info.applicable_models = #{applicableModels}"); } if
	 * (tableInfo.getUseRequirements() != null) {
	 * WHERE("table_info.use_requirements = #{useRequirements}"); }
	 * 
	 * if (tableInfo.getMouldLife() != null) {
	 * WHERE("table_info.mould_life = #{mouldLife}"); }
	 * 
	 * if (tableInfo.getStatus() != null) {
	 * WHERE("table_info.status = #{status}"); }
	 * 
	 * if (tableInfo.getRemarks() != null) {
	 * WHERE("table_info.remarks = #{remarks}"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if (tableInfo.getUpdateDate() != null) {
	 * WHERE("table_info.update_date = #{updateDate}"); }
	 * 
	 * 
	 * if (tableInfo.getMouldPictures() != null) {
	 * WHERE("table_info.mould_pictures = #{mouldPictures}"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if (tableInfo.getMouldingTable() != null) {
	 * WHERE("table_info.moulding_table = #{mouldingTable}"); }
	 * 
	 * 
	 * if (tableInfo.getMaterialInfo() != null) {
	 * WHERE("table_info.material_info = #{materialInfo}"); }
	 * 
	 * 
	 * if (tableInfo.getOperationGuiding() != null) {
	 * WHERE("table_info.operation_guiding = #{operationGuiding}"); }
	 * 
	 * 
	 * if (tableInfo.getMaintenanceRecords() != null) {
	 * WHERE("table_info.maintenance_records = #{maintenanceRecords}"); }
	 * 
	 * 
	 * 
	 * 
	 * if (tableInfo.getSerialNumber() != null) {
	 * WHERE("table_info.serial_number = #{serialNumber}"); }
	 * 
	 * 
	 * if (tableInfo.getSorting() != null) { ORDER_BY("#{sorting}"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } } .toString();
	 * 
	 * String page = " limit #{page},#{pageRow}";
	 * 
	 * SelectTableInfoPage = SelectTableInfoPage + page ;
	 * 
	 * System.out.println(SelectTableInfoPage); return SelectTableInfoPage;
	 * 
	 * }
	 * 
	 */

	public String InsertTableInfo(final TableInfo tableInfo) {

		return new SQL() {
			{
				INSERT_INTO("table_info");

				if (tableInfo.getId() != null) {

					VALUES("id", "#{id}");

				}

				if (tableInfo.getMouldNumber() != null) {
					VALUES("table_info.mould_number ", "#{mouldNumber}");

				}

				if (tableInfo.getRfid() != null) {
					VALUES("table_info.rfid ", " #{rfid}");
				}
				if (tableInfo.getProductName() != null) {
					VALUES("table_info.product_name ", " #{productName}");
				}
				if (tableInfo.getCustomerName() != null) {
					VALUES("table_info.customer_name", " #{customerName}");
				}

				if (tableInfo.getCavityNumber() != null) {
					VALUES("table_info.cavity_number", " #{cavityNumber}");
				}
				if (tableInfo.getApplicableModels() != null) {
					VALUES("table_info.applicable_models ", "#{applicableModels}");
				}
				if (tableInfo.getUseRequirements() != null) {
					VALUES("table_info.use_requirements ", " #{useRequirements}");
				}

				if (tableInfo.getMouldLife() != null) {
					VALUES("table_info.mould_life ", " #{mouldLife}");
				}

				if (tableInfo.getStatus() != null) {
					VALUES("table_info.status ", "#{status}");
				}

				if (tableInfo.getRemarks() != null) {
					VALUES("table_info.remarks ", " #{remarks}");
				}

				if (tableInfo.getUpdateDate() != null) {
					VALUES("table_info.update_date ", " #{updateDate}");
				}

				if (tableInfo.getMouldPictures() != null) {
					VALUES("table_info.mould_pictures ", " #{mouldPictures}");
				}

				if (tableInfo.getMouldingTable() != null) {
					VALUES("table_info.moulding_table ", " #{mouldingTable}");
				}

				if (tableInfo.getMaterialInfo() != null) {
					VALUES("table_info.material_info ", " #{materialInfo}");
				}

				if (tableInfo.getOperationGuiding() != null) {
					VALUES("table_info.operation_guiding ", "#{operationGuiding}");
				}

				if (tableInfo.getMaintenanceRecords() != null) {
					VALUES("table_info.maintenance_records ", "#{maintenanceRecords}");
				}

				if (tableInfo.getSerialNumber() != null) {
					VALUES("table_info.serial_number", "#{serialNumber}");
				}

			}
		}.toString();
	}

}