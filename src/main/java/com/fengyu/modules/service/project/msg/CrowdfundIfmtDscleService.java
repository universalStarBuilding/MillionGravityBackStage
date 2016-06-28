package com.fengyu.modules.service.project.msg;

import com.fengyu.modules.dao.project.msg.CrowdfundIfmtDscleDao;
import com.fengyu.modules.model.CrowdfundIfmtDscle;
import com.fengyu.modules.webservice.project.vo.CrowdfundIfmtDscleRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by admin on 2016/6/24.
 */
@Service(value = "dynamicService")
@Transactional
public class CrowdfundIfmtDscleService {

    @Autowired
    private CrowdfundIfmtDscleDao dynamicDao;

    /**
     * 添加项目动态
     * @param dynamicVo
     * @return
     */
    public Integer insert(CrowdfundIfmtDscleRequestVo dynamicVo){
        CrowdfundIfmtDscle dynamic=new CrowdfundIfmtDscle();
        dynamic.setProjectNo(dynamicVo.getProjectNo());
        dynamic.setDsclUser(dynamicVo.getDsclUser());
        dynamic.setDsclNode(dynamicVo.getDsclNode());
        dynamic.setIfmtType(dynamicVo.getIfmtType());
        dynamic.setIfmtContentDesc(dynamicVo.getIfmtContentDesc());
        dynamic.setState(dynamicVo.getState());
        dynamic.setDsclTime(new Date());
        dynamic.setAuditor(dynamicVo.getAuditor());
        dynamic.setAuditTime(new Date());
        return dynamicDao.insert(dynamic);
    }
}
