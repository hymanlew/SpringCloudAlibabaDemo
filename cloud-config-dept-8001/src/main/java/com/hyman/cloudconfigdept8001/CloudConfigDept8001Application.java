package com.hyman.cloudconfigdept8001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "com.hyman.providerdept8001.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudConfigDept8001Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigDept8001Application.class, args);
	}

}
