package com.fengyu.modules.dao.user;

import com.fengyu.common.persistence.CrudDao;
import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.PostAddress;
import com.fengyu.system.entity.LogAccess;

import java.util.List;

@MyBatisDao
public interface PostAddressDao extends CrudDao<PostAddress> {
    //查询收货地址详细信息
    PostAddress getPostAddress(Integer id);
    //增加收货地址
    int insert(PostAddress record);
    //删除收获地址
    int delete(Integer id);
    //修改收货地址
    Integer updatePostAddress(PostAddress postAddress);
    //查询收货列表
    List<PostAddress>getListPostAddress(PostAddress postAddress);
    //统计数据
    long postAddressPage(PostAddress postAddress);
}