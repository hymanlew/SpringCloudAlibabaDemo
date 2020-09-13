package com.hyman.consumerhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 除了隔离依赖服务的调用以外，Hystrix 还提供了准实时的调用监控（Hystrix Dashboard），Hystrix会持续地记录所有通过 Hystrix 发
 * 起的请求的执行信息，并以统计报表和图形的形式展现给用户，包括每秒执行多少请求多少成功多少失败等。
 * Netflix 通过 Hystrix-metrics-event-stream 项目实现了对以上指标的监控。springcloud 也提供了对 Hystrix Dashboard 的整合，对
 * 监控内容转化成可视化界面。
 * localhost:9001/hystrix，或是 localhost:9001/hystrix.stream（单个 hystrix 服务监控）。
 *
 * Delay：该参数用于控制服务器上轮询监控信息的延迟时间，默认为 2000 毫秒，可以通过配置该属性来降低客户端的网络和 CPU 消耗。
 * Title：该参数对应了头部标题 Hystrix Stream 之后的内容，默认使用具体监控实例的 URL，可通过该配置来展示自定义标题。
 *
 * 并且要注意 HystrixDashboard 服务监控，在被监控的微服务中必须是引入了 actuator jar 包，才能被监控。本项目是单独部署的，启动
 * 后访问本项目路径（加 dashboard.path，如果有配置的话），就会出现监控页面。然后在页面中输入某个服务实例的 Hystrix 信息路径（
 * 如 localhost:8001/hystrix.stream），然后再输入上面两个参数对应的属性值，即可对某个服务实例实现监控。
 * 而且 Hystrix Dashboard 只适合监控单个实例，而在真实环境中服务都是集群部署的，监控单个实例意义不大。所以使用 Turbine 来整合
 * 多个服务进行监控。
 *
 *
 * Turbine 可以实现多服务监控数据的聚合，从而监控整个集群（是通过 eureka 定位所有的服务实例）。Turbine 默认是在 Eureka 中查找
 * 其主机名和端口项，然后将 /hystrix.stream 附加到已注册实例上，来查找 /hystrix.stream 端点。如果实例的元数据 metadata-map 包
 * 含 management.port，则需要使用它来代替 /hystrix.stream 端点的端口值。默认 management.port的元数据条目等于 management.port配置属性。
 *
 * 启动后访问，http://本项目路径或IP:port/turbine.stream?cluster=（clusterConfig 配置的值），就能看到监控到的服务的信息。但
 * 是此时的信息还只是 json 数据。如果需要显示成图表，还是要依靠 Hystrix Dashboard，指定项目数据的路径为访问 Turbine 时的路径即可。
 */
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class ConsumerHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHystrixDashboardApplication.class, args);
	}

}
