package com.fengyu.modules.model;

import com.fengyu.common.persistence.DataEntity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccBasic extends DataEntity<AccBasic> {
    private Integer userId;

    private Long balance;

    private Long frozenAmt;

    private String payPwd;

    private Boolean status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getFrozenAmt() {
        return frozenAmt;
    }

    public void setFrozenAmt(Long frozenAmt) {
        this.frozenAmt = frozenAmt;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}