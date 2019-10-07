package com.feng.order;

import com.feng.order.domain.Detail;
import com.feng.order.domain.Order;
import com.feng.order.repository.DetailRepository;
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
class DetailRepositoryTest {

    @Autowired
    private DetailRepository repository;



    @Test
    public void save(){
        Detail detail = new Detail();
        detail.setCount(1);
        detail.setOrderId(1);
        detail.setProductId(2);
        Detail result = repository.save(detail);
        System.out.println(result);
    }

}