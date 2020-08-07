package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动类执行时会扫描其所在包的文件，即扫描springboot文件夹下的文件
@SpringBootApplication
public class SpringBoot06DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06DataJpaApplication.class, args);
    }

}
