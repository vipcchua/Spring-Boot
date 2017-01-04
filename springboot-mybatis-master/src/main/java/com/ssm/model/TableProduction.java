package com.ssm.model;

import java.util.Date;

public class TableProduction {
    private String productionId;

    /**
    * 订单编号
    */
    private String orderNumber;

    /**
    * 使用的模具Id
    */
    private String mouldNumber;

    /**
    * 模具的生产数量
    */
    private String productionLifenumber;

    /**
    * 生产维护
    */
    private String productionMaintain;

    /**
    * 模具修改次数
    */
    private String productionModify;

    /**
    * 生产时间
    */
    private Date productionTime;

    private Date createDate;

    private Date updateDate;

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMouldNumber() {
        return mouldNumber;
    }

    public void setMouldNumber(String mouldNumber) {
        this.mouldNumber = mouldNumber;
    }

    public String getProductionLifenumber() {
        return productionLifenumber;
    }

    public void setProductionLifenumber(String productionLifenumber) {
        this.productionLifenumber = productionLifenumber;
    }

    public String getProductionMaintain() {
        return productionMaintain;
    }

    public void setProductionMaintain(String productionMaintain) {
        this.productionMaintain = productionMaintain;
    }

    public String getProductionModify() {
        return productionModify;
    }

    public void setProductionModify(String productionModify) {
        this.productionModify = productionModify;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}