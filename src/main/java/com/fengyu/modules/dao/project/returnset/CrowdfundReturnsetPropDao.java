package com.fengyu.modules.dao.project.returnset;

import com.fengyu.modules.model.CrowdfundReturnsetProp;

public interface CrowdfundReturnsetPropDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CrowdfundReturnsetProp record);

    int insertSelective(CrowdfundReturnsetProp record);

    CrowdfundReturnsetProp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrowdfundReturnsetProp record);

    int updateByPrimaryKey(CrowdfundReturnsetProp record);
}