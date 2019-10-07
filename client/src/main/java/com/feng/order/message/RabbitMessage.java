package com.feng.order.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/3 13:53
 * @Version V1.0
 */
@Component
public class RabbitMessage {

    @RabbitListener(bindings =@QueueBinding(
                value =@Queue("shuQueue"),
                exchange =@Exchange("myExchange"),
                key ="shu"
            ))
    public void getMessage1(String message){
        System.out.println("shu:"+message);
    }

    @RabbitListener(bindings =@QueueBinding(
            value =@Queue("kanQueue"),
            exchange =@Exchange("myExchange"),
            key ="kan"
    ))
    public void getMessage2(String message){
        System.out.println("kan:"+message);
    }

}
