package com.fengyu.modules.dao.project.returnset;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.CrowdfundReturnset;
import com.fengyu.modules.webservice.project.vo.CrowdfundReturnsetReponseVo;

import java.util.List;

@MyBatisDao
public interface CrowdfundReturnsetDao extends CrudDao<CrowdfundReturnset>{

    /**
     * 提价项目回报
     * @param record
     * @return
     */
    int insert(CrowdfundReturnset record);

    /**
     * 修改项目回报
     * @param record
     * @return
     */
    int update(CrowdfundReturnset record);

    /**
     * 查询指定项目的回报列表
     * @param projectNo
     * @return
     */
    List<CrowdfundReturnsetReponseVo> getListByProjectNo(Integer projectNo);

    /**
     * 删除指定项目的回报
     * @param projectNo
     * @return
     */
    Integer deleteByProjectNo(Integer id);
}