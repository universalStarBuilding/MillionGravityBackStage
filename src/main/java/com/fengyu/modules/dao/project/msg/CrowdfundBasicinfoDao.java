package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.CrowdfundBasicinfo;
import com.fengyu.modules.webservice.project.vo.HotResponseVo;
import com.fengyu.modules.webservice.project.vo.CrowdfundBasicinfoVo;

import java.util.List;

/**
 * 我发起的项目
 */
@MyBatisDao
public interface CrowdfundBasicinfoDao {

    //统计数量
    long queryBy(CrowdfundBasicinfoVo launchProjectVo);
    //查询发起列表
    List<CrowdfundBasicinfo> getListLaunch(CrowdfundBasicinfoVo launchProjectVo);
    //查询热门项目
    List<HotResponseVo> selectHot(CrowdfundBasicinfoVo launchVo);

}