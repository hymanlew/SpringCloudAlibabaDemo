package com.hyman.nacosconfig;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class SentinelController {

    /**
     * 运行之后，可在 ${USER_HOME}/logs/csp/${包名-类名}-metrics.log.date 文件中查看日志，格式为：
     *
     * timestamp|yyyy-MM-dd HH:mm:ss|resource|passQps（通过的请求）|blockQps（被阻止的请求）|successQps（成功执行完成的请求数）|
     * exceptionQps（自定义异常）|rt（平均响应时长）|occupiedPassQps（优先通过的请求）|concurrency（并发量）|
     * classification（资源类型）
     */
    public static void main(String[] args) {

        initFlowRules();
        while (true){
            someThing();
        }
    }

    /**
     * Sentinel 资源保护规则支持：流量控制，熔断降级，系统保护，来源访问控制，热点参数规则等等.
     *
     * 以下方法的规则是，针对 sentinelDemo 资源对应的方法，每秒最多允许通过 20 个请求，即 QPS 为 20.
     */
    private static void initFlowRules(){
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

    private static void someThing(){

        /**
         * 1，第一种方式：定义一个资源来实现流控的逻辑，它表示当请求进入该方法时，需要进行限流判断。
         *    资源名称可以是方法名称，接口名称或其他的唯一标识。
         */
        try (Entry entry = SphU.entry("sentinelDemo")) {

            System.out.println("定义被保护的业务处理逻辑");

        // 如果抛出此异常，则表示触发了限流操作
        } catch (BlockException e){

            System.out.println("处理被流控（限流）的逻辑");
        }

        /**
         * 2，第二种方式：通过返回布尔值来定义一个资源。
         *    资源名称可以是方法名称，接口名称或其他的唯一标识。
         */
        if(SphO.entry("sentinelDemo")){
            try {

                System.out.println("定义被保护的业务处理逻辑");
            }finally {
                // 在资源使用完之后一定要调用该方法，否则会导致调用链记录异常，抛出 ErrorEntry 异常。
                SphO.exit();
            }
        }else {
            System.out.println("处理被流控（限流）的逻辑");
        }
    }

    /**
     * 3，第三种方式：通过注解来定义一个资源。
     *    资源名称可以是方法名称，接口名称或其他的唯一标识。
     */
    @SentinelResource(value = "sentinelDemo", blockHandler = "myBlockHandler")
    public Object getById(String id){
        System.out.println("定义被保护的业务处理逻辑");
        return null;
    }

    public Object myBlockHandler(String id, BlockException e){
        System.out.println("处理被流控（限流）的逻辑");
        return null;
    }


    /**
     * Sentinel 实现服务熔断的配置与限流类似，区别在于限流使用的是 FlowRule，而熔断使用的是 DegradeRule.
     */
    private static void initDegradeRules(){
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();

        // 设置需要熔断的资源，该资源名称必须和 SphU.entry 中使用的名称保持一致
        rule.setResource("sentinelDemo");

        // 限流阈值
        rule.setCount(20);

        /**
         * 熔断策略，支持秒级 RT（默认），秒级异常比例，分钟级异常数
         *
         * DEGRADE_GRADE_RT（平均响应时间）：如果 1s 内持续进入 5 个请求，对应的平均响应时间都超过了阈值（count，单位为 ms），则在
         * 接下来的时间窗口（TimeWindow，单位为秒）内，对这个方法的调用都会自动熔断，抛出异常。
         * Sentinel 默认统计的 RT 上限是 4900ms，如果超出此值都会算作 4900ms，如果需要修改，可通过启动参数 -Dcsp.sentinel.statistic.max.rt=xxx 来配置。
         *
         * DEGRADE_GRADE_EXCEPTION_RATIO（秒级异常比例）：如果每秒资源请求数 >= MinRequestAmount，且每秒的异常总数占总通过量的比例
         * 超过阈值 count（取值范围为 0.0-1.0，即 0%-100%），则资源将进入降级状态。同样在接下来的时间窗口（TimeWindow，单位为秒）内，
         * 对这个方法的调用都会自动熔断，抛出异常。
         *
         * DEGRADE_GRADE_EXCEPTION_COUNT（分钟级异常数）：当每分钟资源请求异常数超过阈值后，会触发熔断。但要注意，如果时间窗口小于
         * 60s，则结束熔断状态后仍然可能会再次进入熔断状态。
         */
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);

        // 熔断降级的时间窗口，单位为秒，即触发熔断降级后多长时间内调用该方法都会自动熔断
        rule.setTimeWindow(10);

        // 触发异常熔断的最小请求数，请求数小于该值时，即使异常比例超出阈值也不会触发熔断。默认是 5
        rule.setMinRequestAmount(5);

        // 在 RT 模式下，1s内持续的平均请求数超出 RT 阈值后，触发熔断。默认是 5
        rule.setRtSlowRequestAmount(5);

        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }
}
