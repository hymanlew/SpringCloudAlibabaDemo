package com.hyman.cloudconfigbus3356.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * 追踪消息总线：其目的是显示发送的每个事件（每次调用）以及每个服务实例的所有确认。
 * 传播自己的事件：总线可以携带 RemoteApplicationEvent 类型的任何事件。默认传输是 JSON，反序列化器需要提前知道将要使用哪些类型。
 * 要注册新类型，必须将其放入 org.springframework.cloud.bus.event 的子包中。自定义事件名称，可以在自定义类上使用 @JsonTypeName
 * 或依赖默认策略，即使用类的简单名称。
 * [注意] 生产者和消费者都需要访问类定义。
 *
 * 如果您不能或不想将 org.springframework.cloud.bus.event 的子包用于自定义事件，则必须使用 @RemoteApplicationEventScan 批注
 * 指定要扫描哪些包的 RemoteApplicationEvent 类型的事件。用 @RemoteApplicationEventScan 指定的软件包包括子软件包。
 *
 * 但是这种配置（包括自定义和自带的配置）类，它们使用的场景很少。因为很少会改动一处就去验证，这样成本很高。往往真实的情况是，我们
 * 的配置改动的很杂又多，一般都是直接修改之后 push 到仓库，然后直接重启应用。
 */
public class MyEvent extends RemoteApplicationEvent {
    //RemoteApplicationEvent
}
