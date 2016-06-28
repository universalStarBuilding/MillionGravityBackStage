package com.fengyu.modules.webservice.project.msg;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.service.project.msg.CrowdfundCommentService;
import com.fengyu.modules.webservice.project.vo.CrowdfundCommentRequestVo;
import com.fengyu.system.entity.ResultAPI;
import com.fengyu.system.entity.SearchResult;
import org.quartz.impl.StdScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/25.
 */
@Component
@Path("/porject/msg/crowdfundComment")
public class CrowdfundCommentController {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(CrowdfundCommentController.class);
 /*   @Resource
    private StdScheduler scheduler;*/
    @Autowired
    private CrowdfundCommentService crowdfundCommentService;

    @POST
    @Path("queryById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String pageList(CrowdfundCommentRequestVo crowdfundCommentVo){

        if(crowdfundCommentVo==null){
            throw new WebActionException(WebExceptionType.GETINVALIDCROWDFUNDCOMMENT,crowdfundCommentVo);
        }
        SearchResult searchResult  = crowdfundCommentService.queryById(crowdfundCommentVo);

        return JSON.toJSONString(searchResult);
    }

/*    @POST
    @Path("quartzTest")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultAPI quartzTest(CrowdfundCommentRequestVo crowdfundCommentRequestVo){
        if (crowdfundCommentRequestVo==null){
            throw new WebActionException();
        }

        return null;
    }*/

}
