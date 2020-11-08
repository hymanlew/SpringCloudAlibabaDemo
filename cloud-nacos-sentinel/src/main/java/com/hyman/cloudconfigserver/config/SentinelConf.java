package com.hyman.cloudconfigserver.config;

import org.apache.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * sentinel-apache-dubbo-adapter（sentinel 集成 dubbo 的 jar 包）：
 * 添加好依赖后，Dubbo 服务中的接口和方法（包括服务端和消费端）就会成为 Sentinel 中的资源，只需针对指定资源配置流控规则即可。
 *
 * 该包实现限流的核心原理是基于 Dubbo 的 SPI 机制实现 Filter 扩展，其 Filter 机制是专门为服务提供方和消费方调用过程中进行拦截
 * 设计的，每次执行远程方法，该拦截都会执行。
 * 同时，该包还可以自定义开启或关闭某个过滤器的功能。以下 consumerConfig() 方法就表示关闭消费端的过滤器。
 *
 */
@Configuration
public class SentinelConf {

    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setFilter("-sentinel.dubbo.filter");
        return consumerConfig;
    }
}
