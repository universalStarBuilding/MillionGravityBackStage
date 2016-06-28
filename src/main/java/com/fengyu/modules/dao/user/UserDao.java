package com.fengyu.modules.dao.user;


import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.User;

@MyBatisDao
public interface UserDao extends CrudDao<User> {
    //根据用户id查询手机号是否存在
    String getPhone(Integer id);
    //查询Email是否存在
    String getEmail(Integer id);
    //隐藏手机号和邮箱的一些字段
    String getContact(Integer id);
    //修改手机号
    Integer updatePhone(User user);
    //修改邮箱
    Integer updateEmail(User user);
    //修改登录密码
    Integer updateLoginPwd(User user);
}