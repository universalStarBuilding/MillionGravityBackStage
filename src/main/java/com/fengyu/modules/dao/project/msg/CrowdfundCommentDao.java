package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.CrowdfundBasicinfo;
import com.fengyu.modules.webservice.project.vo.CrowdfundCommentRequestVo;

import java.util.List;

@MyBatisDao
public interface CrowdfundCommentDao {
    //统计数量
    long queryById(CrowdfundCommentRequestVo crowdfundCommentVo);
    //查询项目评论列表
    List<CrowdfundBasicinfo> getListCrowdfund(CrowdfundCommentRequestVo crowdfundCommentVo);

}