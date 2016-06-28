package com.fengyu.modules.webservice.user.vo;

import com.fengyu.common.persistence.DataEntity;

/**
 * Created by admin on 2016/6/25.
 */
public class SendMsgVo extends DataEntity<SendMsgVo>{
    private String sendUser;//发送目标
    private String phone;//手机号
    private String verifyCode;//验证码
    private String type="email";//类型
    private String context;//內容
    private String title;//标题
    private String email;//邮箱

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
