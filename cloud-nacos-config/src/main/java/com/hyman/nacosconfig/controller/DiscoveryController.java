package com.hyman.nacosconfig.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 单机服务配置（Nacos 服务是单独从官网下载解压并运行的）：
 * 注册服务时，使用 ip:port（在配置文件中配置）/nacos/v1/ns/instance?serviceName=abc&ip=127.0.0.1&port=7001,
 * 获取服务地址时，则就可以使用以下的路径进行访问。
 */
@RestController
@RequestMapping("/nacos")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 根据服务名称，获得注册到 nacos 上的服务地址
     */
    @GetMapping("/discovery")
    public List<Instance> discovery(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    /**
     * 根据服务名称，获得注册到 nacos 上的服务地址
     */
    @GetMapping("/getDiscovery")
    public Object getDiscovery(@RequestParam String serviceName) throws NacosException {

        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if(null == instances || instances.isEmpty()){
            return "用户微服务没有对应的实例可用";
        }

        String targetUri = instances.get(0).getUri().toString();
        Object target = "调用 feign 请求远程接口";
        if(null == target){
            return "没有对应的数据";
        }
        return target;
    }
}

