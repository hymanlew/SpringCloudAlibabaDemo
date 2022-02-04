package com.hyman.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "microservice-provider-8001")
public interface ProviderFeign {
}
