package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.CrowdfundAttention;
import com.fengyu.modules.webservice.project.vo.CrowdfundAttentionRequestVo;

import java.util.List;

/**
 * 我关注的项目
 */
@MyBatisDao
public interface CrowdfundAttentionDao {
    //统计数量
    long queryById(CrowdfundAttentionRequestVo followProjectVo);
    //查询关注列表
    List<CrowdfundAttention> getListFollow(CrowdfundAttentionRequestVo followProjectVo);
    //添加关注项目
    Integer insert(CrowdfundAttention followProject);
}