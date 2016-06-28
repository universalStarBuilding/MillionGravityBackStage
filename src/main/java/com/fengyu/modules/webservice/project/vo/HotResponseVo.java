package com.fengyu.modules.webservice.project.vo;

import com.fengyu.common.page.Pagetables;

import java.math.BigDecimal;
import java.util.Date;

public class HotResponseVo extends Pagetables{
    private Integer projectNo;//项目编号

    private Integer orderOwner;//支持人数

    private String projectName;//项目名称

    private String projectState;//状态

    private BigDecimal fundAmt;//目标金额

    private String fundTotalAmt;//已筹金额

    private String projectImage;//项目图片

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(Integer orderOwner) {
        this.orderOwner = orderOwner;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState == null ? null : projectState.trim();
    }


    public BigDecimal getFundAmt() {
        return fundAmt;
    }

    public void setFundAmt(BigDecimal fundAmt) {
        this.fundAmt = fundAmt;
    }

    public String getFundTotalAmt() {
        return fundTotalAmt;
    }

    public void setFundTotalAmt(String fundTotalAmt) {
        this.fundTotalAmt = fundTotalAmt == null ? null : fundTotalAmt.trim();
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage == null ? null : projectImage.trim();
    }

}