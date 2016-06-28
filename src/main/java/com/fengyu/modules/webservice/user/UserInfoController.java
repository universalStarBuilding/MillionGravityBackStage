package com.fengyu.modules.webservice.user;

import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.common.utils.Constant;
import com.fengyu.modules.model.UserInfo;
import com.fengyu.modules.service.user.UserInfoService;
import com.alibaba.fastjson.JSON;
import com.fengyu.modules.webservice.user.vo.FormVo;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * 用户详细信息 Controller
 * Controller
 *
 * @author Wudonglin
 * @version 2016-06-22
 */
@Component
@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 获取用户详细信息
     * @param id
     * @return
     */
    @GET
    @Path("get/{id}")
    public String getUserInfo(@PathParam("id") Integer id) {
        UserInfo userInfo = userInfoService.getUserInfo(id);
        if(userInfo == null){
            throw  new WebActionException(WebExceptionType.USERNOTFUND,userInfo);
        }
        return JSON.toJSONString(userInfo);
    }
    //修改用户信息
    @POST
    @Path("update")
    public String updateUserInfo(UserInfo userInfo){
        Integer rows = userInfoService.updateUserInfo(userInfo);
        if(rows == 0){
            throw  new WebActionException(WebExceptionType.UPDATEINVALIDUSERINFO,userInfo);
        }
        return JSON.toJSONString(rows);
    }

    @GET
    @Path("web/{id}")
    public String getException(@PathParam("id")Integer id){
        if (id == 0) {
            throw new WebActionException(WebExceptionType.LOGINNOTFUND, id);
        }

        return null;
    }
    @GET
    @Path("test/{phone}")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@PathParam("phone") @Pattern(message = Constant.PhoneInvalidError, regexp = "[0-9]{3,9}") String phone){

        return phone;
    }

    @POST
    @Path("test/form")
    public String testPhone(@Valid FormVo form){

        return JSON.toJSONString(form);
    }
    @POST
    @Path("insertRealName")
    public String insertRealName(UserInfo userInfo){
        Integer rows=userInfoService.insertRealName(userInfo);
        if (rows==0){
            throw new WebActionException(WebExceptionType.LOGINNOTFUND,userInfo);
        }
        return JSON.toJSONString(rows);
    }
}
