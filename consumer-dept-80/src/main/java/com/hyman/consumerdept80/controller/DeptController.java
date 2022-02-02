package com.hyman.consumerdept80.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Nacos 是服务注册与发现，分布式配置中心，默认集成了 Ribbon，可提供客户端负载均衡。
 */
@RestController
@RequestMapping("/deptConsumer")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 当 FeignClient 中的路径使用 @RequestMapping 时，则 controller 中访问的路径不能与前者完全相同。因为这样，当请求头为
     * Accept:application/json 时，就会报 404。或者在 FeignClient 上使用原生注解 @RequestLine，也可以解决此问题。
     * 最主要的是要保证入参能够顺利传递进去即可。
     *
     * 并且在使用 @PathVariable 注解时，要指定其 value。
     */
    @GetMapping("/getById/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return deptService.findById(id);
    }

    @PostMapping("/findAll")
    public List<Department> findall(){
        return deptService.findAll();
    }

    @GetMapping("/save")
    public boolean save(@RequestBody Department department){
        return deptService.addDept(department);
    }

    // 消费者调用服务发现
    @RequestMapping("/discovery")
    public Object discovery(){
        return  deptService.discovery();
    }

}
