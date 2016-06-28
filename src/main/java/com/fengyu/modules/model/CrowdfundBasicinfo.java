package com.fengyu.modules.model;

import com.fengyu.common.persistence.DataEntity;

import java.math.BigDecimal;
import java.util.Date;


public class CrowdfundBasicinfo extends DataEntity<CrowdfundBasicinfo>{
    private Integer projectNo;

    private Integer userId;

    private String projectName;

    private String projectType;

    private String projectCategory;

    private String projectLocationProvince;

    private String projectLocationCity;

    private String projectLocationDistrict;

    private String projectLocationDetail;

    private String projectSynopsis;

    private String projectSummary;

    private String projectState;

    private Short organizerNo;

    private BigDecimal fundAmt;

    private BigDecimal fundLimitAmt;

    private String fundTotalAmt;

    private Short fundPeriod;

    private Boolean lastingFundFlag;

    private Short preparePeriod;

    private String projectVideo;

    private String projectListImage;

    private String projectImage;

    private Date createTime;

    private Date releasesTime;

    private Date shelvesTime;

    private Integer hot;

    private Integer hotNum;

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory == null ? null : projectCategory.trim();
    }

    public String getProjectLocationProvince() {
        return projectLocationProvince;
    }

    public void setProjectLocationProvince(String projectLocationProvince) {
        this.projectLocationProvince = projectLocationProvince == null ? null : projectLocationProvince.trim();
    }

    public String getProjectLocationCity() {
        return projectLocationCity;
    }

    public void setProjectLocationCity(String projectLocationCity) {
        this.projectLocationCity = projectLocationCity == null ? null : projectLocationCity.trim();
    }

    public String getProjectLocationDistrict() {
        return projectLocationDistrict;
    }

    public void setProjectLocationDistrict(String projectLocationDistrict) {
        this.projectLocationDistrict = projectLocationDistrict == null ? null : projectLocationDistrict.trim();
    }

    public String getProjectLocationDetail() {
        return projectLocationDetail;
    }

    public void setProjectLocationDetail(String projectLocationDetail) {
        this.projectLocationDetail = projectLocationDetail == null ? null : projectLocationDetail.trim();
    }

    public String getProjectSynopsis() {
        return projectSynopsis;
    }

    public void setProjectSynopsis(String projectSynopsis) {
        this.projectSynopsis = projectSynopsis == null ? null : projectSynopsis.trim();
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary == null ? null : projectSummary.trim();
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState == null ? null : projectState.trim();
    }

    public Short getOrganizerNo() {
        return organizerNo;
    }

    public void setOrganizerNo(Short organizerNo) {
        this.organizerNo = organizerNo;
    }

    public BigDecimal getFundAmt() {
        return fundAmt;
    }

    public void setFundAmt(BigDecimal fundAmt) {
        this.fundAmt = fundAmt;
    }

    public BigDecimal getFundLimitAmt() {
        return fundLimitAmt;
    }

    public void setFundLimitAmt(BigDecimal fundLimitAmt) {
        this.fundLimitAmt = fundLimitAmt;
    }

    public String getFundTotalAmt() {
        return fundTotalAmt;
    }

    public void setFundTotalAmt(String fundTotalAmt) {
        this.fundTotalAmt = fundTotalAmt == null ? null : fundTotalAmt.trim();
    }

    public Short getFundPeriod() {
        return fundPeriod;
    }

    public void setFundPeriod(Short fundPeriod) {
        this.fundPeriod = fundPeriod;
    }

    public Boolean getLastingFundFlag() {
        return lastingFundFlag;
    }

    public void setLastingFundFlag(Boolean lastingFundFlag) {
        this.lastingFundFlag = lastingFundFlag;
    }

    public Short getPreparePeriod() {
        return preparePeriod;
    }

    public void setPreparePeriod(Short preparePeriod) {
        this.preparePeriod = preparePeriod;
    }

    public String getProjectVideo() {
        return projectVideo;
    }

    public void setProjectVideo(String projectVideo) {
        this.projectVideo = projectVideo == null ? null : projectVideo.trim();
    }

    public String getProjectListImage() {
        return projectListImage;
    }

    public void setProjectListImage(String projectListImage) {
        this.projectListImage = projectListImage == null ? null : projectListImage.trim();
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage == null ? null : projectImage.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReleasesTime() {
        return releasesTime;
    }

    public void setReleasesTime(Date releasesTime) {
        this.releasesTime = releasesTime;
    }

    public Date getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(Date shelvesTime) {
        this.shelvesTime = shelvesTime;
    }
}