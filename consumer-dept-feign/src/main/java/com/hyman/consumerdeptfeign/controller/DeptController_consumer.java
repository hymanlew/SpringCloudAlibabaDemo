package com.hyman.consumerdeptfeign.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptClientService;
import com.hyman.cloudapi.service.FeignClientServiceDemo;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.FallbackCommand;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/deptConsumer")
public class DeptController_consumer {

    @Autowired
    private DeptClientService deptClientService;
    @Autowired
    private FeignClientServiceDemo feignClientServiceDemo;

    /**
     * 当 FeignClient 中的路径使用 @RequestMapping 时，则 controller 中访问的路径不能与前者完全相同。因为这样，当请求头为
     * Accept:application/json 时，就会报 404。或者在 FeignClient 上使用原生注解 @RequestLine，也可以解决此问题。
     * 最主要的是要保证入参能够顺利传递进去即可。
     *
     * 并且在使用 @PathVariable 注解时，要指定其 value。
     */
    @GetMapping("/getById/{id}")
    @Hystrix
    public Department findById(@PathVariable("id") Integer id){
        return deptClientService.findById(id);
    }

    @PostMapping("/findAll")
    public List<Department> findall(){
        return deptClientService.findall();
    }

    @GetMapping("/save")
    public boolean save(@RequestBody Department department){
        return deptClientService.save(department);
    }

    // 消费者调用服务发现
    @RequestMapping("/discovery")
    public Object discovery(){
        return  deptClientService.discovery();
    }

    @GetMapping("/getService/{id}")
    public Object getService(@PathVariable("id") Integer id) {
        return feignClientServiceDemo.getService(id);
    }
}
