    package com.jinyu.controller;

import com.jinyu.model.Order;
import com.jinyu.service.CustomerService;
import com.jinyu.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:11
 * Version: V0.1
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/shardingApplicationContext.xml"})
public class ShardingJdbcSrpingDemo {

    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
//        Order order = orderService.getOrder(1001);
//        Order order = new Order();
//        order.setOrderId(1008);
//        order.setUserId(8);
//        this.orderService.addOrder(order.getOrderId(),order.getUserId());
//        System.out.println("orderID:"+order.getOrderId()+"orderNO:"+order.getUserId());



    }
}
