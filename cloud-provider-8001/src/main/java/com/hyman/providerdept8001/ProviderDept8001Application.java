package com.hyman.providerdept8001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @EnableDiscoveryClient 注解是通用性的服务发现，可以支持其他的服务发现组件。
 * exclude 取消数据源的自动创建
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.hyman.providerdept8001.dao")
@EnableDiscoveryClient
public class ProviderDept8001Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDept8001Application.class, args);
	}

}
