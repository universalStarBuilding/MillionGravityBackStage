package com.fengyu.modules.webservice.user;

import com.fengyu.modules.service.SendMsgService;
import com.fengyu.modules.webservice.user.vo.SendMsgVo;
import com.fengyu.system.entity.ResultAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/25.
 */
@Component
@Path("/send")
public class SendMsgController {

    @Autowired
    private SendMsgService sendMsgService;

    @POST
    @Path("sendMsg")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultAPI sendMsg(SendMsgVo sendMsgVo){
        ResultAPI resultAPI=new ResultAPI();
        try {
            resultAPI.setMsg(sendMsgService.sendMsgPhone(sendMsgVo));
            resultAPI.setAccess_result("SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
            resultAPI.setAccess_result("FAILURE");
        }
        return resultAPI;
    }
}
