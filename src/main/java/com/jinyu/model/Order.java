package com.jinyu.model;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:19
 * Version: V0.1
 */
public class Order {
    private long orderId;
    private long userId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
