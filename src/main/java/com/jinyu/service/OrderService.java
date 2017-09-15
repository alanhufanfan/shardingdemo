package com.jinyu.service;

import com.jinyu.model.Order;
import com.jinyu.model.OrderItem;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:34
 * Version: V0.1
 */
public interface OrderService {
    public Order getOrder(long id);
    public OrderItem getOrderItem(long id);

    public void addOrder(long orderId,long userId);
    public void addOrderItem(long orderId,long userId,long itemId);
}
