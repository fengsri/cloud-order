package com.feng.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/3 14:14
 * @Version V1.0
 */
@Component
public interface StreamClient {

    @Input("myMessage")
    SubscribableChannel inPut();

    @Output("myMessage")
    MessageChannel outPut();

}
