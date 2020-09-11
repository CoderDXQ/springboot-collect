package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service  //业务层
public class AsyncService {

    @Async //标识这是一个异步方法
    public void hello(){
        try{
            Thread.sleep(3000);

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("处理数据中。。。");
    }
}
