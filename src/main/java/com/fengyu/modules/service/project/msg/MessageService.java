package com.fengyu.modules.service.project.msg;

import com.fengyu.modules.dao.project.msg.MessageDao;
import com.fengyu.modules.dao.project.msg.MessageTextDao;
import com.fengyu.modules.dao.user.UserInfoDao;
import com.fengyu.modules.model.Message;
import com.fengyu.modules.model.MessageText;
import com.fengyu.modules.model.UserInfo;
import com.fengyu.modules.webservice.project.vo.MessageRequestVo;
import com.fengyu.modules.webservice.project.vo.MessageResponseVo;
import com.fengyu.system.entity.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/6/23.
 */
@Service(value = "messageService")
@Transactional
public class MessageService {

    @Autowired
    private MessageTextDao messageTextDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 添加站内信
     * @param messageTextVo
     * @return
     */
    public int insert(MessageRequestVo messageTextVo){

        MessageText messageTextProject=new MessageText();
        messageTextProject.setSendId(messageTextVo.getSendId());
        messageTextProject.setType(messageTextVo.getMessageType());
        messageTextProject.setTitle(messageTextVo.getTitle());
        messageTextProject.setMessage(messageTextVo.getMessage());
        messageTextProject.setPostDate(new Date());
        messageTextProject.setGroupId(0);
        messageTextDao.insert(messageTextProject);

        Message messageProject=new Message();
        messageProject.setRecId(messageTextVo.getRecId());
        messageProject.setMessId(messageTextProject.getId());
        messageProject.setStatue(0);
        messageDao.add(messageProject);

        return 1;
    }

    /**
     * 分页：查询我的私信列表
     * @param messageRequestVo
     * @return
     */
    public SearchResult getSendMsgListByRecId(MessageRequestVo messageRequestVo){

        List<MessageResponseVo> list = messageDao.getSendUserListByRecId(messageRequestVo);
        for (MessageResponseVo vo : list){

            vo.setType(messageRequestVo.getMessageType());
            MessageText messageText = messageTextDao.getPrivateLetterByMessId(vo);

            vo.setTitle(messageText.getTitle());
            vo.setContent(messageText.getMessage());
            vo.setSendId(messageText.getSendId());
            vo.setSendTime(messageText.getPostDate());

            UserInfo userInfo = userInfoDao.getUserInfo(vo.getSendId());
            vo.setSendName(userInfo.getNickName());
            vo.setSendLogo(userInfo.getHeadImg());
        }

        Integer count = messageDao.coutSendUserListByRecId(messageRequestVo.getRecId());
        SearchResult<MessageResponseVo> result = new SearchResult<>();
        result.setTotalRows(count);
        result.setRows(list);

        return result ;
    }

    /**
     * 删除私信
     * @param messageRequestVo
     * @return
     */
    public int deleteById(MessageRequestVo messageRequestVo){
        Message message=new Message();
        message.setId(messageRequestVo.getId());
        return messageDao.updateById(messageRequestVo);
    }

}
