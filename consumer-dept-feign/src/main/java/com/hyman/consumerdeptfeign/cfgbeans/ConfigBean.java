package com.hyman.consumerdeptfeign.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 从 spring 到 boot：从 applicationContext.xml 到 configuration 注解配置。
@Configuration
public class ConfigBean {

    // 显示声明一个负载的算法，它将会替换掉默认的轮询算法（需要重新启动所有的服务）。
    @Bean
    public IRule changeRule(){
        return new RandomRule();
    }
}
