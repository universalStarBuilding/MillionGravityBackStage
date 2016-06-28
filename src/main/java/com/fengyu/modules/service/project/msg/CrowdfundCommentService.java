package com.fengyu.modules.service.project.msg;

import com.fengyu.modules.dao.project.msg.CrowdfundCommentDao;
import com.fengyu.modules.model.CrowdfundBasicinfo;
import com.fengyu.modules.webservice.project.vo.CrowdfundCommentRequestVo;
import com.fengyu.system.entity.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2016/6/25.
 */
@Service(value = "crowdfundCommentService")
@Transactional
public class CrowdfundCommentService {

    @Autowired
    private CrowdfundCommentDao crowdfundCommentDao;


    /**
     * 分页：查询项目评论列表
     * @param crowdfundCommentVo
     * @return
     */
    public SearchResult queryById(CrowdfundCommentRequestVo crowdfundCommentVo){

        SearchResult<CrowdfundBasicinfo> result = new SearchResult<>();
        result.setTotalRows(crowdfundCommentDao.queryById(crowdfundCommentVo));
        result.setRows(crowdfundCommentDao.getListCrowdfund(crowdfundCommentVo));
        return result ;
    }


}
