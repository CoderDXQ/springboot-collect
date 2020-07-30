package com.atguigu.springboot;

import com.atguigu.springboot.bean.Person;
import com.atguigu.springboot.service.HelloService;
//import org.apache.catalina.core.ApplicationContext; //这个包有问题
import org.springframework.context.ApplicationContext; //导入方法依赖的package包/类
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Boot单元测试；
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired //自动装配
    Person person;

    @Autowired //自动装配
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("helloService02");//按组件名检查容器里是否包含某个组件 Bean意思是组件，本质是一种特殊的类
        System.out.println(b);
    }


    @Test
    public void contextLoads() {
        System.out.println(person);
    }
}
