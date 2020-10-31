package com.hyman.nacosconfig.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sentinel starter 在默认情况下会为所有的 HTTP 服务提供限流埋点，所以如果只想对 HTTP 服务进行限流，则只需要添加依赖即可，不需要
 * 修改任何代码。
 * 如果想要对特点的方法进行限流或降级，则需要通过 @SentinelResource 注解来实现限流资源的定义。可通过 SphU.entry("method-name")
 * 来配置资源。
 */
@RestController
public class SentinelController {

    /**
     * 使用该 SentinelResource 注解配置限流保护资源
     */
    @SentinelResource(value = "hello", blockHandler = "blockHandlerHello")
    @GetMapping("/say")
    public String hello(){
        return "hello hyman";
    }

    public String blockHandlerHello(){
        return "被限流了！";
    }


    @GetMapping("/clean/{id}")
    public String urlclean(){
        return "hello clean";
    }
}
