package com.hyman.providerdept8003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "com.hyman.providerdept8003.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderDept8003Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDept8003Application.class, args);
	}

}
