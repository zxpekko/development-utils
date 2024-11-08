package com.itheima.consumer.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:32 2024/11/7
 */
@Component
public class AnnotationListeners {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "myQueue", durable = "true"),
            exchange = @Exchange(value = "myExchange1", type = ExchangeTypes.TOPIC),
            key = "#.lol"
    ))
    public void mqListener(String msg){
        System.out.println("myQueue接收到消息，内容为"+msg);
    }
//    @RabbitListener
//    public void mq(String msg){
//
//    }
}
