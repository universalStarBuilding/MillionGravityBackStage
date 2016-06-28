package com.fengyu.modules.model;

public class CrowdfundReturnsetProp {
    private Integer id;

    private Integer returnNo;

    private String returnPropType;

    private String returnPropTypeDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(Integer returnNo) {
        this.returnNo = returnNo;
    }

    public String getReturnPropType() {
        return returnPropType;
    }

    public void setReturnPropType(String returnPropType) {
        this.returnPropType = returnPropType == null ? null : returnPropType.trim();
    }

    public String getReturnPropTypeDetails() {
        return returnPropTypeDetails;
    }

    public void setReturnPropTypeDetails(String returnPropTypeDetails) {
        this.returnPropTypeDetails = returnPropTypeDetails == null ? null : returnPropTypeDetails.trim();
    }
}