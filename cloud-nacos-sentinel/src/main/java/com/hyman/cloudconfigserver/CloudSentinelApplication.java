package com.hyman.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableCircuitBreaker    // 开启对熔断机制功能的支持
@SpringBootApplication
public class CloudSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSentinelApplication.class, args);
	}

}
