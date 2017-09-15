package com.jinyu.dao.mapper;

import com.jinyu.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/15 11:35
 * Version: V0.1
 */
public interface OrderMapper {
    public Order selectById(@Param("orderId") long orderId);

    public void insert(@Param("orderId")long orderId,@Param("userId")long userId);
}
