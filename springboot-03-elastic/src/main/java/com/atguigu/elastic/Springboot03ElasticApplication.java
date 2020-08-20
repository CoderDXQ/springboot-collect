package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot03ElasticApplication {


    public static void main(String[] args) {
       // System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
