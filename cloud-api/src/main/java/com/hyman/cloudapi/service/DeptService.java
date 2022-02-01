package com.hyman.cloudapi.service;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.fallback.DeptFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "microservice-provider-dept", fallback = DeptFeignFallback.class, primary = false)
public interface DeptService {

    @PutMapping("/save")
    boolean addDept(@RequestBody Department department);

    @GetMapping("/getById/{id}")
    Department findById(@PathVariable("id") int id);

    @GetMapping("/findAll")
    List<Department> findAll();

    @RequestMapping("/discovery")
    Object discovery();
}
