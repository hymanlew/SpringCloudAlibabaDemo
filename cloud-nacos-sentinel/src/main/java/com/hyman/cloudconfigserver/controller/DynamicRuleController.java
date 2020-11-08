package com.hyman.cloudconfigserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * dashboard 动态修改的规则都是保存在内存中的，一旦应用重启，则这些规则都会被清除。因此 sentinel 提供了动态数据源支持。
 * 本示例就是 sentinel 集成 nacos 实现动态流控规则（在 application-bus.yml 中配置）。
 * 当在 xml 配置成功之后，接口流控规则的动态修改就存在于两个地方：sentinel dashboard 和 nacos 控制台。
 *
 * 在 nacos 控制台上修改流控规则，虽可以同步到 sentinel dashboard，但 nacos 此时应作为一个流控规则的持久化平台，正常的操作是能够
 * 将 dashboard 的规则修改同步到 nacos，但是目前是不支持的。
 * 即 nacos 还是一个配置中心的角色，所以还是强烈建议不要在 nacos 上做动态的流控规则修改。
 *
 * 还有一种方式是在 Dubbo 服务中，实现动态流控规则的修改，并持久化到 Nacos 中。参见
 * @see com.hyman.cloudconfigserver.config.NacosDataSourceInitFunc
 */
@RestController
public class DynamicRuleController {

    @GetMapping("/rule")
    public String rule(){
        return "rule";
    }
}
