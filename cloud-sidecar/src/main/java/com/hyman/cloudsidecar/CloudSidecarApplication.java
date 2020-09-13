package com.hyman.cloudsidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Sidecar 可以使得 springcloud 接入非 java 语言编写的应用程序。
 * 需要注意，@EnableSidecar 注解是使用在与非 JVM 应用程序相同的主机上运行生成的应用程序。即要求是同一台服务器主机。
 * 如果是部署在其他的主机上，则需要配置 sidecar.hostname，ipAddress，port。
 * 一个 sidecar 服务对应一个非 java 应用程序。如果是多个非 java 程序节点，则需要配置多个 sidecar。
 *
 * 并且 springcloud 会将非 java 应用程序的可用状态（即 node 中的 status）引用到本 sidecar 服务中，即应用是可用 UP 则 sidecar
 * 服务也为 UP。反之则都为 DOWN。
 */
@SpringBootApplication
@EnableSidecar
public class CloudSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSidecarApplication.class, args);
	}

}
