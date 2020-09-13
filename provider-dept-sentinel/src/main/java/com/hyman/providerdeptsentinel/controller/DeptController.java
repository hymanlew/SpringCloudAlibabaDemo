package com.hyman.providerdepthystrix8001.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.providerdepthystrix8001.service.DeptService;
//import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.support.FallbackCommand;
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

    /**
     * 一旦调用服务方法失败并抛出异常后，会自动调用 fallback 指定的方法。并且默认超时时间为 1 秒，这里设置为 3 秒。
     *
     * 如果希望将某些线程的本地上下文 context 传播到 @HystrixCommand 中，默认是不起作用的，因为它在线程池中执行命令（以防超时）。
     * 您可以通过配置或直接在注释中切换 Hystrix 以使用与调用者相同的线程，方法是要求它使用不同的“隔离策略”。
     * execution.isolation.strategy 有两个属性：
     * 1，thread，context 会在一个隔离的线程中被执行，并且此时的并发请求数会受到线程池线程数的限制。它是默认的属性。
     * 2，semaphore，信号量，context 会在当前的线程中被执行，并且此时的并发请求数会受到信号量大小的限制。
     *
     * 其含义是 HystrixCommand 注解的方法与 fallbackMethod 指定的方法，是否在同一个线程中被执行。
     * 而且在正常可使用的情况下，是不需要配置的，直到抛出异常，找不到作用域上下文，此时则需要配置使用相同的线程。
     *
     * 还可以选择将 hystrix.shareSecurityContext 属性设置为true。这样会自动配置一个 Hystrix并发策略插件挂钩，以便将 SecurityContext
     * 从主线程传输到 Hystrix 命令使用的线程。Hystrix 不允许注册多个 Hystrix并发策略，因此可以将自己的 Hystrix concurrency策
     * 略声明为 Spring bean来使用扩展机制。Spring Cloud 会在 Spring 上下文中查找您的实现，并将其包装在自己的插件中。
     * @return
     */
    @GetMapping("/getById/{id}")
    @HystrixCommand(
            fallbackMethod = "hystrixMethod",
            commandProperties ={
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000"),
                    @HystrixProperty(name="execution.isolation.strategy", value="THREAD")
            })
    public Department findById(@PathVariable("id") Integer id){

        Department department = deptService.findById(id);
        if(null == department){
            throw new RuntimeException("depart is null");
        }
        return department;
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

    public Object hystrixMethod(@PathVariable("id") Integer id){
        return "熔断异常！没有指定 ID 的数据："+id;
    }
}
