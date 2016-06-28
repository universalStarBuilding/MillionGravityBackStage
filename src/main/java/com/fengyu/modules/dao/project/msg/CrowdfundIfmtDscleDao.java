package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.CrowdfundIfmtDscle;


@MyBatisDao
public interface CrowdfundIfmtDscleDao {

    //添加项目动态信息
    int insert(CrowdfundIfmtDscle record);

}