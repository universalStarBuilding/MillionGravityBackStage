package com.fengyu.modules.dao.project.msg;

import com.fengyu.common.persistence.annotation.MyBatisDao;
import com.fengyu.modules.model.Order;
import com.fengyu.modules.webservice.project.vo.OrderVo;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.List;

/**
 *我支持的项目
 */
@MyBatisDao
public interface OrderDao {

    //统计数量
    long queryById(OrderVo orderVo);
    //查询支持列表
    List<Order> orderPageList(OrderVo orderVo);
    //统计支持的数量
    Integer supportNumber(Order order);
    //查询所有订单列表
    List<Order> getOrderList(Order order);
    //查询订单状态列表
    List<Order> getStateOrderList(Order order);
    //统计订单的总数
    Integer orderPage(Order order);
}