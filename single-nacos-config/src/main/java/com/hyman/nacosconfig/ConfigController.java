package com.hyman.nacosconfig;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NacosPropertySource 注解：用于加载 dataId 配置源，autoRefreshed 表示开启自动更新。
 * dataId 表示 Nacos 中某个配置集的 id，通常用于组织划分系统的配置集。
 *
 * NacosValue 注解：表示设置属性的值，其中冒号左表示为 key 值，冒号右表示为默认值。即如果 key 不存在，则使用默认值。这是一种高
 * 可用策略，在实际应用中，应尽可能考虑到在配置中心不可用的情况下如何保证服务的可用性。
 *
 * 有两种创建方式：
 * 一是在 nacos 控制台创建（配置管理--配置列表--创建）。
 * 一是使用 OpenAPI 创建（ip:port（在配置文件中配置）/nacos/v1/cs/configs?dataId=myconfig&group=DEFAULT_GROUP&content=info=hyman）。
 */
@NacosPropertySource(dataId = "myconfig", autoRefreshed = true)
@RestController
@RequestMapping("/nacos")
public class ConfigController {

    @NacosValue(value = "${info:hyman}", autoRefreshed = true)
    private String info;

    @GetMapping("/config")
    public String config() {
      return info;
    }

}
