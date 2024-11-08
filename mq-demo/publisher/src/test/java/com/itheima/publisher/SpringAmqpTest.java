package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
        String exc="hmall.fanout";
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
    @Test
    public void test2Dir1(){
        String exc="directExchange";
        String msg="hello,simple.queue,this is a test msg to direct.queue1";
        System.out.println("准备发送");
        rabbitTemplate.convertAndSend(exc,"key1",msg);
        System.out.println("发送完成");
    }
    @Test
    public void test2Dir2(){
        String exc="directExchange";
        String msg="hello,simple.queue,this is a test msg to direct.queue2";
        System.out.println("准备发送");
        rabbitTemplate.convertAndSend(exc,"key2",msg);
        System.out.println("发送完成");
    }
    @Test
    public void test2Topic1(){
        String exc="hmall.topic";
        String msg="hello,simple.queue,this is a test msg to topic.queue1 with routing key 'china.news' ";
        System.out.println("准备发送");
        rabbitTemplate.convertAndSend(exc,"china.news",msg);
        System.out.println("发送完成");
    }
    @Test
    public void test2Topic2(){
        String exc="hmall.topic";
        String msg="hello,simple.queue,this is a test msg to topic.queue1 with routing key 'jiangsu.news' ";
        System.out.println("准备发送");
        rabbitTemplate.convertAndSend(exc,"jiangsu.news",msg);
        System.out.println("发送完成");
    }
    @Test
    public void test2Annotation(){
        String exc="myExchange1";
        String msg="hello,simple.queue,this is a test msg to topic.queue1 with routing key 'lpl.lol' ";
        System.out.println("准备发送");
        rabbitTemplate.convertAndSend(exc,"lop.lol",msg);
        System.out.println("发送完成");
    }
    @Test
    public void test2Map(){
        String queueName="object.queue";
        Map<String,Object> map=new HashMap<>();
        map.put("name","jack");
        map.put("age",20);
        rabbitTemplate.convertAndSend(queueName,map);
    }
}
