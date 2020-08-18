package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//k-v都是字符串

    @Autowired
    RedisTemplate empRedisTemplate;//k-v都是对象

    @Test
    public void test01(){
        //给redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
//        stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");

    }

    //测试保存对象
    @Test
    public void test02(){

        Employee empById = employeeMapper.getEmpById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化之后的数据保存到redis中
//        System.out.println(empById);
//        redisTemplate.opsForValue().set("emp-01",empById);
        System.out.println(empById);
        //将序列化对象转化为json保存在redis中 改变默认的序列化规则
        empRedisTemplate.opsForValue().set("emp-01",empById);

    }

    @Test
    public void contextLoads() {

        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
