package com.hyman.providerdepthystrix8001.service;

import com.hyman.cloudapi.entity.Department;

import java.util.List;

public interface DeptService {

    boolean addDept(Department department);

    Department findById(int id);

    List<Department> findAll();
}
