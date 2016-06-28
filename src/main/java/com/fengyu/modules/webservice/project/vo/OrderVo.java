package com.fengyu.modules.webservice.project.vo;

import com.fengyu.common.page.Pagetables;
import com.fengyu.common.persistence.DataEntity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderVo extends Pagetables{
    private Integer id;

    private Integer orderId;

    private Integer orderOwner;

    private BigDecimal orderAmt;

    private String orderState;

    private String orderType;

    private Integer orderObject;

    private String payChannel;

    private Integer payUser;

    private Date submitTime;

    private Date completeTime;

    private Date paymentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(Integer orderOwner) {
        this.orderOwner = orderOwner;
    }

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Integer getOrderObject() {
        return orderObject;
    }

    public void setOrderObject(Integer orderObject) {
        this.orderObject = orderObject;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public Integer getPayUser() {
        return payUser;
    }

    public void setPayUser(Integer payUser) {
        this.payUser = payUser;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}