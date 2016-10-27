package com.ssm.model;

import java.util.Date;

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
    private Long cavityNumber;

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
    private String photo;

    private String documentation;

    private String excel;

    private Date updateDate;

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

    public Long getCavityNumber() {
        return cavityNumber;
    }

    public void setCavityNumber(Long cavityNumber) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getExcel() {
        return excel;
    }

    public void setExcel(String excel) {
        this.excel = excel;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}