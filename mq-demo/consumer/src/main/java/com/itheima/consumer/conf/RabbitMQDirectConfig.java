package com.itheima.consumer.conf;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:35 2024/11/7
 */
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    public static final String DIRECT_EXCHANGE_NAME = "directExchange";
    public static final String QUEUE_ONE_NAME = "direct.queue1";
    public static final String QUEUE_TWO_NAME = "direct.queue2";
    public static final String ROUTING_KEY_ONE = "key1";
    public static final String ROUTING_KEY_TWO = "key2";

    // 创建第一个队列
    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE_NAME);
    }

    // 创建第二个队列
    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_TWO_NAME);
    }

    // 创建direct交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    // 将队列一和交换机绑定，使用routingKey1
    @Bean
    public Binding bindingOne(Queue queueOne, DirectExchange directExchange) {
        return BindingBuilder.bind(queueOne).to(directExchange).with(ROUTING_KEY_ONE);
    }

    // 将队列二和交换机绑定，使用routingKey2
    @Bean
    public Binding bindingTwo(Queue queueTwo, DirectExchange directExchange) {
        return BindingBuilder.bind(queueTwo).to(directExchange).with(ROUTING_KEY_TWO);
    }
}
