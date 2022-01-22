package com.hyman.cloudapi.fallback;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class DeptFeignFallback implements FallbackFactory<DeptService> {

    @Override
    public DeptService create(Throwable cause) {
        return new DeptService() {

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
        };
    }
}
