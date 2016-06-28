package com.fengyu.modules.service.user;


import com.fengyu.common.channel.email.SendMail;
import com.fengyu.common.channel.phone.AliMsgApi;
import com.fengyu.common.config.Cache;
import com.fengyu.common.service.CrudService;
import com.fengyu.common.utils.StringUtils;
import com.fengyu.modules.dao.account.AccBasicDao;
import com.fengyu.modules.dao.account.AccUserBankDao;
import com.fengyu.modules.dao.user.UserDao;
import com.fengyu.modules.dao.user.UserInfoDao;
import com.fengyu.modules.model.User;
import com.fengyu.modules.webservice.user.vo.SercurityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@Transactional
public class UserService extends CrudService<UserDao, User> {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AccBasicDao accBasicDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private AccUserBankDao accUserBankDao;
    /**
     *查询手机号是否存在
     * @return
     */
    public SercurityVo getSercurityById(Integer id){
        if (id==null){
            throw  new RuntimeException("用户手机号获取失败");
        }
        SercurityVo vo = new SercurityVo();

        //手机
        String phone = userDao.getPhone(id);
        if (StringUtils.isNotEmpty(phone)){
            vo.setVaguePhone(phone);
            phone.replace(phone.substring(3,7),"****");
            vo.setPhoneStatus(true);
        }else {
            vo.setPhoneStatus(false);
        }
        //邮箱
        String email=userDao.getEmail(id);
        if (StringUtils.isNotEmpty(email)){
            vo.setVagueEmail(email);
            email.replace(email.substring(3,7),"****");
            vo.setEmailStatus(true);
        }else {
            vo.setEmailStatus(false);
        }
        //支付密码
        String payPwd=accBasicDao.getPayPwd(id);
        if (StringUtils.isNotEmpty(payPwd)){
            vo.setPayPwdStatus(true);
        }else {
            vo.setPayPwdStatus(false);
        }
        //实名
        String realName=userInfoDao.getRealName(id);
        if (StringUtils.isNotEmpty(realName)){
            vo.setVagueRealName(realName);
            realName.replace(realName.substring(2),"*");
            vo.setRealNameStatus(true);
        }else {
            vo.setRealNameStatus(false);
        }
        //银行卡
        String userBank=accUserBankDao.getUserBank(id);
        if (StringUtils.isNotEmpty(userBank)){
            vo.setVagueUserBank(userBank);
            vo.setUserBankStatus(true);
        }else {
            vo.setUserBankStatus(false);
        }
        return vo;
    }

    /**
     * 查询手机号和邮箱是否存在
     * @param id
     * @return
     */
    public SercurityVo getContact(Integer id){
        if (id==null){
            throw new RuntimeException("查询手机号和邮箱失败");
        }
        SercurityVo vo=new SercurityVo();
        String phone=userDao.getPhone(id);
        String email=userDao.getEmail(id);
        if (StringUtils.isNotEmpty(email)&&StringUtils.isNotEmpty(phone)){
            email.replace(email.substring(3,7),"****");
            phone.replace(email.substring(3,7),"****");
            vo.setEmailStatus(true);
        }else {
            vo.setEmailStatus(false);
        }
        return vo;
    }

    /**
     * 修改手机号
     * @param user
     * @return
     */
    public Integer updatePhone(User user){
        if (user==null){
            throw new RuntimeException("手机号修改失败");
        }
        return userDao.updatePhone(user);
    }

    /**
     * 修改邮箱
     * @param user
     * @return
     */
    public Integer updateEmail(User user){
        if (user==null){
            throw  new RuntimeException("邮箱修改失败");
        }
        return userDao.updateEmail(user);
    }

    /**
     * 修改登录密码
     * @param user
     * @return
     */
    public Integer updateLoginPwd(User user){
        if (user==null){
            throw new RuntimeException("密码修改失败");
        }
        return userDao.updateLoginPwd(user);
    }

    /**
     * 发送验证码
     * @param type 类型
     * @param value 发送的内容
     */
    public void sendMsg(String type,String value){
        String code="456123";
        if(type.equals("phone")){
            AliMsgApi.sendMsg(null,value,code);
        }else if (type.equals("email")){
            SendMail.send(value,"测试邮箱","success:成功"+code);
        }
        Cache.setCodeCache(code);
    }
}
