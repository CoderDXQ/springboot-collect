package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//抽取缓存的公共配置
@CacheConfig(cacheNames = "emp")//有了这一句，下面的注解中的value = "emp"就可以去掉
//service里的东西都是在后端控制台里展示的
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

   // @Cacheable(value = {"emp"},key = "#root.methodName+'['+#id+']'")//将查询的返回结果进行缓存
   //a0>1缓存，a0=2不缓存，此时控制台同时输出id为1和2的结果，不缓存的会在控制台里打印
   // @Cacheable(value = {"emp"},keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2")//开启缓存，设置缓存条件
   @Cacheable(value = {"emp"})
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }



    @CachePut(value = "emp",key = "#result.id")//缓存更新 先调方法，再把方法的返回值放在缓存中
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    //@CacheEvict(value = "emp",key = "#id")//缓存清除 指定要清除的数据
    //@CacheEvict(value = "emp",allEntries = true)//缓存清除 删除所有数据 默认清除在方法执行之后
    @CacheEvict(value = "emp",beforeInvocation = true,allEntries = true)//设置在方法调用之前清除全部缓存
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
        int i=10/0;//这里会出错 如果设置了缓存在方法执行之后清除那么就会清除失败数据得以保留，如果设置了缓存在方法执行之前清除就会清除成功，可能会导致内存里的数据丢失
    }

    //定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(value="emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),//保证下面的方法一定会执行
                    @CachePut(value = "emp",key = "#result.email")
                    //CachePut先调方法再缓存，因此下面的方法是一定执行的，因此没事使用lastName查询一定会调数据库
            }
    )//规则：将按照lastName查询到的结果进行缓存，更新按照id和email查询的结果
    public Employee getEmpByLastName(String lastName){
       return employeeMapper.getEmpByLastName(lastName);
    }


}
