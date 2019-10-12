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
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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




    /**
     * 第一种获取服务通信的方式RestTemplate直接写死url
     * @return
     */
    @GetMapping("getMessgae")
    public String listProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String message = restTemplate.getForObject("http://localhost:8083/test/msg", String.class);
        return message;
    }

    @Autowired
    private LoadBalancerClient balancerClient;
    /**
     * 第二种获取服务通信的方式LoadBalancerClient
     * @return
     */
    @GetMapping("getMessgae2")
    public String listProduct2(){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = balancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",instance.getHost(),instance.getPort());
        String message = restTemplate.getForObject(url, String.class);
        return message;
    }


    @Autowired
    private  RestTemplate restTemplate;
    /**
     * 第三种获取服务通信的方式
     * @return
     */
    @GetMapping("getMessgae3")
    public String listProduct3(){

        String message = restTemplate.getForObject("http://PRODUCT/test/msg", String.class);
        return message;
    }

    @Value("${env.name}")
    private String name;


    @GetMapping("name")
    public String getName2() throws InterruptedException {
        Thread.sleep(2000);
        return name;
    }

    @GetMapping("name")
    public String getName() throws InterruptedException {
        Thread.sleep(2000);
        return name;
    }

    @Autowired
    private StreamClient streamClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;


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


    @Autowired
    private ProductClient productClient;


    @GetMapping("listProduct")
    public List<Product> test(){
        List<Product> productList = productClient.getByIds(Arrays.asList(1,2));
        redisTemplate.opsForValue().set("key", JSON.toJSONString(productList));
        return productList;
    }
}
