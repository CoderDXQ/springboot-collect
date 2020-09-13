package com.atguigu.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //定制请求的授权规则,一个*是当前目录下的一级文件，两个**是当前目录下的任意级文件
        httpSecurity.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登录功能
        httpSecurity.formLogin();

        //开启自动配置的注销功能
        httpSecurity.logout().logoutSuccessUrl("/");//，不加最后一个方法的话是回到登录页面

    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                //这里的密码设置为不加密的形式 使用了Spring security5.0以上的同学需要使用加密算法，这里使用{noop}可以设置为非加密的形式
                .withUser("zhangsan").password("{noop}123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("{noop}123456").roles("VIP3","VIP2")
                .and()
                .withUser("wangwu").password("{noop}123456").roles("VIP1","VIP3");
    }



}
