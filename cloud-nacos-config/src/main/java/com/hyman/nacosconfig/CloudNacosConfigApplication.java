package com.hyman.nacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Nacos 架构图：
 * provider app，服务提供者。
 * consumer app，服务消费者。
 * name server，通过 VIP（Vritual IP）或者 DNS 的方式实现 nacos 高可用集群的服务路由。
 * nacos console，nacos 控制台。
 *
 * nacos server，nacos 服务提供者，其包含的 OpenAPI 是功能访问入口，config service（配置服务），naming service（名字服务）是
 * nacos 提供的服务模块。consistency protocol 是一致性协议，用来实现 nacos 集群节点的数据同步，使用的是 Raft 算法。
 *
 * 整体来看，服务提供者通过 VIP 访问 nacos server 高可用集群，基于 OpenAPI 完成服务的注册和查询。nacos server 本身可支持主备
 * 模式，所以底层会采用数据一致性算法来完成从节点的数据同步。服务消费者也是如此，基于 OpenAPI 从 nacos server 中查询服务列表。
 *
 * Nacos 注册中心功能原理：
 * 服务实例在启动时注册到服务注册表，并在关闭时注销。服务消费者查询服务注册表，获得可用实例。服务注册中心需要调用服务实例的健康
 * 检查 API 来验证它是否能够正常处理请求。并且当 nacos server 检测到 provider 异常时，会基于 UDP 协议推送服务更新信息（json）
 * 到 consumer。使用 UDP 协议是因为服务端不关注返回结果，允许客户端没收到信息。
 *
 * Spring Cloud 将其规范化的定义都抽象到了 SpringCloud-Common 包中，即是统一的标准化流程（定义了接口），如服务注册流程，发现流
 * 程。其实现及自动装配信息，都包含在了 SpringCloud-Common 包下 META-INF/spring.factories 文件中。而 dubbo 集成 nacos 时，服
 * 务注册依托的是 Dubbo 中的自动装配机制。是在 spring-cloud-alibaba-dubbo 下 META-INF/spring.factories 文件中。所以不需要单
 * 独创建配置一个 Nacos 模块项目。
 *
 * Nacos 服务监听有两种方式：
 * 1，客户端调用 /nacos/v1/ns/instance/list 定时轮询。
 * 2，基于 DatagramSocket 的 UDP 协议，实现服务端的主动推送。
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudNacosConfigApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(CloudNacosConfigApplication.class, args);

		// 从 Environment 中读取配置，并模拟动态更新
		while (true){
			String info = context.getEnvironment().getProperty("info");
			System.out.println(info);
			Thread.sleep(2000);
		}
	}

}
