package com.fengyu.modules.dao.account;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.AccUserBank;

@MyBatisDao
public interface AccUserBankDao extends CrudDao<AccUserBank> {

    /**
     * 绑定银行卡信息
     * @param record
     * @return
     */
    int insert(AccUserBank record);

    /**
     * 查询银行卡是否绑定
     * @param id
     * @return
     */
    String getUserBank(Integer id);


}