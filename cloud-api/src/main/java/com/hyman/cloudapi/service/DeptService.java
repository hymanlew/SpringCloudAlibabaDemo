package com.hyman.cloudapi.service;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.fallback.DeptFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "test-base", fallbackFactory = DeptFeignFallback.class, primary = false)
public interface DeptService {

    boolean addDept(Department department);

    Department findById(int id);

    List<Department> findAll();

    Object discovery();
}
