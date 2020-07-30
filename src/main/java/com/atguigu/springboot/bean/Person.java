package com.atguigu.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定，默认从全局配置文件中获取值
 * prefix="person"：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件才能使用容器提供的@，使用这个注解@Component
 */
@PropertySource(value={"classpath:person.properties"}) //加载指定的自定义配置文件 会递归寻找这个名字的配置文件 需要配合@ConfigurationProperties(prefix = "person")
@Component

//将配置文件中的每个属性映射到person类组件中
@ConfigurationProperties(prefix = "person") //配合@Validated可以进行数据校验 与属性类person进行绑定，在没有@PropertySource的自定义的情况下从只能从全局配置文件application.properties中获取值
//@Validated
public class Person {
    /**
     * @Value注解只能获取配置文件的某项值，不能获取对象的值
     * <bean class="Person">
     *     <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEl}"></property>
     * </bean>
     */

   // @Email //这个注解可以校验下面这个变量是不是Email格式
  //  @Value("${person.last-name}")//获取字面量 这种写法大写字母必须用"-小写字母"的形式表示 松散绑定
    private String lastName;
    private String surName;
 //   @Value("#{11*3}")//获取值 支持SpEL
    private Integer age;
    private Boolean boss;
    private Date birth;
    //@Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {//每个变量都要有set、get方法，否则无法取得数值
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
