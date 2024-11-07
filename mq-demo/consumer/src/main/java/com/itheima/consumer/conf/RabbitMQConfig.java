package com.itheima.consumer.conf;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:59 2024/11/6
 */
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String BROADCAST_EXCHANGE_NAME = "broadcast_exchange";

    // 创建一个随机名称的队列（这里简化处理，实际可以根据需求定制）
    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }

    // 创建一个随机名称的队列（这里简化处理，实际可以根据需求定制）
    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

    // 创建Fanout交换器
    @Bean
    public FanoutExchange broadcastExchange() {
        return new FanoutExchange(BROADCAST_EXCHANGE_NAME);
    }

    // 将queue1和交换器绑定
    @Bean
    public Binding binding1(Queue queue1, FanoutExchange broadcastExchange) {
        return BindingBuilder.bind(queue1).to(broadcastExchange);
    }

    // 将queue2和交换器绑定
    @Bean
    public Binding binding2(Queue queue2, FanoutExchange broadcastExchange) {
        return BindingBuilder.bind(queue2).to(broadcastExchange);
    }
}