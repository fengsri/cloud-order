package com.feng.order.controller;

import com.alibaba.fastjson.JSON;
import com.feng.order.client.ProductClient;
import com.feng.order.domain.Detail;
import com.feng.order.domain.Order;
import com.feng.order.domain.Product;
import com.feng.order.message.StreamClient;
import com.feng.order.repository.DetailRepository;
import com.feng.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/3 11:33
 * @Version V1.0
 */
@RestController
@RequestMapping("test")
@RefreshScope
public class TestController {

    @Autowired
    private StreamClient streamClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProductClient productClient;

    @Value("${env.name}")
    private String name;

    @GetMapping("name")
    public String getName(){
        return name;
    }

    @PostMapping("save")
    public String save(){
        Order order = new Order();
        order.setId(10);
        order.setOrderNum("1234567");
        orderRepository.save(order);
        return "成功";
    }

    @GetMapping("sendMessage")
    public void sendMessage(){
        streamClient.outPut().send(MessageBuilder.withPayload("this is stream message").build());
    }

    @GetMapping("test")
    public List<Product> test(){
        List<Product> productList = productClient.getByIds(Arrays.asList(1,2));
        redisTemplate.opsForValue().set("key", JSON.toJSONString(productList));
        return productList;
    }
}
