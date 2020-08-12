package com.atguigu.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication//加上这个web应用才有效
@EnableConfigurationProperties(HelloProperties.class)//使某个配置生效
public class HelloServiceAutoConfiguration {

    @Autowired //自动装配 下面的方法要用这个
    HelloProperties helloProperties;

    @Bean//装载到容器中
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);//设置service的配置
        return service;
    }



}
