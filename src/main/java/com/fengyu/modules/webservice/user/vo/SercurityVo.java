package com.fengyu.modules.webservice.user.vo;

/**
 * Created by admin on 2016/6/23.
 */
public class SercurityVo {

    private String vaguePhone;
    private Boolean phoneStatus;
    private String vagueEmail;
    private Boolean emailStatus;
    private String hidePayPwd;
    private Boolean payPwdStatus;
    private String vagueUserBank;

    public String getVagueUserBank() {
        return vagueUserBank;
    }

    public void setVagueUserBank(String vagueUserBank) {
        this.vagueUserBank = vagueUserBank;
    }

    public Boolean getUserBankStatus() {
        return userBankStatus;
    }

    public void setUserBankStatus(Boolean userBankStatus) {
        this.userBankStatus = userBankStatus;
    }

    private Boolean userBankStatus;

    public String getVagueRealName() {
        return vagueRealName;
    }

    public void setVagueRealName(String vagueRealName) {
        this.vagueRealName = vagueRealName;
    }

    public Boolean getRealNameStatus() {
        return realNameStatus;
    }

    public void setRealNameStatus(Boolean realNameStatus) {
        this.realNameStatus = realNameStatus;
    }

    private String vagueRealName;
    private Boolean realNameStatus;

    public String getHidePayPwd() {
        return hidePayPwd;
    }

    public void setHidePayPwd(String hidePayPwd) {
        this.hidePayPwd = hidePayPwd;
    }

    public Boolean getPayPwdStatus() {
        return payPwdStatus;
    }

    public void setPayPwdStatus(Boolean payPwdStatus) {
        this.payPwdStatus = payPwdStatus;
    }

    public Boolean getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Boolean emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getVagueEmail() {
        return vagueEmail;
    }

    public void setVagueEmail(String vagueEmail) {
        this.vagueEmail = vagueEmail;
    }

    public String getVaguePhone() {
        return vaguePhone;
    }

    public void setVaguePhone(String vaguePhone) {
        this.vaguePhone = vaguePhone;
    }

    public Boolean getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(Boolean phoneStatus) {
        this.phoneStatus = phoneStatus;
    }
}
