package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
//这是一个映射类，定义了两个操作数据库的方法，方法的实现在EmployeeMapper.xml文件中，是使用配置文件实现的
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
    //上面两个方法的实现在EmployeeMapper.xml中
}
