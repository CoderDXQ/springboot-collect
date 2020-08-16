package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//service里的东西都是在后端控制台里展示的
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

   // @Cacheable(value = {"emp"},key = "#root.methodName+'['+#id+']'")//将查询的返回结果进行缓存
   //a0>1缓存，a0=2不缓存，此时控制台同时输出id为1和2的结果，不缓存的会在控制台里打印
    @Cacheable(value = {"emp"},keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
}
