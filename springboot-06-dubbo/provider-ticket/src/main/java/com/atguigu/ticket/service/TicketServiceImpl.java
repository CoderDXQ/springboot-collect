package com.atguigu.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service //选择dubbo的注解 将服务发布出去
public class TicketServiceImpl implements main.java.com.atguigu.ticket.service.TicketService {
    @Override
    public String getTicket(){
        return "《厉害了，我的国》";
    }
}
