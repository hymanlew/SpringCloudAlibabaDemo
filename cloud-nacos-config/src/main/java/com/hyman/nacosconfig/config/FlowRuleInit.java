package com.hyman.nacosconfig.config;

import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 一，手动配置流控规则，可借助 sentinel InitFunc SPI 扩展接口实现：
 * 1，需要实现自己的 InitFunc 接口，并在 init 方法中编写规则加载即可。
 * 2，在 resource 目录下创建 META-INF/services/com.alibaba.csp.sentinel.init.InitFunc 文件，文件内容为自定义扩展点的全路径。
 *
 * 如此，在初次访问任意资源时，sentinel 就会自动加载 hello 资源的流控规则。
 *
 * 二，另一种是基于 sentinel dashboard 实现流控
 * @see com.hyman.nacosconfig.controller.DashboardController
 *
 * 以上两者是可以兼容存在的，以 dashboard 动态修改规则为优先规则。
 * 但要注意，dashboard 动态修改的规则都是保存在内存中的，一旦应用重启，则这些规则都会被清除。因此 sentinel 提供了动态数据源支持。
 * 目前 sentinel 支持 Consul，zookeeper，redis，nacos，apollo，etcd 等数据源的扩展。参照 cloud-nacos-sentinel 项目。
 *
 * 并且在 spring-cloud-sentinel 中，流控规则的持久化机制是自动实现的，不需要手动配置。
 */
public class FlowRuleInit implements InitFunc {

    @Override
    public void init() throws Exception {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();

        /**
         * 针对资源 sentinelDemo，通过 initFlowRules 设置限流规则，其中参数如下：
         */

        /**
         * 限制来源（限流）：
         * 默认是 default，即不区分调用来源。
         * 指定特定的调用者（hyman）。
         * 除了特定调用者之外的其他调用者都进行流量控制（other）。
         *
         * 由于同一个资源可配置多条规则，如果多个规则设置的 LimitApp 不一样，则生效顺序为：hyman -> other -> default。
         */
        rule.setLimitApp("default");
        rule.setLimitApp("hyman");
        rule.setLimitApp("other");

        /**
         * 调用关系包括调用方和被调用方，一个方法又可能会调用其他方法，形成一个调用链。而调用关系限制策略，就是根据不同的调用维度来
         * 触发流量控制。具体维度可分为：
         *
         * 根据调用方限流（直接限流），即根据请求资源进行限制，即 LimitApp 属性。
         * 根据调用链路入口限流（链路），一个被限流保护的方法，可能来自不同的调用链路。则 Sentinel 只允许根据某个入口来进行流量统计。
         * 具有关系的资源流量控制（关联流量控制），当两个资源之间存在依赖关系或资源争抢时，则这两个资源就存在关联。而它们在执行时可
         * 能会因为某个资源执行操作过于频繁而影响另一个资源的执行效率。所以关联流量控制，就是限制其中一个资源的执行流量。
         */
        rule.setStrategy(RuleConstant.STRATEGY_CHAIN);

        /**
         * 流控行为策略，包括，直接拒绝（默认），排队等待，慢启动模式
         *
         * 直接拒绝，就是请求流量超出阈值时，直接抛出异常。
         *
         * warm_up，是一种冷启动（预热）方式。当流量突然增大时，有可能瞬间将系统压垮。此时就希望请求处理的数量逐步递增，并在一个预
         * 期时间之后才达到允许处理请求的最大值，warm_up 就是为了达到这个目的。
         *
         * 匀速排队，此方式会严格控制请求通过的间隔时间，也就是让请求以均匀的速度通过，其实也就相当于漏桶限流算法。其好处是可以处理
         * 间隔性突发流量。
         */
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP_RATE_LIMITER);

        // 是否是集群模式，默认为否
        rule.setClusterMode(false);

        // 设置需要保护的资源，该资源名称必须和 SphU.entry 中使用的名称保持一致
        rule.setResource("sentinelDemo");

        /**
         * 限流阈值类型，QPS 模式（1）或并发线程数模式（0）
         *
         * FLOW_GRADE_THREAD 并发线程数限流，是用来保护业务线程不被耗尽。比如 A 服务调用 B 服务，而 B 因为某种原因导致服务不稳定
         * 或响应延迟，那么对于 A 来说，其吞吐量就会下降，也就意味着占用更多的线程（线程阻塞后一直未释放），极端情况下会造成线程
         * 池耗尽。
         * 针对此类问题，一个常见的解决方案是通过不同的业务逻辑使用不同的线程池来隔离业务自身的资源争抢问题，但这个方案同样会造成
         * 线程数量过多带来的上下文切换问题。
         * Sentinel 并发线程数限流，就是统计当前请求的上下文线程数量，如果超出阈值，请的请求就会被拒绝。
         *
         * FLOW_GRADE_QPS，表示每秒的查询数，即一台服务器每秒能响应的查询次数，当 QPS 达到限流的阈值时，就会触发限流策略行为（ControlBehavior）。
         */
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setGrade(RuleConstant.FLOW_GRADE_THREAD);

        // 限流阈值
        rule.setCount(20);

        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
