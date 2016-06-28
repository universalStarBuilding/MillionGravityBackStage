package com.fengyu.modules.model;

import com.fengyu.common.page.Pagetables;
import com.fengyu.common.persistence.DataEntity;

import java.util.Date;

public class MessageText extends DataEntity<MessageText>{
    private Integer id;

    private Integer sendId;

    private String message;

    private Integer type;

    private String title;

    private Date postDate;

    private Integer groupId;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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