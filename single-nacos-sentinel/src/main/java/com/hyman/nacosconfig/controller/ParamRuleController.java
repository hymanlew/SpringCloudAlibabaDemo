package com.hyman.nacosconfig.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import com.hyman.nacosconfig.handler.CustomBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sentinel 热点限流：
 *
 * 热点数据表示经常访问的数据，即频率非常高，所以要实施限流控制。比如针对一段时间内频繁访问的用户 IP 地址进行限流，或者针对频繁
 * 访问的某个用户 ID 进行限流。
 *
 * Sentinel 提供了热点参数限流的策略，它是一种特殊的限流，在普通限流的基础上对同一个受保护的资源区根据请求中的参数分别处理，该
 * 策略只对包含热点参数的资源调用有效。Sentinel 通过 LRU 策略结合滑动窗口机制来实现热点参数的统计，其中 LRU 策略可以统计单位时
 * 间内最常访问的热点数据，滑动窗口机制可以协助统计每个参数的 QPS。热点限流在以下场景中使用较多。
 *
 * 1，服务网关层：例如防止网络爬虫和恶意攻击，常用方法是限制爬虫的  IP 地址，客户端 IP 地址就是一种热点参数。
 * 2，写数据的服务：有写操作的业务系统，存储系统等等。存储系统的底层会加锁写磁盘上的文件，部分存储系统会将某一类数据写入同一个文
 * 件。如果底层写同一个文件，会出现抢占锁的情况，导致出现大量超时和失败。此时一般有两种解决办法：修改存储设计，对热点数据参数限流。
 *
 * Sentinel 默认是采用的懒加载机制，即当 Sentinel jar 包和本服务第一次启动后，在 Sentinel dashboard 中会看不到任何东西，只有访
 * 问之后才会显示。
 *
 */
@Slf4j
@RestController
public class ParamRuleController {

    private String resourceName = "sayhello";

    @GetMapping("/hello")
    public String sayhello(@PathParam("id") String id, @PathParam("name") String name){

        Entry entry = null;
        try {
            /**
             * 针对不同的热点参数，通过以下方法进行设置。
             * 其最后一个参数是一个数组，在有多个热点参数时，就按照次序依次传入，该配置表示后续会针对该参数进行热点限流。
             */
            entry = SphU.entry(resourceName, EntryType.IN, 1, id);
            return "access success";

        }catch (Exception e){
            e.printStackTrace();
            return "block";

        }finally {
            if(entry != null){
                entry.exit();
            }
        }
    }

    @PostConstruct
    public void initParamRule(){
        ParamFlowRule rule = new ParamFlowRule(resourceName);

        // 统计窗口时间长度，单位为秒
        rule.setDurationInSec(10);

        // 最长排队等待时长，只有当流控行为 controlBehavior 设置为匀速排队模式时生效
        rule.setMaxQueueingTimeMs(1);

        // 热点参数的索引，是必填项，它对应的是 SphU.entry 中的参数索引的位置
        rule.setParamIdx(0);

        // 针对指定参数值单独设置限流阈值，不受 count 参数的限制
        List<ParamFlowItem> paramFlowItemList = new ArrayList<>();
        rule.setParamFlowItemList(paramFlowItemList);

        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        ParamFlowRuleManager.loadRules(Collections.singletonList(rule));
    }


    /**
     * 如果是通过 @SentinelResource 注解定义资源的，当注解所配置的方法上有参数时，Sentinel 会把这些参数传入 SphU.entry。
     * 并会把参数作为热点参数进行限流。
     * 当用户访问该接口时，默认就会触发热点限流规则的验证。
     */
    @SentinelResource(value = "hello", blockHandler = "myBlockHandler")
    @GetMapping("/hello")
    public String sayhello(@PathParam("id") String id){
        return "access success";
    }

    public Object myBlockHandler(String id, BlockException e){
        System.out.println("处理被流控（限流）的逻辑");
        return null;
    }

    /**
     * 注意，@SentinelResource 注解只能用于 public 方法，不能用于 private 方法，注解包含以下属性：
     * - value：资源名称，必需项（不能为空）
     * - entryType：entry 类型，可选项（默认为 EntryType.OUT）
     *
     * - blockHandler：对应处理 BlockException 的函数名称，是可选项。此函数访问范围需要是 public，返回类型需要与原方法相匹配，
     *      参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。此函数默认需要和原方法在同一个类中。
     * - blockHandlerClass：若希望使用其他类的异常处理函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，注意对应的
     *      函数必需为 static 函数，否则无法解析。
     *
     * - fallback：回调函数名称，是可选项，用于在抛出异常的时候提供 fallback 处理逻辑。fallback 函数可以针对所有类型的异常（除了
     *      exceptionsToIgnore 里面排除掉的异常类型）进行处理。fallback 函数签名和位置要求：
     *
     *      - 返回值类型必须与原函数返回值类型一致；
     *      - 方法参数列表需要和原函数一致，或者可以额外多一个 Throwable 类型的参数用于接收对应的异常。
     *      - fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 fallbackClass 为对应的类的 Class 对
     *          象，注意对应的函数必需为 static 函数，否则无法解析。
     *
     * - defaultFallback（since 1.6.0）：默认的 fallback 函数名称，可选项，通常用于通用的 fallback 逻辑（即可以用于很多服务或方
     *      法）。默认 fallback 函数可以针对所以类型的异常（除了 exceptionsToIgnore 里面排除掉的异常类型）进行处理。若同时配置了
     *      fallback 和  defaultFallback，则只有 fallback 会生效。defaultFallback 函数签名要求：
     *
     *      - 返回值类型必须与原函数返回值类型一致；
     *      - 方法参数列表需要为空，或者可以额外多一个 `Throwable` 类型的参数用于接收对应的异常。
     *      - defaultFallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 fallbackClass 为对应的类的 Class
     *          对象，注意对应的函数必需为 static 函数，否则无法解析。
     *
     * - exceptionsToIgnore（since 1.6.0）：用于指定哪些异常被排除掉，不会计入异常统计中，也不会进入 fallback 逻辑中，而是会原样抛出。
     *
     * 注：1.6.0 之前 fallback 函数只针对降级异常（DegradeException）进行处理，不能针对业务异常进行处理。1.6 之后就可以。
     *
     * blockHandler 负责作用于限流熔断拦截，而 fallback 负责作用于程序抛出异常的回调。
     * 并且若 blockHandler 和 fallback 都进行了配置，并且操作都已经触发了这两个配置项，则被限流降级而抛出 BlockException 时只会进入
     * blockHandler 处理逻辑。若未配置 blockHandler、fallback 和 defaultFallback，则被限流降级时会将 BlockException 直接抛出。
     */
    @GetMapping("/hello/global")
    //@SentinelResource(value = "hello/global")
    //@SentinelResource(value = "hello/global", blockHandler = "myBlockHandler")
    //@SentinelResource(value = "hello/global", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handlerException")
    //@SentinelResource(value = "hello/global", fallback = "handlerFallback")
    //@SentinelResource(value = "hello/global", fallback = "handlerFallback", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handlerException")
    @SentinelResource(value = "hello/global", fallback = "handlerFallback", blockHandler = "myBlockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public String sayhelloGlobal(@PathParam("id") String id){

        if(StringUtils.isBlank(id)){
            throw new RuntimeException("数据为空！");
        }
        if("100".equals(id)){
            throw new IllegalArgumentException("参数异常！");
        }
        return "access success";
    }


    public String handlerFallback(String id, Throwable throwable) {
        log.error("handlerFallback 处理异常 --- " + throwable.getMessage());
        return "";
    }
}
