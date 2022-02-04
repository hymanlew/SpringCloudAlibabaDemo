package com.hyman.cloudapi.service;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.fallback.DeptFeignFallback;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "microservice-provider-dept", fallback = DeptFeignFallback.class, primary = false)
public interface DeptService {

    @PostMapping("/save")
    boolean addDept(@RequestBody Department department);

    @GetMapping("/getById/{id}")
    Department findById(@PathVariable("id") int id);

    @GetMapping("/findAll")
    List<Department> findAll();

    /**
     * 当 FeignClient 中的路径使用 @RequestMapping 时，则 controller 中注解的路径不能与前者完全相同。因为这样，当请求头为
     * Accept:application/json 时，就会报 404。
     * 需要在 FeignClient 上使用原生注解 @RequestLine，和 @Headers可以解决此问题。最主要的是要保证入参能够顺利传递进去即可。
     *
     * 并且在使用 @PathVariable 注解时，要指定其 value。
     */
    //@RequestMapping("/discovery")
    @RequestLine(value = "GET /deptConsumer/discovery")
    @Headers("Accept:application/json")
    Object discovery();
}
