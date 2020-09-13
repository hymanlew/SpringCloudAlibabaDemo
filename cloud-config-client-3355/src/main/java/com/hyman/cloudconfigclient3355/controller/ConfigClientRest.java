package com.hyman.cloudconfigclient3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope 注解可以实现动态加载配置信息（需要依赖 actuator 包）。
 * 在服务启动后，当配置信息发生变动时，直接访问 http://服务ip:port/refresh 即可实现配置的动态刷新。
 *
 * 例如，当更改数据库URL配置时，如果数据源有打开的连接，您可能希望这些连接能够继续完成正在做的工作。然后在下次从池中借用连接时，
 * 它会得到一个带有新 URL 的连接。
 * 有时，在某些 bean 上应用 @RefreshScope 注解可能是强制性的，这些bean只能初始化一次。如果一个bean是“不可变的”，则必须使用 @RefreshScope
 * 注解该 bean，或者在属性键 spring.cloud.refresh.extra-refreshable 下指定类名。
 *
 * 如果您自己创建一个数据源bean，并且实现是一个HikariDataSource，那么返回最特定的类型，在本例中是HikariDataSource。否则，需要
 * 设置 spring.cloud.refresh.extra refreshable=javax.sql.DataSource。
 *
 *
 * RefreshScope 是上下文中的一个bean，它有一个public refreshAll() 方法，通过清除目标缓存来刷新作用域中的所有bean。/refresh 端
 * 点公开此功能（通过HTTP或JMX）。如果需要按名称刷新单个bean，还有一个refresh（String）方法。
 *
 * 对于Spring Boot Actuator应用程序（依赖 actuator 包），可以使用一些其他管理端点，如下：
 * 1，POST 到 /actuator/env 以更新环境并重新绑定 @ConfigurationProperties 和日志级别。
 * 2，/actuator/refresh 重新加载引导上下文并刷新 @RefreshScope bean。
 * 3，/actuator/restart 关闭 ApplicationContext 并重新启动它（默认情况下禁用）。
 * 4，/actuator/pause 和 /actuator/resume 调用生命周期方法（ApplicationContext上的 stop() 和 start()）。
 * 5，如果禁用 /actuator/restart 端点，则 /actuator/pause 和 /actuator/resume 端点也将被禁用，因为它们只是 /actuator/restart 的特例。
 *
 * 要公开/refresh端点，需要向应用程序添加以下配置：
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: refresh
 *
 *
 * 需要注意，尽量不要使 @RefreshScope 与 @Configuration 一起注解同一个类，否则可能导致令人惊讶的行为。
 */
@RestController
@RefreshScope
public class ConfigClientRest {

    // 这些配置数据都是从 bootsrtap.yml 指定的 github 上读取下来的 yml 文件中的配置
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String[] eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        return applicationName + "---" + String.join(",", eurekaServers) + "---" + port + "---";
    }
}
