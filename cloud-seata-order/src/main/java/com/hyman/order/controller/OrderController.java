package com.hyman.order.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import com.hyman.common.feign.IBaseFeign;
import com.hyman.common.msg.Result;
import com.hyman.order.dao.OrderDao;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderDao orderDao;
    @Resource
    private DeptService deptService;
    @Resource
    private IBaseFeign baseFeign;

    @PostMapping("/add")
    public Department addOrder(@RequestBody Department department){

        boolean add = orderDao.addDept(department);
        if(add){

            boolean dept = deptService.addDept(department);
            if(dept){

                Result<String> city = baseFeign.getCityCode("city");
                if(city.getSuccess()){
                    return orderDao.findById(department.getId());
                }
            }
        }
        return null;
    }

    @GetMapping("/getById/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return orderDao.findById(id);
    }

}
