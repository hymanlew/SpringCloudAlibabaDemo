package com.hyman.providerdept8002.service.impl;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import com.hyman.providerdept8002.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImp implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Department department) {
        return deptDao.addDept(department);
    }

    @Override
    public Department findById(int id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return deptDao.findAll();
    }
}
