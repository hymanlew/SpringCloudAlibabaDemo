package com.hyman.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 要特别注意：自定义的 Ribbon 负载配置算法类不能放在 @ComponentScan 扫描的当前包及其子包下（即主启动类所在的包及其子包）。否
 * 则此自定义配置类就会被所有的 Ribbon 客户端所共享，也就是说这就达不到特殊化定制的目的了。这是第一种作法。
 *
 * 第二种作法是，如果自定义配置确实要放入到启动类所在的包中，则需要另外自定义一个注解作为 excludeScan 的作用。然后在本类中加个
 * 这个注解，并在启动类上加上 @ComponentScan(excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION, value=
 * 自定义的注解类)}) 即可。
 */
@Configuration
public class MyRule {

    // 显示声明一个自定义的负载算法，它将会替换掉原有系统中的负载算法（需要重新启动所有的服务）。
    @Bean
    public IRule myRule(){
        return new MyConfigRule();
    }


    @Bean
    public ZonePreferenceServerListFilter serverListFilter() {
        ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
        filter.setZone("");
        return filter;
    }
}
