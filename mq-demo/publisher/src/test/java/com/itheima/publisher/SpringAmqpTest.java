package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:48 2024/11/6
 */
@SpringBootTest
public class SpringAmqpTest {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void test2Msg(){
        String queueName="simple.queue";
        String msg="hello,simple.queue,this is a test msg";
        rabbitTemplate.convertAndSend(queueName,msg);
    }
    @Test
    public void test2Exc(){
        String exc="broadcast_exchange";
        String msg="hello,simple.queue,this is a test msg";
        System.out.println("准备发送");
        rabbitTemplate.convertAndSend(exc,"",msg);
        System.out.println("发送完成");
    }
    @Test
    public void test2WorkQueue() throws InterruptedException {
        String exc="work.queue";
        String msg="hello,simple.queue,this is a test msg";
        for(int i=1;i<=50;i++){
            rabbitTemplate.convertAndSend(exc,msg+i);
            Thread.sleep(20);
        }
//        System.out.println("准备发送");

//        System.out.println("发送完成");
    }
}
