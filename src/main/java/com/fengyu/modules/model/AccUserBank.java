package com.fengyu.modules.model;

import com.fengyu.common.persistence.DataEntity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement
public class AccUserBank extends DataEntity<AccUserBank>{

    private Integer userId;

    private String name;

    private String bankNo;

    private String bankAccount;

    private String ownerName;

    private String openAcctBank;

    private String bankType;

    private Integer bankCityId;

    private Integer bankProvinceId;

    private Date createTime;

    private Byte state;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOpenAcctBank() {
        return openAcctBank;
    }

    public void setOpenAcctBank(String openAcctBank) {
        this.openAcctBank = openAcctBank == null ? null : openAcctBank.trim();
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    public Integer getBankCityId() {
        return bankCityId;
    }

    public void setBankCityId(Integer bankCityId) {
        this.bankCityId = bankCityId;
    }

    public Integer getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(Integer bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}