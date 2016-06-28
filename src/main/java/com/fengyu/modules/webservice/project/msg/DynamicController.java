package com.fengyu.modules.webservice.project.msg;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.service.project.msg.CrowdfundIfmtDscleService;
import com.fengyu.modules.webservice.project.vo.CrowdfundIfmtDscleRequestVo;
import com.fengyu.system.entity.ResultAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/24.
 */
@Component
@Path("/project/msg/dynamic")
public class DynamicController {

    @Autowired
    private CrowdfundIfmtDscleService dynamicService;

    @POST
    @Path("insertDynamic")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertDynamic(CrowdfundIfmtDscleRequestVo dynamicRequestVo){
        if (dynamicRequestVo==null){
            throw new WebActionException(WebExceptionType.INSERTINVALIDDYNAMIC,dynamicRequestVo);
        }
        Integer resultAPI =dynamicService.insert(dynamicRequestVo);

        return JSON.toJSONString(resultAPI);
    }


}
