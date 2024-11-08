package com.itheima.consumer.conf;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:35 2024/11/7
 */
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    public static final String TOPIC_EXCHANGE_NAME = "hmall.topic";
    public static final String QUEUE_ONE_NAME = "topic.queue1";
    public static final String QUEUE_TWO_NAME = "topic.queue2";
    public static final String ROUTING_KEY_ONE = "china.#";
    public static final String ROUTING_KEY_TWO = "#.news";

    // 创建队列1
    @Bean
    public Queue queue_1() {
        return new Queue(QUEUE_ONE_NAME);
    }

    // 创建队列2
    @Bean
    public Queue queue_2() {
        return new Queue(QUEUE_TWO_NAME);
    }

    // 创建topic交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    // 将队列1和交换机绑定，使用路由键topic.key1
    @Bean
    public Binding binding_1(Queue queue_1, TopicExchange topicExchange) {
//        return BindingBuilder.bind(queue_1).to(topicExchange).with(ROUTING_KEY_ONE);
        return BindingBuilder.bind(queue_1()).to(topicExchange()).with(ROUTING_KEY_ONE);//直接调方法也可以，解释：spring的ioc容器，单例bean，
                                                                                        // 先检查是否存在对应方法名的bean，如果存在直接获取，
                                                                                         // 不存在执行该方法并返回
    }

    // 将队列2和交换机绑定，使用路由键topic.key2.*
    @Bean
    public Binding binding_2(Queue queue_2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue_2).to(topicExchange).with(ROUTING_KEY_TWO);
    }
}
