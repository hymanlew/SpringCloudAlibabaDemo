package com.hyman.cloudconfigserver.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * 以下方式是在 Dubbo 服务中，实现动态流控规则的修改，并持久化到 Nacos 中。可借助 sentinel InitFunc SPI 扩展接口实现：
 * 1，需要实现自己的 InitFunc 接口，并在 init 方法中加载 nacos 中的动态规则即可。
 *
 * 2，本类如果要实现自动加载，需要在 resource 目录下创建 META-INF/services/com.alibaba.csp.sentinel.init.InitFunc 文件，文件
 * 内容为本自定义扩展点 NacosDataSourceInitFunc 的全路径。
 *
 * 3，之后访问 sentinel dashboard，在针对某个资源创建流控规则时，该规则会同步保存到 Nacos 配置中心。而当 Nacos 发生变化时，会触
 * 发事件机制通知 dubbo 应用重新加载流控规则。
 *
 * 另一种是 sentinel 集成 dashboard 实现动态流控规则，并持久化到 Nacos 中。可参见
 * @see com.hyman.cloudconfigserver.controller.DynamicRuleController
 */
public class NacosDataSourceInitFunc implements InitFunc {

    private String serveraddr = "192.168.216.128:8848";
    private String groupid = "DEFAULT_GROUP";
    private String dataid = "spring-cloud.sentinel-dubbo.provider-sentinel-flow";

    @Override
    public void init() throws Exception {

    }

    private void loadNacosData(){
        ReadableDataSource<String, List<FlowRule>> flowRuledata = new NacosDataSource<>(
                serveraddr, groupid, dataid, source ->
                    JSON.parseObject(source, new TypeReference<List<FlowRule>>(){})
        );

        FlowRuleManager.register2Property(flowRuledata.getProperty());
    }
}
