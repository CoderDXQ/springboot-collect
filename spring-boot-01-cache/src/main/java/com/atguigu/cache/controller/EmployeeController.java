package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//controller里的东西都是在前端展示的
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee  = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }


}
