package com.fengyu.modules.webservice.project.vo;

import java.util.Date;

/**
 * Created by guozheng on 2016/6/27.
 */
public class CrowdfundReturnsetReponseVo {

    private String returnNo;             //回报编号
    private Double price;                //支付金额
    private Integer numberLimits;       //名额
    private String returnContent;       //回报内容
    private Date returnDate;            //回报日期
    private String courierFees;         //快递费用

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getCourierFees() {
        return courierFees;
    }

    public void setCourierFees(String courierFees) {
        this.courierFees = courierFees;
    }
}
