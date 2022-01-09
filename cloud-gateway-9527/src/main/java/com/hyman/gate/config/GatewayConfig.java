package com.hyman.gate.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * 断言原理：
 * gateway 将路由匹配作为 spring webflux handlerMapping 基础架构的一部分。它包含了多个内置的 RoutePredicateFactory，所有这
 * 些断言都与 http 请求的不同属性相匹配。且多个 route Predicate 工厂可以通过 and 逻辑进行组合使用。
 *
 * gateway 创建 route 对象时，使用 RoutePredicateFactory 创建 Predicate 对象，Predicate 对象可以赋值给 Route。其作用就是实
 * 现了一组匹配规则，对请求作对应的 route 处理。
 *
 * @Description: 以下是网关路由第二种配置方式
 */
@Configuration
public class GatewayConfig {

    /**
     * 建议还是使用第一种 yml 配置的方式配置路由
     */
    @Bean
    public RouteLocator routeLocatorFilter(RouteLocatorBuilder builder) {

        /**
         * 配置了一个 id 为 cloud-alibaba-baidutest 的路由规则，当本地访问 localhost:30150/guonei 时，
         * 会自动转发到百度新闻的国内地址。
         */
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("cloud-alibaba-baidutest",
                r -> r.path("/guonei")
                        .uri("lb://news.baidu.com/guonei")).build();
        return routes.build();
    }

    public static void main(String[] args) {
        System.out.println("断言使用的时区时间 " + ZonedDateTime.now());
    }
}
