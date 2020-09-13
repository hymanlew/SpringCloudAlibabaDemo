package com.hyman.cloudconfigdept8001.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudconfigdept8001.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    // 对于注册进 eureka 里面的微服务，可以通过服务发现来获得该服务的信息。
    @Autowired
    private DiscoveryClient client;

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

    @RequestMapping("/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("eureka 中所有已经注册的服务列表："+list);

        // 按照服务名称来得到某个服务，注意该名称是在 spring 中配置的名字，而不是在 eureka 中自定义的名字，且eureka 会自动转换为大写。
        List<ServiceInstance> serviceInstances = client.getInstances("microservice-provider-dept");
        for(ServiceInstance instance : serviceInstances){
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }
        return this.client;
    }
}
