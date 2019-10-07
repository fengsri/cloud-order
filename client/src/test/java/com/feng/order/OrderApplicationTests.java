package com.feng.order;

import com.feng.order.domain.Order;
import com.feng.order.message.StreamClient;
import com.feng.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderApplicationTests {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private AmqpTemplate template;

    @Autowired
    private StreamClient streamClient;

    @Test
    void contextLoads() {
        template.convertAndSend("myExchange","kan","this is a kan message");
    }

    @Test
    void sendMessage() {
        streamClient.outPut().send(MessageBuilder.withPayload("this is a stream message").build());
    }

}
