package com.itheima.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:04 2024/11/6
 */
@Component
@Slf4j
public class MqListeners {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){//直接写处理逻辑
        log.info(msg);
        System.out.println("消费者1号收到simple.queue德消息，内容为:"+msg);
    }
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue2(String msg){//这个只能轮询访问。
        log.info(msg);
        System.out.println("消费者2号收到simple.queue德消息，内容为:"+msg);
    }
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {//这个只能轮询访问。
        log.info(msg);
        System.out.println("消费者1号收到simple.queue德消息，内容为:"+msg);
        Thread.sleep(20);
    }
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {//这个只能轮询访问。
        log.info(msg);
        System.out.println("消费者2号收到simple.queue德消息，内容为:"+msg);
        Thread.sleep(200);
    }
    @RabbitListener(queues = "object.queue")
    public void objectQueue(Map map){
        System.out.println("object.queue接收到消息，内容为: "+map);
    }
}