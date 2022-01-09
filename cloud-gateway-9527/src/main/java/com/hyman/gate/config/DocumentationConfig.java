package com.hyman.gate.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2019年03月05日14:05:53
 * @Description:
 */
@Component
@Primary
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
@SuppressWarnings("unchecked")
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList();
        resources.add(swaggerResource("认证域", "/api/auth/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("线路域", "/api/line/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("基础域", "/api/base/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("订单域", "/api/order/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("产品域", "/api/product/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("bss聚合域", "/api/bss/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("match域", "/api/match/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("elasticsearch-canal域", "/api/es/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("es-canal-match域", "/api/match_es/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("MQ域", "/api/mq/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("司机域", "/api/driver/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("数仓域", "/api/datacenter/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("核心域", "/api/core/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("代理域", "/api/proxy/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("修复域", "/api/repair/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("账单域", "/api/bill/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("实时派单域", "/api/union/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("运单域（运费管理）", "/api/waybill/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("微信（企业微信）域", "/api/wechat/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("运力域", "/api/carrier/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("标签域", "/api/label/v2/api-docs?group=hyman", "1.0"));

        resources.add(swaggerResource("系统管理", "/api/base_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("货源中心", "/api/line_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("运力中心", "/api/carrier_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("交易中心", "/api/business_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("运单中心", "/api/waybill_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("计费中心", "/api/bill_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("撮合中心", "/api/match_center/v2/api-docs?group=hyman", "1.0"));
        resources.add(swaggerResource("赋能打分", "/api/score/v2/api-docs?group=hyman", "1.0"));

        //雷鸟
        resources.add(swaggerResource("雷鸟-车池域", "/api/car/v2/api-docs?group=leiniao", "1.0"));
        resources.add(swaggerResource("雷鸟-es域", "/api/ln_es/v2/api-docs?group=leiniao", "1.0"));
        resources.add(swaggerResource("雷鸟-车池中心", "/api/car_center/v2/api-docs?group=leiniao", "1.0"));
        resources.add(swaggerResource("雷鸟-看车中心", "/api/intention_center/v2/api-docs?group=leiniao", "1.0"));
        resources.add(swaggerResource("雷鸟-看车单域", "/api/intention/v2/api-docs?group=leiniao", "1.0"));

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
