package com.hyman.providerdept8002;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.hyman.providerdept8002.dao")
@EnableDiscoveryClient
public class ProviderDept8002Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDept8002Application.class, args);
	}

}
