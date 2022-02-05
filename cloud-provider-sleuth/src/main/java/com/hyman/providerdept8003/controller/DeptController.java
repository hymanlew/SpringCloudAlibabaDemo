package com.hyman.providerdept8003.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.providerdept8003.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/getById/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return deptService.findById(id);
    }

    @PostMapping("/findAll")
    public List<Department> findall(){
        return deptService.findAll();
    }
}
