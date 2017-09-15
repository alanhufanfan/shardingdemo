package com.jinyu.service.impl;

import com.jinyu.dao.mapper.OrderItemMapper;
import com.jinyu.dao.mapper.OrderMapper;
import com.jinyu.model.Order;
import com.jinyu.model.OrderItem;
import com.jinyu.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:34
 * Version: V0.1
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private OrderItemMapper orderItemMapper;


    public Order getOrder(long id){
       return this.orderMapper.selectById(id);
    }

    public OrderItem getOrderItem(long id){
        return this.orderItemMapper.selectById(id);
    }

    public void addOrder(long orderId,long userId){
        log.info("进入addOrder");
        this.orderMapper.insert(orderId,userId);
    }

    public void addOrderItem(long orderId,long userId,long orderItemId){
        log.info("进入addOrderItem");
        this.orderItemMapper.insert(orderId,userId,orderItemId);
    }
}
