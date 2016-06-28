package com.fengyu.modules.webservice.project.vo;

import com.fengyu.common.page.Pagetables;
import java.util.Date;


public class MessageRequestVo extends Pagetables{

    private Integer id;

    private Integer sendId;

    private Integer recId;

    private String message;

    private Integer messageType;

    private String title;

    private Date postDate;

    private Integer groupId;

    private Integer messId;

    private Integer statue;

    public Integer getStatue() {
        return statue;
   }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Integer getMessId() {
        return messId;
    }

    public void setMessId(Integer messId) {
        this.messId = messId;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}