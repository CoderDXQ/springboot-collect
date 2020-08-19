package com.atguigu.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAMQPConfig {

    @Bean//配置反序列化
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
