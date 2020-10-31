package com.hyman.nacosconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 二，基于 sentinel dashboard 实现流控（Sentinel starter 在默认情况下会为所有的 HTTP 服务提供限流埋点）:
 * 1，启动 sentinel dashboard。
 * 2，在 application.yml 中配置一下。
 * 3，在页面中，簇点链路页面，找到需要流控的接口名称，配置流控即可。
 *
 * 一，另一种是手动配置流控规则
 * @see com.hyman.nacosconfig.config.FlowRuleInit
 */
@RestController
public class DashboardController {

    @GetMapping("/dash")
    public String hello(){
        return "hello hyman dash";
    }
}
