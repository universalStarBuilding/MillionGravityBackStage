package com.fengyu.modules.webservice.user.security;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.channel.email.SendMail;
import com.fengyu.common.channel.phone.AliMsgApi;
import com.fengyu.common.config.Cache;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.model.User;
import com.fengyu.modules.service.user.UserService;
import com.fengyu.modules.webservice.user.vo.SercurityVo;
import com.fengyu.system.entity.ResultAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by admin on 2016/6/23.
 */
@Component
@Path("/security")
public class SercurityController {

    @Autowired
    private UserService userService;

    /**
     * 查询安全中心信息
     * @param id    用户编号
     * @return
     */
    @GET
    @Path("get/{id}")
    public String get(@PathParam("id")Integer id){
        SercurityVo sercurityVo=userService.getSercurityById(id);
        if (sercurityVo==null){
            throw  new WebActionException(WebExceptionType.USERNOTFUND,sercurityVo);
        }
        return JSON.toJSONString(sercurityVo);
    }
    /**
     * 查询模糊手机号和邮箱
     * @param id
     * @return
     */
    @GET
    @Path("contact/{id}")
    public String getContact(@PathParam("id") Integer id){
        SercurityVo sercurityVo=userService.getContact(id);
        if (sercurityVo==null){
            throw  new WebActionException(WebExceptionType.USERPHONEEMAIL,sercurityVo);
        }
        return JSON.toJSONString(sercurityVo);
    }

    /**
     * 发送验证码
     * @param
     * @return
     */
    @GET
    @Path("sendCode/{type}/{value}")
    public ResultAPI sendCode(@PathParam("type")String type,@PathParam("value")String value){

        String code = "123213";
        if(type.equals("email")){
            SendMail.send(value,"测试邮箱接口","SUCCESS,code:"+code);
        }else if(type.equals("phone")){
            AliMsgApi.sendMsg(null,value,code);
        }
        Cache.setCodeCache(code);

        return null;
    }

    /**
     * 修改手机
     * @param user
     * @return
     */
    @POST
    @Path("update")
    public String updatePhone(User user){
        Integer rows=userService.updatePhone(user);
        if (rows==0){
            throw  new WebActionException(WebExceptionType.USERPHONEEMAIL,user);
        }
        return JSON.toJSONString(user);
    }
    /**
     * 修改邮箱
     * @param user
     * @return
     */
    @POST
    @Path("emailUpdate")
    public String updateEmail(User user){
        Integer rows=userService.updatePhone(user);
        if (rows==0){
            throw  new WebActionException(WebExceptionType.USERPHONEEMAIL,user);
        }
        return JSON.toJSONString(user);
    }
    /**
     * 修改登录密码
     * @param user
     * @return
     */
    @POST
    @Path("updateLoginPwd")
    public String updateLoginPwd(User user){
        Integer rows=userService.updatePhone(user);
        if (rows==0){
            throw  new WebActionException(WebExceptionType.USERPASSWORD,user);
        }
        return JSON.toJSONString(user);
    }

}
