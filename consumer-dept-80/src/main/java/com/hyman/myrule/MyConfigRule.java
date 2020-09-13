package com.hyman.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * volatile 是告诉编译器，每次取这个变量的值都需要从主存中取，而不是用自己线程工作内存中的缓存。
 * static 是说这个变量在主存中所有此类的实例用的是同一份，各个线程创建时需要从主存同一个位置拷贝到自己工作内存中去（而不是拷贝
 *        此类不同实例中的这个变量的值），也就是说只能保证线程创建时变量的值是相同来源的。但是运行时还是使用各自工作内存中的值，
 *        依然会有不同步的问题。
 */
public class MyConfigRule extends AbstractLoadBalancerRule {

    // 自定义策略（例如每个服务都要执行 5 次，才交给下一个服务去执行）
    private volatile int times = 0;
    // 当前服务的下标，用于固定当前的服务
    private volatile int currentServerIndex = 0;

    public MyConfigRule() {
        super();
    }

    // 增加了一个负载均衡器对象参数，并忽略空值警告
    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {

        // 如果负载算法为空，则直接返回空
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            //根据选择逻辑的实现，使每次选择都应选出一个服务实例。while 是为防止多线程并发时出现死循环而获取不到服务实例的Bug。
            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                // 通过传入的负载均衡器来获得可用实例列表
                List<Server> upList = lb.getReachableServers();
                // 获取所有实例列表
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                // 以所有实例列表下标为基础生成一个随机数
                //int index = this.chooseRandomInt(serverCount);

                // 自定义负载算法策略（例如每个服务都要执行 5 次，才交给下一个服务去执行）
                if(times < 5){
                    server = (Server)upList.get(currentServerIndex);
                    System.out.println("=== "+ server.getHost() +"："+ server.getPort() +"："+ server.getId() + " ===");
                    times++;
                }else{
                    times = 0;
                    currentServerIndex = this.chooseRandomInt(serverCount);
                }

                if (server == null) {
                    // 如果当前线程没有获取到可用的服务，则就把 cpu 时间让出，让其他线程去获取到可用的服务。
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }
                    // yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获
                    // 取执行权。但是并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可
                    // 能是当前线程又进入到“运行状态”继续运行！
                    server = null;
                    Thread.yield();
                }
            }
            return server;
        }
    }

    // 使用线程安全的随机数机制来获取随机数
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    // 将IRule接口的choose(Object key)函数实现委托给了该类中的 choose(ILoadBalancer lb, Object key)
    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        super.setLoadBalancer(lb);
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return super.getLoadBalancer();
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
