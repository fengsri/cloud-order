package com.feng.order;

import com.feng.order.domain.Order;
import com.feng.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void save(){
        Order order = new Order();
        order.setOrderDate("2019-01-19");
        order.setOrderNum("123456");
        order.setOrderPrice(43.1);
        order.setOrderStatu("支付");
        Order orderResult = repository.save(order);
        System.out.println(orderResult);
    }

}