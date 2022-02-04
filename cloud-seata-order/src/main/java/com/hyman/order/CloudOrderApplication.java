package com.hyman.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * exclude 取消数据源的自动创建
 */
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.hyman.order.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudOrderApplication.class, args);
	}

}
