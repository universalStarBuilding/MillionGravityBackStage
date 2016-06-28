package com.fengyu.modules.webservice.project.msg;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.service.project.msg.MessageService;
import com.fengyu.modules.webservice.project.vo.MessageRequestVo;
import com.fengyu.modules.webservice.project.vo.MessageResponseVo;
import com.fengyu.system.entity.ResultAPI;
import com.fengyu.system.entity.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/23.
 */
@Component
@Path("/project/msg/message")
public class MessageController {


        @Autowired
        private MessageService messageService;

        @POST
        @Path("inserts")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public String pageList(MessageRequestVo messageTextVo){

           if (messageTextVo==null){
               throw new WebActionException(WebExceptionType.INSERTINVALIDDYNAMIC,messageTextVo);
           }
            int  resultAPI=messageService.insert(messageTextVo);


            return JSON.toJSONString(resultAPI);
        }


    @POST
    @Path("privateLetter")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String privateLetter(MessageRequestVo messageRequestVo){
            if (messageRequestVo==null){
                throw new WebActionException(WebExceptionType.GETINVALIDPROJECTLETTER,messageRequestVo);
            }
        SearchResult searchResult=messageService.getSendMsgListByRecId(messageRequestVo);


        return JSON.toJSONString(searchResult);
    }

    @POST
    @Path("deleteLetter")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteLetter(MessageRequestVo messageTextVo){

        if (messageTextVo==null){
            throw new WebActionException(WebExceptionType.DELETEINVALIDPROJECTLETTER,messageTextVo);
        }
        int message=messageService.deleteById(messageTextVo);


        return JSON.toJSONString(message);
    }

}
