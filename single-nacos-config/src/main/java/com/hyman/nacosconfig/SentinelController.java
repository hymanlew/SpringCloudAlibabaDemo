package com.hyman.nacosconfig;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
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
     * 针对资源 sentinelDemo，通过 initFlowRules 设置限流规则，其中参数如下：
     * Grade，限流阈值类型，QPS 模式（1）或并发线程数模式（0）。
     * Count，限流阈值。
     * Resource，设置需要保护的资源，该资源名称必须和 SphU.entry 中使用的名称保持一致。
     *
     * 以下方法的规则是，针对 sentinelDemo 资源对应的方法，每秒最多允许通过 20 个请求，即 QPS 为 20.
     */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource("sentinelDemo");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);

        FlowRuleManager.loadRules(rules);
    }
}
