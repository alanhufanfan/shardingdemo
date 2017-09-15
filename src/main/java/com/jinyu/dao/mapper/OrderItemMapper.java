package com.jinyu.dao.mapper;

import com.jinyu.model.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:35
 * Version: V0.1
 */
public interface OrderItemMapper {
    OrderItem selectById(@Param("itemId") long itemId);

    public void insert(long orderId,long userId,long itemId);

}
