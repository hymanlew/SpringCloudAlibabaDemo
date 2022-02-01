package com.hyman.providerdept8001.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 对于注册进 eureka 里面的微服务，可以通过服务发现来获得该服务的信息。
     */
    @Resource
    private DiscoveryClient client;

    @GetMapping("/getById/{id}")
    @SentinelResource(value = "getById", fallback = "handlerFallback", blockHandler = "myBlockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
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
        return list;
    }


    public Object myBlockHandler(String id, BlockException e){
        System.out.println("处理被流控（限流）的逻辑");
        return null;
    }

    public String handlerFallback(String id, Throwable throwable) {
        log.error("handlerFallback 处理异常 --- " + throwable.getMessage());
        return "";
    }
}
