package com.fengyu.modules.service.account;

import com.fengyu.common.service.CrudService;
import com.fengyu.modules.dao.account.AccBasicDao;
import com.fengyu.modules.model.AccBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2016/6/23.
 */
@Service(value = "accBasicService")
@Transactional
public class AccBasicService extends CrudService<AccBasicDao,AccBasic> {

    @Autowired
    private AccBasicDao accBasicDao;

    /**
     * 修改支付密码
     * @param accBasic
     * @return
     */
    public Integer updatePayPwd(AccBasic accBasic){
        if (accBasic.getUserId()==null){
            throw new RuntimeException("支付密码修改失败");
        }
        return accBasicDao.updatePayPwd(accBasic);
    }
}
