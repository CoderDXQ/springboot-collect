package com.atguigu.ticket.service;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;

@EnableDubbo
@Service //选择dubbo的注解 将服务发布出去
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket(){
        return "《厉害了，我的国》";
    }
}
