package com.fengyu.modules.dao.account;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.AccBasic;
@MyBatisDao
public interface AccBasicDao extends CrudDao<AccBasic>{
    //查询是否有支付密码
    String getPayPwd(Integer id);
    //修改支付密码
    Integer updatePayPwd(AccBasic accBasic);
}