package com.itheima.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:02 2024/11/6
 */
@Component
public class Consumer2 {
    @RabbitListener(queues = "fanout.queue2")
    public void test(String msg){
        System.out.println("fanout.queue2接收到消息:"+msg);
    }
    @RabbitListener(queues = "direct.queue2")
    public void testDirect(String msg){
        System.out.println("direct.queue2接收到消息:"+msg);
    }
    @RabbitListener(queues = "topic.queue2")
    public void testTopic(String msg){
        System.out.println("topic.queue2接收到消息:"+msg);
    }
}
