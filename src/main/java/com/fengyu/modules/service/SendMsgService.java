package com.fengyu.modules.service;

import com.fengyu.common.channel.email.SendMail;
import com.fengyu.common.channel.phone.AliMsgApi;
import com.fengyu.common.config.Cache;
import com.fengyu.common.utils.StringUtils;
import com.fengyu.modules.webservice.user.vo.SendMsgVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin on 2016/6/25.
 */

@Service(value="sendMsgService")
@Transactional
public class SendMsgService {
    public SendMsgVo sendMsgPhone(SendMsgVo sendMsgVo) {
        /**
         * 产生6位随机数
         */
        String messageCode = String.valueOf(Math.random()).substring(2,8);
       // String phone = sendMsgVo.getPhone();
        String email=sendMsgVo.getEmail();
        String title=sendMsgVo.getTitle();
        String context=sendMsgVo.getContext();
        String type=sendMsgVo.getType();

        if (!type.equals(email)){
            throw new RuntimeException("验证码发送失败");
        }else {
            sendMsgVo.setVerifyCode(messageCode);
            SendMail.send(email,title,context);
        }
        return sendMsgVo;
    }
    public static void main(String[]args){
        String messageCode = String.valueOf(Math.random()).substring(2,8);
        SendMsgVo sendMsgVo=new SendMsgVo();
        sendMsgVo.setVerifyCode(messageCode);
        Cache.setCodeCache(sendMsgVo.getVerifyCode());
        sendMsgVo.setEmail("296734078@qq.com");
        sendMsgVo.setTitle("注册账户");
        sendMsgVo.setContext("您正在注册我们的平台，您的验证码是"+sendMsgVo.getVerifyCode()+"请不要告诉别人");
        new SendMsgService().sendMsgPhone(sendMsgVo);
        //Cache.setCodeCache(sendMsgVo.getContext());
        // sendMsgVo.setVerifyCode(messageCode);
        // AliMsgApi.sendMsg(null, phone, sendMsgVo.getVerifyCode());
        System.out.print(Cache.getCodeCache());
    }
}