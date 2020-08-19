package com.atguigu.amqp;

import com.atguigu.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test//发送数据 单播
    public void contextLoads() {
        //Message需要自己构造一个；定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        //Object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,message);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化之后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
    }

    @Test//发送数据
    public void contextLoads1() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化之后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("书名","作者"));
    }

    @Test//接收数据，消息队列中有数据才能接收，否则要先往消息队列中发送一条消息，接收后消息队列少一条消息
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @org.junit.Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("shu","zuozhe"));
    }




}
