package com.hyman.nacosconfig.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 二，基于 sentinel dashboard 实现流控（Sentinel starter 在默认情况下会为所有的 HTTP 服务提供限流埋点）:
 * 1，启动 sentinel dashboard。
 * 2，在 application.yml 中配置一下。
 * 3，在页面中，簇点链路页面，找到需要流控的接口名称，配置流控即可。
 *
 * 一，另一种是手动配置流控规则
 * @see com.hyman.nacosconfig.config.FlowRuleInitWithoutBoot
 */
@Configuration
public class DashboardSentinelConfig {

    /**
     * 在 sentinel 中需要被保护的资源，可以是一个代码块，一个方法或者一个接口。这里通过 Filter 的方式，将所有请求都定义为资源（/*）,
     * 那么我们请求的过程就会变成这样子：
     * Nginx --> filter --> transport --> sentinel --> transport --> filter --> controller
     */
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {

        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelFilter");
        registration.setOrder(1);

        return registration;
    }
}
