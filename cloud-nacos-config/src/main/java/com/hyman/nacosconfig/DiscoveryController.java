package com.hyman.nacosconfig;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单机服务配置：
 * 注册服务时，使用 ip:port（在配置文件中配置）/nacos/v1/ns/instance?serviceName=abc&ip=127.0.0.1&port=7001,
 * 获取服务地址时，则就可以使用以下的路径进行访问。
 */
@RestController
@RequestMapping("/nacos")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    /**
     * 根据服务名称，获得注册到 nacos 上的服务地址
     */
    @GetMapping("/discovery")
    public List<Instance> discovery(@RequestParam String serviceName) throws NacosException {
      return namingService.getAllInstances(serviceName);
    }

}
