package com.atguigu.springboot.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//使用配置类来配置MyBatis，其实更方便的是使用*.xml文件来配置MyBatis
@Configuration
public class MyBatisConfig {


    //开启驼峰命名法，这是使用MyBatis的配置类来实现对MyBatis的配置
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);

            }
        };
    }
}
