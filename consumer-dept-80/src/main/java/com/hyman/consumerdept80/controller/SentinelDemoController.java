package com.hyman.consumerdept80.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 更多 Sentinel 配置及理论概念，可参见 single-nacos-sentinel 服务。
 * @see com.hyman.nacosconfig.controller.ParamRuleController
 * @see com.hyman.nacosconfig.config.FlowRuleInitWithoutBoot
 */
@Slf4j
@RestController
@RequestMapping("/deptConsumer")
public class SentinelDemoController {

    @Resource
    private DeptService deptService;

    @GetMapping("/getById/{id}")
    @SentinelResource(value = "getById", fallback = "handlerFallback", blockHandler = "myBlockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public Department findById(@PathVariable("id") Integer id){
        return deptService.findById(id);
    }

    /**
     * 若 blockHandler 和 fallback 都进行了配置，则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑。若未
     * 配置 blockHandler、fallback 和 defaultFallback，则被限流降级时会将 BlockException 直接抛出。
     */
    @GetMapping("/findAll")
    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    public List<Department> findall() {

        List<Department> all = deptService.findAll();
        if(all.size() == 0){
            throw new RuntimeException("数据为空！");
        }
        return all;
    }

    @PutMapping("/save")
    public boolean save(@RequestBody Department department){
        return deptService.addDept(department);
    }

    /**
     * 消费者调用服务发现
     */
    /**
     * 当 FeignClient 中的路径使用 @RequestMapping 时，则 controller 中注解的路径不能与前者完全相同。因为这样，当请求头为
     * Accept:application/json 时，就会报 404。
     * 需要在 FeignClient 上使用原生注解 @RequestLine，和 @Headers可以解决此问题。最主要的是要保证入参能够顺利传递进去即可。
     *
     * 并且在使用 @PathVariable 注解时，要指定其 value。
     */
    @RequestMapping("/discovery")
    public Object discovery(){
        return  deptService.discovery();
    }

    public List<Department> handlerFallback(Throwable throwable) {
        log.error("handlerFallback 处理异常 --- " + throwable.getMessage());
        return new ArrayList<>();
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
