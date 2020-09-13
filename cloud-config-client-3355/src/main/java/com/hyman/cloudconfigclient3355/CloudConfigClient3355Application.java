package com.hyman.cloudconfigclient3355;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudConfigClient3355Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClient3355Application.class, args);
	}

}
