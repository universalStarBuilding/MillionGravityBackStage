package com.fengyu.modules.model;

import com.fengyu.common.persistence.DataEntity;

import java.util.Date;

public class CrowdfundIfmtDscle extends DataEntity<CrowdfundIfmtDscle>{

    private Integer projectNo;

    private Integer dsclUser;

    private String ifmtType;

    private String ifmtContentDesc;

    private String dsclNode;

    private String state;

    private Date dsclTime;

    private Integer auditor;

    private Date auditTime;

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getDsclUser() {
        return dsclUser;
    }

    public void setDsclUser(Integer dsclUser) {
        this.dsclUser = dsclUser;
    }

    public String getIfmtType() {
        return ifmtType;
    }

    public void setIfmtType(String ifmtType) {
        this.ifmtType = ifmtType == null ? null : ifmtType.trim();
    }

    public String getIfmtContentDesc() {
        return ifmtContentDesc;
    }

    public void setIfmtContentDesc(String ifmtContentDesc) {
        this.ifmtContentDesc = ifmtContentDesc == null ? null : ifmtContentDesc.trim();
    }

    public String getDsclNode() {
        return dsclNode;
    }

    public void setDsclNode(String dsclNode) {
        this.dsclNode = dsclNode == null ? null : dsclNode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getDsclTime() {
        return dsclTime;
    }

    public void setDsclTime(Date dsclTime) {
        this.dsclTime = dsclTime;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}