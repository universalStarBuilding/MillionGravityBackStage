package com.fengyu.modules.service.account;

import com.fengyu.common.service.CrudService;
import com.fengyu.modules.dao.account.AccUserBankDao;
import com.fengyu.modules.model.AccUserBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by admin on 2016/6/24.
 */
@Service(value = "accUserBankService")
@Transactional
public class AccUserBankService extends CrudService<AccUserBankDao,AccUserBank> {

    @Autowired
    private AccUserBankDao accUserBankDao;

    /**
     * 添加银行卡
     * @param accUserBank
     * @return
     */
    public Integer insert(AccUserBank accUserBank){
        if (accUserBank.getUserId()==null){
            throw new RuntimeException("添加失败");
        }
        accUserBank.setCreateTime(new Date());
        return accUserBankDao.insert(accUserBank);
    }

}
