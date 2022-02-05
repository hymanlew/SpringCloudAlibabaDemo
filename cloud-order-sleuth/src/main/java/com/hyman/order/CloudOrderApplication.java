package com.hyman.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 由于 SpringCloud alibaba 技术栈中并没有提供自己的链路追踪技术，所以可采用 Sleuth+Zinkin 或 skywalking 来做链路追踪解决方案。
 * 并且 Sleuth 兼容支持了 Zinkin。
 * - 下载地址：https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server，直接点击版本号即可下载。
 * - 控制台地址：http://localhost:9411/zipkin。
 */
@SpringBootApplication
public class CloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudOrderApplication.class, args);
	}

}
