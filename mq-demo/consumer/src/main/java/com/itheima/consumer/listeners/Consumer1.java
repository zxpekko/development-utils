package com.itheima.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:02 2024/11/6
 */
@Component
public class Consumer1 {
    @RabbitListener(queues = "queue1")
    public void test(String msg){
        System.out.println("queue1接收到消息:"+msg);
    }
}
