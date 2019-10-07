package com.feng.order.service;

import com.feng.order.domain.Product;
import com.feng.order.vo.OrderVo;

import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/2 20:23
 * @Version V1.0
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderVo
     * @return
     */
    boolean createOrder(OrderVo orderVo);

}
