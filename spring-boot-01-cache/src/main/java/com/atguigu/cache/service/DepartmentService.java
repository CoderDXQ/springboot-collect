package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired //装载接口类
    DepartmentMapper departmentMapper;

    @Qualifier("departmentRedisCacheManager")
    @Autowired //装载缓存管理器
    RedisCacheManager departmentRedisCacheManager;

   // @Cacheable(cacheNames = "dept",cacheManager = "departmentRedisCacheManager")//可缓存 指定缓存管理器
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department=departmentMapper.getDeptById(id);

        //操作缓存 直接使用装载的缓存管理器进行操作
        Cache dept = departmentRedisCacheManager.getCache("dept");
        dept.put("dept:1",department);
        return department;
    }


}
