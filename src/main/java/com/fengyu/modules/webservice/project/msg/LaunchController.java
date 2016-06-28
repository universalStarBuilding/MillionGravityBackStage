package com.fengyu.modules.webservice.project.msg;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.model.CrowdfundBasicinfo;
import com.fengyu.modules.service.project.msg.CrowdfundBasicinfoService;
import com.fengyu.modules.webservice.project.vo.CrowdfundBasicinfoVo;
import com.fengyu.system.entity.ResultAPI;
import com.fengyu.system.entity.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Component
@Path("/project/msg/launchProject")
public class LaunchController {


    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(LaunchController.class);



    @Autowired
    private CrowdfundBasicinfoService launchProjectService;

    /**
     * 我发起的项目列表
     * @param launchProjectVo
     * @return
     */
    @POST
    @Path("queryBy")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String pageList(CrowdfundBasicinfoVo launchProjectVo){
        if (launchProjectVo==null){
            throw new WebActionException(WebExceptionType.GETINVALIDLAUNCHPROJECT,launchProjectVo);
        }
        SearchResult searchResult=launchProjectService.queryBy(launchProjectVo);


        return JSON.toJSONString(searchResult);
    }

    /**
     * 查询热门项目列表
     * @param launchVo
     * @return
     */
    @POST
    @Path("selectHot")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String selectHot(CrowdfundBasicinfoVo launchVo){

            if (launchVo==null){
                throw new WebActionException(WebExceptionType.SELECTINVALIDHOT,launchVo);
            }
        SearchResult  searchResult=launchProjectService.selectHot(launchVo);

        return JSON.toJSONString(searchResult);
    }


}
