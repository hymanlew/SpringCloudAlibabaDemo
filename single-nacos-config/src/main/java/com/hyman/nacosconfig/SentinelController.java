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


/**
 * 在分布式系统中可能会面临的问题：
 * 复杂分布式体系结构中的应用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免地失败。
 *
 * 服务雪崩：
 * 多个微服务之间调用的时候，假设服务 A 调用服务 B和 C，而 B和 C又调用其他的微服务，这就是所谓的‘扇出’。如果扇出的链路上某个微
 * 服务的调用响应时间过长或不可用，那么对 A 的调用就会占用越来越多的系统资源，进而引起系统崩溃，所谓的‘雪崩效应’。
 * 对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源在几秒内饱和。比失败更糟糕的是，这些应用程序还可能导致服
 * 务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，
 * 以便单个依赖的失败而影响到整个系统。
 *
 * 解决方案有两种：
 * 1，超时机制，通过网络请求其他服务时，都必须设置超时。正常情况下，一个远程调用对应一个线程/进程，去请求时一般在几十毫秒内就返
 * 回了。当依赖的服务不可用，或因为网络问题，响应时间变得很长或几十秒时，这个线程/进程就会得不到释放。而线程进程则对应了系统资源，
 * 如果大量的线程得不到释放，则服务资源就会被耗尽，从而导致服务不可用。所以必须为每个请求设置超时。以防止资源的耗竭。
 *
 * 2，断路器，这才是彻底的解决方案。它就如同家里的电闸，当依赖的服务有大量超时时，再让新的请求去访问已经没有太大的意义，只会无谓
 * 的消耗现有资源。如果我们设置了超时时间为 1 秒，短时间内如果有大量请求在 1 秒内得不到响应，则就往往意味着异常。此时就没有必要
 * 让更新的请求去访问了，此时就应该用断路器避免资源的浪费。
 *
 * 断路器可以实现快速失败，如果它在一段时间内侦测到许多类似的错误（如超时），则就会强迫其之后的多个调用快速失败，不再请求所依赖
 * 的服务。从而可以使应用程序继续执行而不用等待修正错误或继续浪费资源。断路器也可以使应用程序能够诊断错误是否已经修正，如果已修
 * 正，则应用程序会再次尝试调用操作。
 * 断路器模式就像是那些容易导致错误的操作的一种代理，它能够记录最近调用发生错误的次数，然后决定使用允许操作继续，或者立即返回错误。
 *
 *
 * 服务熔断：
 * 熔断机制是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个微服务不可用或响应时间太长时，会进行服务的降级，进而熔断该节
 * 点微服务的调用，快速返回‘错误’的响应信息，即返回一个符合预期的可处理的备选响应（fallback）。当检测到该节点微服务调用响应正常
 * 后再恢复其调用链路。在 springCloud 框架中熔断机制是通过 Hystrix 实现，它会监控微服务间调用的状况，当失败的调用到达一定阈值
 * 后（默认是 5 秒内 20 次调用失败），就会启动熔断机制（熔断的注解是@HystrixCommand）。
 *
 * 服务降级：整体资源快不够了，忍痛将某些服务先关掉，待渡过难关，再开启回来。即资源抢占和分配的问题。服务降级处理是在客户端微服
 * 务中实现完成的，与提供者服务端没有关系。
 * 所谓降级，一般是从整体负荷考虑。就是当某个服务熔断之后，服务器将不再被调用，而是由客户端微服务直接准备一个本地的 fallback 回
 * 调，返回一个信息。这样做，虽然服务水平下降，但好歹可用，比直接挂掉要强。
 * 即当服务端 provider 已经 down 掉了，但是由于使用 hystrix fallback 做了服务降级处理，让客户端在服务端不可用时也能获得提示信
 * 息，而不会挂起耗死服务器。
 *
 * 有了熔断机制而后又有服务降级，是因为：熔断机制是直接作用在具体的方法了，而这就造成了强耦合。也违反了 IOC,AOP 面向切面的思想，
 * 所以就使用熔断加 fallbackFactory 接口的方式实现解耦合，达到了服务降级的目的。
 */
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
