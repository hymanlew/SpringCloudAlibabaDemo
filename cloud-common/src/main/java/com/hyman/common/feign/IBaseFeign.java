package com.hyman.common.feign;

import com.hyman.common.fallback.IBaseFeignFallback;
import com.hyman.common.model.dto.base.SysCode;
import com.hyman.common.model.form.order.DictDataListFORM;
import com.hyman.common.model.vo.base.DictDataVO;
import com.hyman.common.msg.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;

/**
 * 增加 Feign 面向接口的负载均衡配置.
 * 并且注解指定的名称是在 spring 中配置的提供者微服务的名字，而不是在 eureka 中自定义的名字。
 *
 * Feign 已经集成了hystrix服务，所以直接声明 fallback 返回操作即可。
 *
 * 其中心概念就是命名客户端，每个 feignclient 都是整体的一部分，它们一起工作以按需联系远程服务器，并且该整体具有一个名称（即
 * feignclient 指定的名称）。SpringCloud 会按 name 及 Configuration 属性创建不同的 ApplicationContext，通过不同的 Context
 * 来隔离 FeignClient 的配置信息，在使用配置类时，不能把配置类放到 ComponentScan 的路径下，否则配置类会对所有FeignClient生效。
 *
 * configuration: Feign配置类，也包含自定义的 feign 的 Encoder，Decoder，LogLevel 和 Contract。
 * fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑。并且指定的类必须实现 @FeignClient 标记的接口。
 * fallbackFactory: 工厂类，用于生成fallback类示例，通过这个属性可以实现每个接口通用的容错逻辑，减少重复的代码。
 * path: 定义当前FeignClient的统一前缀。
 *
 * 另外要注意，在 Feign中实现回退以及 Hystrix回退的工作方式是有限制的。返回 com.netflix.hystrix.HystrixCommand 和 rx.observate
 * 的方法目前不支持回退。
 */
@FeignClient(value = "microservice-provider-base", fallbackFactory = IBaseFeignFallback.class, primary = false)
public interface IBaseFeign {

    @RequestMapping(value = "base/dict/qryDict", method = RequestMethod.GET)
    Result<List<SysCode>> qryDict();

    /**
     * 根据 type 类型获取字典数据
     */
    @RequestMapping(value = "/v1/base/dict/back/dictData/list", method = RequestMethod.POST)
    Result<List<DictDataVO>> getDictByType(@RequestBody DictDataListFORM dictDataListFORM);

    @GetMapping("/user/area/getAreaNameByCityCode/{cityCodes}")
    Result<HashMap<String, String>> getAreaNameByCityCode(@PathVariable("cityCodes") int[] cityCodes);

    @RequestMapping(value = "user/bss/getSyncUserInfoToRedis", method = RequestMethod.GET)
    void getSyncUserInfoToRedis();

    @GetMapping("base/dict/getCityCode")
    Result<String> getCityCode(@RequestParam("cityName") @NotBlank String cityName);

}