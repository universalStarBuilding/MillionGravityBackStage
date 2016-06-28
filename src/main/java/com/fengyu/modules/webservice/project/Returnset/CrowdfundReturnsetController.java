package com.fengyu.modules.webservice.project.Returnset;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.common.utils.Constant;
import com.fengyu.modules.service.project.returnset.CrowdfundReturnsetService;
import com.fengyu.modules.webservice.project.vo.CrowdfundReturnsetReponseVo;
import com.fengyu.modules.webservice.project.vo.CrowdfundReturnsetRequestVo;
import com.fengyu.modules.webservice.user.vo.FormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by admin on 2016/6/27.
 */
@Component
@Path("/project/returnset")
public class CrowdfundReturnsetController {


    @Autowired
    private CrowdfundReturnsetService crowdfundReturnsetService;


    /**
     * 获取指定项目的回报列表
     * @param id
     * @return
     */
    @GET
    @Path("list/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String list(@PathParam("id") Integer id){

        List<CrowdfundReturnsetReponseVo> vo = crowdfundReturnsetService.getListByProjectNo(id);
        if(vo == null){
            throw new WebActionException(WebExceptionType.CROWDFUNDRETURNSETNOTFUND,vo);
        }

        return JSON.toJSONString(vo);
    }

    /**
     * 增加项目回报
     * @return
     */
    @POST
    @Path("save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(CrowdfundReturnsetRequestVo crowdfundReturnsetRequestVo){

        Integer rows = crowdfundReturnsetService.saveCrowdfundReturnset(crowdfundReturnsetRequestVo);
        if(rows == 0){
            throw  new WebActionException(WebExceptionType.DELETEINVALIDPROEJCTRETURNSET,crowdfundReturnsetRequestVo);
        }

    }

    /**
     * 修改项目回报
     * @return
     */
    @POST
    @Path("edit")
    public void edit(@Valid CrowdfundReturnsetRequestVo crowdfundReturnsetRequestVo){

        Integer rows = crowdfundReturnsetService.updateCrowdfundReturnset(crowdfundReturnsetRequestVo);
        if(rows == 0){
            throw  new WebActionException(WebExceptionType.UPDATEINVALIDPROEJCTRETURNSET,crowdfundReturnsetRequestVo);
        }
    }

    /**
     * 删除指定项目的回报
     * @param id
     * @return
     */
    @GET
    @Path("delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public void delete(@PathParam("id") Integer id){

        Integer rows = crowdfundReturnsetService.deleteById(id);
        if(rows == 0){
            throw  new WebActionException(WebExceptionType.DELETEINVALIDPROEJCTRETURNSET,id);
        }
    }


}
