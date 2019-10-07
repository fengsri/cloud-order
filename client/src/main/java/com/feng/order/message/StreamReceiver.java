package com.feng.order.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/3 14:26
 * @Version V1.0
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener("myMessage")
    public void receiverMessage(Object message){
        System.out.println(message);
    }


}
