package com.hyman.cloudconfigbus3356;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消息总线:
 *
 * 如果Spring Cloud Bus在类路径中检测到自身，则通过添加 Spring Boot autconfiguration 来工作。要启用总线，需要导入 spring-cloud-starter-bus-amqp
 * 或 spring-cloud-starter-bus-kafka 依赖。 Spring Cloud 负责其余的工作。 确保代理（RabbitMQ或Kafka）可用并且已配置。 在本地
 * 主机上运行时，您无需执行任何操作。
 * 如果您是远程运行的，请使用 Spring Cloud Connectors 或 Spring Boot 约定定义代理凭据，即在 bootstrap.yml 中的配置。
 *
 * 在引入 amqp 依赖，并配置了 rabbitmq 配置时，就可以实现动态刷新了。直接访问 http://服务ip:port/bus/refresh 即可实现配置的动
 * 态刷新。当然这是半自动化的刷新（作用于依赖 Config Server 配置的所有客户端），还是需要手动请求。
 *
 *
 * 以下是设置为自动刷新：
 * 许多源代码存储库程序（例如Github，Gitlab，Gitea，Gitee，Gogs或Bitbucket）都通过 Webhook 来自动通知服务，存储库中发生的更改。
 * 所以可以通过他们的用户界面将 Webhook 配置为 URL 和刷新的一组事件。
 * 例如 Github使用 POST 到 Webhook，其JSON主体包含提交列表和设置为可推送的标头（X-Github-Event）。如果在 spring-cloud-config-monitor
 * 库上添加依赖项并在 Config Server 中激活Spring Cloud Bus，那么将启用/ monitor端点。
 *
 * 激活 Webhook 后，配置服务器将发送一个 RefreshRemoteApplicationEvent，该事件针对它认为可能已更改的应用程序。变化检测可以被策
 * 略化。但默认情况下，它会查找与应用程序名称匹配的文件中的更改（例如，foo.properties针对foo应用程序，而 application.properties
 * 是针对所有应用程序）。
 * 要覆盖该行为时，可以使用的策略是 PropertyPathNotificationExtractor，它接受请求标头和正文作为参数，并返回已更改文件路径的列表。
 *
 * 默认配置可以与Github，Gitlab，Gitea，Gitee，Gogs或Bitbucket一起使用。除了来自Github，Gitlab，Gitee或Bitbucket的JSON通知之外，
 * 还可以通过以 path = {application} 模式使用具有形式编码的主体参数的 POST 到 /monitor 来触发更改通知。这样做会向匹配{application}
 * 模式（可以包含通配符）的应用程序广播。
 *
 *
 * 总线当前支持向所有侦听节点或特定服务的所有节点发送消息（由Eureka定义）。/bus/* 或是HTTP端点。 当前有两个实现：
 * 第一个 /bus/env 发送键/值对以更新每个节点的 Spring Environment。
 * 第二个 /bus/refresh 重新加载每个应用程序的配置，作用就相当于在它们每个服务上都单独 ping 一次 /refresh 端点操作一样。
 *
 *
 * 滚动刷新（分批次刷新），即在某个服务刷新配置之后，在测试没问题之后，再刷新其他服务的配置：
 * HTTP 端点接受 destination 路径参数，例如 /bus-refresh/customers：9000，其中destination是服务ID（默认是 application-name:port）。
 * 如果该ID由总线上的一个实例拥有，它将处理该消息，而所有其他实例将忽略它。
 * 但如果当一个服务被部署到两台机器时，且服务名与端口号都一样的话，则意味着有两个实例节点，它们的 applicationContext ID（服务ID）
 * 是一样的。而当 config bus 在刷新时，会判断如果是自身则不刷新，这就会导致这两个节点都不会刷新。所以在真正的生产中，往往要配置一个
 * 唯一标识 spring.application.index，但是在最新版中，默认 service id 就是唯一的，不需要设置。
 *
 *
 * 注意，Spring Cloud Bus入门文章涵盖Rabbit和Kafka，因为它们是两个最常见的实现。但 Spring Cloud Stream 更加灵活，并且绑定程序可
 * 与 spring-cloud-bus 一起使用。
 *
 * 但是这种单客户端 bus 配置的方式有一种问题，就是它固定的指向了某个端的服务IP和端。即服务的配置更新需要通过向具体服务中的某个实例
 * 发送请求，再触发对整个服务集群的配置更新。虽然能实现功能，但是这样的结果是，我们指定的应用实例会不同千集群中的其他应用实例， 这样
 * 会增加集群内部的复杂度，不利于将来的运维工作。比如，需要对服务实例进行迁移（IP（或应用名称）或端口发生改变），那么我们不得不修改
 * Web Hook中的配置等，在调用刷新的时候就要相应的改变访问路径。并且在现实情况中，应用实例名称与端口可能会随时发生改变的。
 *
 * 所以要尽可能地让服务集群中的各个节点是对等的。解决方法就是：
 * 1，在 ConfigServer 中也引入 SpringCloud Bus，将配置服务端也加入到消息总线中来。
 * 2，/bus/refresh 请求不再发送到具体服务实例上，而是发送给 Config Server, 并通过 destination 参数来指定需要更新配置的服务或实例。
 * 通过上面的改动，我们的服务实例不需要再承担触发配置更新的职责。同时对于 Git 的触发等配置都只需要针对 ConfigServer 即可， 从而简化
 * 了集群上的一些维护工作。
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudConfigBus3356Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigBus3356Application.class, args);
	}

}
