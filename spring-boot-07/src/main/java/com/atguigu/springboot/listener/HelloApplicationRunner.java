package com.atguigu.springboot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...");
    }
}
