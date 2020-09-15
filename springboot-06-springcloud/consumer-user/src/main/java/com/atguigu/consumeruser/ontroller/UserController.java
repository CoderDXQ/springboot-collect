package com.atguigu.consumeruser.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {//可以认为这个类是在controller层实现了service层的某些类的功能

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")//可以传入字符串
    public String buyTicket(String name){
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name+"购买了"+s;
    }

}
