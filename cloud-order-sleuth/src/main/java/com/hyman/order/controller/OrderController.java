package com.hyman.order.controller;

import com.hyman.order.feign.ProviderFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private ProviderFeign providerFeign;

    /**
     * 直接调用此接口，使其远程调用 provider 服务，形成调用链路。然后就可以在 sleuth 控制台（http://localhost:9411）中查看到调用链路。
     * @param id id
     */
    @GetMapping("/getById/{id}")
    public Object findById(@PathVariable("id") Integer id){
        return providerFeign.findById(id);
    }

}
