package com.fengyu.modules.webservice.project.msg;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.service.project.msg.CrowdfundAttentionService;
import com.fengyu.modules.webservice.project.vo.CrowdfundAttentionRequestVo;
import com.fengyu.system.entity.ResultAPI;
import com.fengyu.system.entity.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/22.
 * @FollowProjectController 测试我关注的项目
 */
@Component
@Path("/project/msg/followProject")
public class FollowController {


    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(FollowController.class);

    @Autowired
    private CrowdfundAttentionService followProjectService;


    @POST
    @Path("queryByIdFollow")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String pageList(CrowdfundAttentionRequestVo followProjectVo){

        if (followProjectVo==null){
            throw new WebActionException(WebExceptionType.GETINVALIDPROJECTCONCERNS,followProjectVo);
        }
        SearchResult searchResult=followProjectService.queryById(followProjectVo);


        return JSON.toJSONString(searchResult);
    }


    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insert(CrowdfundAttentionRequestVo followProjectVo){
        if (followProjectVo==null){
            throw new WebActionException(WebExceptionType.INSERTINVALIDDYNAMIC,followProjectVo);
        }
        Integer resultAPI=followProjectService.insert(followProjectVo);

        return JSON.toJSONString(resultAPI);
    }

}
