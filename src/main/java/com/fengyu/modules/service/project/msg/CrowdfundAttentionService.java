package com.fengyu.modules.service.project.msg;

import com.fengyu.modules.dao.project.msg.CrowdfundAttentionDao;
import com.fengyu.modules.model.CrowdfundAttention;
import com.fengyu.modules.webservice.project.vo.CrowdfundAttentionRequestVo;
import com.fengyu.system.entity.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service(value = "followProjectService")
@Transactional
public class CrowdfundAttentionService {
    @Autowired
    private CrowdfundAttentionDao followProjectMapper;

    /**
     * 分页：我关注的项目列表
     * @param followProjectVo
     * @return
     */
    public SearchResult queryById(CrowdfundAttentionRequestVo followProjectVo){
        SearchResult<CrowdfundAttention> result = new SearchResult<>();
        result.setTotalRows(followProjectMapper.queryById(followProjectVo));
        result.setRows(followProjectMapper.getListFollow(followProjectVo));
        return result ;
    }

    /**
     * 添加关注的项目
     * @param followProjectVo
     * @return
     */
    public Integer insert(CrowdfundAttentionRequestVo followProjectVo){

        CrowdfundAttention followProject=new CrowdfundAttention();
        followProject.setUserId(followProjectVo.getUserId());
        followProject.setAttentionNo(followProjectVo.getAttentionNo());
        followProject.setAttentionTime(new Date());

        return followProjectMapper.insert(followProject);
    }
}
