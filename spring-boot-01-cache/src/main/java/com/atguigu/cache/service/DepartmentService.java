package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired //装载接口类
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")//可缓存
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department=departmentMapper.getDeptById(id);
        return department;
    }


}
