package com.hyman.providerdept8003.dao;

import com.hyman.cloudapi.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {

    boolean addDept(Department department);

    Department findById(int id);

    List<Department> findAll();
}
