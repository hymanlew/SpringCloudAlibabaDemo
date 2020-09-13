package com.hyman.cloudconfigservereureka3345;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudConfigEureka3345Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigEureka3345Application.class, args);
	}

}
