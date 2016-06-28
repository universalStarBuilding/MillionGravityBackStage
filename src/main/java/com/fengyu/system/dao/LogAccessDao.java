package com.fengyu.system.dao;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.system.entity.LogAccess;

import java.util.List;

@MyBatisDao
public interface LogAccessDao extends CrudDao<LogAccess> {

    long coutPageList(LogAccess logAccess);

    List<LogAccess> findPageList(LogAccess logAccess);
}