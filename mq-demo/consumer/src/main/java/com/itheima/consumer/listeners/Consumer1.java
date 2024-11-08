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
    @RabbitListener(queues = "fanout.queue1")
    public void test(String msg){
        System.out.println("fanout.queue1接收到消息:"+msg);
    }
    @RabbitListener(queues = "direct.queue1")
    public void testdirect(String msg){
        System.out.println("direct.queue1接收到消息:"+msg);
    }
    @RabbitListener(queues = "topic.queue1")
    public void testTopic(String msg){
        System.out.println("topic.queue1接收到消息:"+msg);
    }
}
