package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.Message;
import com.fengyu.modules.webservice.project.vo.MessageRequestVo;
import com.fengyu.modules.webservice.project.vo.MessageResponseVo;

import java.util.List;


@MyBatisDao
public interface MessageDao extends CrudDao<Message>{
    //添加收件人
    int add(Message recId);
    //查询私信列表
    List<MessageResponseVo> getSendUserListByRecId(MessageRequestVo messageRequestVo);
    //统计我的私信数量
    Integer coutSendUserListByRecId(Integer messId);

    //删除私信
    int updateById(MessageRequestVo messageRequestVo);
}