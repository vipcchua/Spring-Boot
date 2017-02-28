package com.ssm.model;

import java.sql.Date;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


public class TableInfo {
    /**
    * 序号
    */
    private String id;

    /**
    * 模具编号
    */
    private String mouldNumber;

    /**
    * 电子标签NO
    */
    private String rfid;

    /**
    * 产品名称
    */
    private String productName;

    /**
    * 客户名称
    */
    private String customerName;

    /**
    * 模腔数
    */
    private String cavityNumber;

    /**
    * 适用机型
    */
    private String applicableModels;

    /**
    * 使用要求
    */
    private String useRequirements;

    /**
    * 模具寿命
    */
    private String mouldLife;
    
    private String mouldLifeNumber;

    /**
    * 状态
    */
    private String status;

    /**
    * 备注
    */
    private String remarks;

    /**
    * 模具图片
    */
    private String mouldPictures;

    /**
    * 注塑参照表
    */
    private String mouldingTable;

    /**
    * 产品材料信息
    */
    private String materialInfo;

    /**
    * 作业指导书
    */
    private String operationGuiding;

    /**
    * 模具维保记录
    */
    private String maintenanceRecords;

    /**
    * 更新日期
    */
    private String updateDate;
    
    private String serialNumber;
    
    private int pageRow;
    
    private int page;

    private String sorting;
    
    private String repairRecord;
    
    private int tableTotal;
    
    





	public int getTableTotal() {
		return tableTotal;
	}

	public void setTableTotal(int tableTotal) {
		this.tableTotal = tableTotal;
	}

    
    public String getMouldLifeNumber() {
		return mouldLifeNumber;
	}

	public void setMouldLifeNumber(String mouldLifeNumber) {
		this.mouldLifeNumber = mouldLifeNumber;
	}

	public String getRepairRecord() {
		return repairRecord;
	}

	public void setRepairRecord(String repairRecord) {
		this.repairRecord = repairRecord;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMouldNumber() {
        return mouldNumber;
    }

    public void setMouldNumber(String mouldNumber) {
        this.mouldNumber = mouldNumber;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCavityNumber() {
        return cavityNumber;
    }

    public void setCavityNumber(String cavityNumber) {
        this.cavityNumber = cavityNumber;
    }

    public String getApplicableModels() {
        return applicableModels;
    }

    public void setApplicableModels(String applicableModels) {
        this.applicableModels = applicableModels;
    }

    public String getUseRequirements() {
        return useRequirements;
    }

    public void setUseRequirements(String useRequirements) {
        this.useRequirements = useRequirements;
    }

    public String getMouldLife() {
        return mouldLife;
    }

    public void setMouldLife(String mouldLife) {
        this.mouldLife = mouldLife;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMouldPictures() {
        return mouldPictures;
    }

    public void setMouldPictures(String mouldPictures) {
        this.mouldPictures = mouldPictures;
    }

    public String getMouldingTable() {
        return mouldingTable;
    }

    public void setMouldingTable(String mouldingTable) {
        this.mouldingTable = mouldingTable;
    }

    public String getMaterialInfo() {
        return materialInfo;
    }

    public void setMaterialInfo(String materialInfo) {
        this.materialInfo = materialInfo;
    }

    public String getOperationGuiding() {
        return operationGuiding;
    }

    public void setOperationGuiding(String operationGuiding) {
        this.operationGuiding = operationGuiding;
    }

    public String getMaintenanceRecords() {
        return maintenanceRecords;
    }

    public void setMaintenanceRecords(String maintenanceRecords) {
        this.maintenanceRecords = maintenanceRecords;
    }



	



	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}



	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}



    
    
}