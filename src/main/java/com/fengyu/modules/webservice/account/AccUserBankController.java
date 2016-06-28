package com.fengyu.modules.webservice.account;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.model.AccUserBank;
import com.fengyu.modules.service.account.AccUserBankService;
import com.fengyu.system.entity.ResultAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/24.
 */
@Component
@Path("/accuserbank")
public class AccUserBankController {
    @Autowired
    private AccUserBankService accUserBankService;

    /**
     * 绑定银行卡
     * @param accUserBank
     * @return
     */
    @POST
    @Path("insert")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertAccUserBank(AccUserBank accUserBank){
        Integer rows=accUserBankService.insert(accUserBank);
        if(rows==0){
            throw new WebActionException(WebExceptionType.INSERTINVALIDACCUSERBANK,accUserBank);
        }
        return JSON.toJSONString(rows);
    }
}
