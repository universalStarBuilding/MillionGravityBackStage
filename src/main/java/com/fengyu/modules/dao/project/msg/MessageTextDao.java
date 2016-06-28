package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.MessageText;
import com.fengyu.modules.webservice.project.vo.MessageRequestVo;
import com.fengyu.modules.webservice.project.vo.MessageResponseVo;


@MyBatisDao
public interface MessageTextDao extends CrudDao<MessageText>{
    //添加站内信
    int insert(MessageText messageTextProject);
    //查询类型，获取标题、内容、时间
    MessageText queryType(int type);
    //查询指定消息的内容
    MessageText getPrivateLetterByMessId(MessageResponseVo messageResponseVo);

}