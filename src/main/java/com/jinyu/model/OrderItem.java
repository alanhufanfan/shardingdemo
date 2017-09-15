package com.jinyu.model;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:19
 * Version: V0.1
 */
public class OrderItem {
    private long itemId;
    private long orderId;
    private long userId;


    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

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
