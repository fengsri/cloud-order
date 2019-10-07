package com.feng.order.controller;


import com.alibaba.fastjson.JSON;
import com.feng.order.client.ProductClient;
import com.feng.order.domain.Detail;
import com.feng.order.domain.Product;
import com.feng.order.repository.DetailRepository;
import com.feng.order.repository.OrderRepository;
import com.feng.order.service.OrderService;
import com.feng.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:22
 * @Version V1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private  ProductClient productClient;

    @Autowired
    private OrderService orderService;


    @PostMapping("create")
    public String order(@RequestBody OrderVo orderVo){
        boolean result = orderService.createOrder(orderVo);
        if (result){
            return "成功：";

        }
        return "失败";
    }


}
