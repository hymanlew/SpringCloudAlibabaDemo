package com.hyman.consumerdept80.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deptConsumer")
public class DeptController_consumer {

    @Reference
    private DeptService deptService;

    @GetMapping("/getById/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return deptService.findById(id);
    }

    @PostMapping("/findAll")
    public List<Department> findall(){
        List<Department> list = new ArrayList<>();
        return list;
    }

    @GetMapping("/save")
    public boolean save(@RequestBody Department department){
        return true;
    }

    // 消费者调用服务发现
    @RequestMapping("/discovery")
    public Object discovery(){
        return null;
    }
}
