package com.fengyu.modules.webservice.account;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.model.AccBasic;
import com.fengyu.modules.service.account.AccBasicService;
import com.fengyu.system.entity.ResultAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by admin on 2016/6/23.
 */
@Component
@Path("/accbasic")
public class AccBasicController {

    @Autowired
    private AccBasicService accBasicService;

    /**
     * 修改支付密码
     * @param accBasic
     * @return
     */
    @POST
    @Path("payPwdUpdate")
    public String updatePayPwd(AccBasic accBasic){
        Integer rows=accBasicService.updatePayPwd(accBasic);
        if (rows==0){
            throw new WebActionException(WebExceptionType.UPDATEPAYPWDACCUSERBANK,accBasic);
        }
        return JSON.toJSONString(rows);
    }
}
