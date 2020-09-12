package com.atguigu.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SeheduledService {

    //@Autowired
    //@Scheduled(cron = "0 * * * * MON-SAT")
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
    //@Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0 * * * * *")//定时任务注解
    public void hello1(){
        System.out.println("hello...");
    }
}
