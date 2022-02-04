package com.hyman.order.dao;

import com.hyman.cloudapi.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    boolean addDept(Department department);

    Department findById(int id);

    List<Department> findAll();
}
