package com.hyman.cloudapi.fallback;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeptFeignFallback implements DeptService {

    @Override
    public boolean addDept(Department department) {
        return false;
    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Object discovery() {
        return null;
    }

}
