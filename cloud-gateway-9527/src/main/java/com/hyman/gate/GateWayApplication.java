package com.hyman.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Gateway 是 springcloud 自己研发的一套网关系统，用于代替 zuul，zuul2。旨在提供一种简单有效的方式来对 API 进行路由，并且基
 * 于 filter 调用链的方式提供一些强大的过滤器功能，如反向代理，熔断，限流，重试，安全，日志监控等。
 *
 * 它是以注册中心上微服务名为路径创建动态路由进行转发，或路径重写，从而实现动态路由的功能。即 SpringCloud-Gateway 的核心逻辑
 * 为：路由转发 + 断言 + 执行过滤器链。
 *
 */
@SpringCloudApplication
@EnableFeignClients({"com.hyman.gate.feign"})
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
