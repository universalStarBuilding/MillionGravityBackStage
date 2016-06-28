package com.fengyu.modules.webservice.project.vo;

import com.fengyu.common.page.Pagetables;

import java.util.Date;

public class MessageResponseVo  extends Pagetables{

    private String messId;          //模板编号
    private Integer type;           //消息类型：0 private，1public，2global
    private String status;          //状态类型：0 未读，1已读，2删除
    private String title;           //标题
    private Integer sendId;          //发送者编号
    private String sendName;        //发送者名称
    private String sendLogo;        //发送者头像
    private String content;         //发送内容
    private Date sendTime;        //发送时间


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessId() {
        return messId;
    }

    public void setMessId(String messId) {
        this.messId = messId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendLogo() {
        return sendLogo;
    }

    public void setSendLogo(String sendLogo) {
        this.sendLogo = sendLogo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}