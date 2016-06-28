package com.fengyu.modules.webservice.project.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by guozheng on 2016/6/27.
 */
public class CrowdfundReturnsetRequestVo {

    private Integer projectNo;           //项目编号
    private BigDecimal price;            //支付金额
    private Integer numberLimits;       //名额
    private String returnContent;       //回报内容
    private String returnType;          //回报类型   goods 实物   invented 虚拟
    private String returnImageDesc;    //回报图片地址
    private String returnChannel;       //回报渠道 APP 手机专享 PC电脑专享 APPPERF
    private BigDecimal appPerfScale;    //手机优惠百分比
    private String remark;               //备注
    private Boolean postFlag;            //是否需要物流标志 0 不需要1 需要
    private BigDecimal courierFees;     //快递费
    private Boolean invoiceFlag;        //是否需要开具发票0不需要1需要
    private Integer returnDate;          //回报日期

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        this.returnContent = returnContent;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnImageDesc() {
        return returnImageDesc;
    }

    public void setReturnImageDesc(String returnImageDesc) {
        this.returnImageDesc = returnImageDesc;
    }

    public String getReturnChannel() {
        return returnChannel;
    }

    public void setReturnChannel(String returnChannel) {
        this.returnChannel = returnChannel;
    }

    public BigDecimal getAppPerfScale() {
        return appPerfScale;
    }

    public void setAppPerfScale(BigDecimal appPerfScale) {
        this.appPerfScale = appPerfScale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Integer returnDate) {
        this.returnDate = returnDate;
    }
}
