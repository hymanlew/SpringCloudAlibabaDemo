package com.hyman.providerdept8001.dao;

import com.hyman.cloudapi.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface DeptDao {

    boolean addDept(Department department);

    Department findById(int id);

    List<Department> findAll();
}
