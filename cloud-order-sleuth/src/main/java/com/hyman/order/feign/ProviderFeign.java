package com.hyman.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-provider-sleuth")
public interface ProviderFeign {

    @GetMapping("/dept//getById/{id}")
    public Object findById(@PathVariable("id") Integer id);
}
