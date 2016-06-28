package com.fengyu.modules.model;

import com.fengyu.common.persistence.DataEntity;

import java.math.BigDecimal;

public class CrowdfundReturnset  extends DataEntity<CrowdfundReturnset>{
    private Integer id;

    private Integer projectNo;

    private String returnNo;

    private Integer numberLimits;

    private String returnContent;

    private String returnType;

    private Integer returnDate;

    private String state;

    private String returnImageDesc;

    private String returnChannel;

    private BigDecimal appPerfScale;

    private BigDecimal price;

    private String remark;

    private Boolean postFlag;

    private BigDecimal courierFees;

    private Boolean invoiceFlag;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public Integer getNumberLimits() {
        return numberLimits;
    }

    public void setNumberLimits(Integer numberLimits) {
        this.numberLimits = numberLimits;
    }

    public String getReturnContent() {
        return returnContent;
    }

    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent == null ? null : returnContent.trim();
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    public Integer getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Integer returnDate) {
        this.returnDate = returnDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getReturnImageDesc() {
        return returnImageDesc;
    }

    public void setReturnImageDesc(String returnImageDesc) {
        this.returnImageDesc = returnImageDesc == null ? null : returnImageDesc.trim();
    }

    public String getReturnChannel() {
        return returnChannel;
    }

    public void setReturnChannel(String returnChannel) {
        this.returnChannel = returnChannel == null ? null : returnChannel.trim();
    }

    public BigDecimal getAppPerfScale() {
        return appPerfScale;
    }

    public void setAppPerfScale(BigDecimal appPerfScale) {
        this.appPerfScale = appPerfScale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getPostFlag() {
        return postFlag;
    }

    public void setPostFlag(Boolean postFlag) {
        this.postFlag = postFlag;
    }

    public BigDecimal getCourierFees() {
        return courierFees;
    }

    public void setCourierFees(BigDecimal courierFees) {
        this.courierFees = courierFees;
    }

    public Boolean getInvoiceFlag() {
        return invoiceFlag;
    }

    public void setInvoiceFlag(Boolean invoiceFlag) {
        this.invoiceFlag = invoiceFlag;
    }
}