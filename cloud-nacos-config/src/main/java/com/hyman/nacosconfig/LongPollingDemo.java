package com.hyman.nacosconfig;

import com.google.common.util.concurrent.AbstractScheduledService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 动态监听之 pull or push：
 * Nacos Config Server 上的配置发生变化时，需要让相关的应用感知到，这就需要客户端针对感兴趣的配置实现监听。一般客户端与
 * 服务端之间的数据交互无非是两种方式：pull（客户端主动拉取）和 push（服务端）。
 *
 * 对于 push 模式，服务端需要维持与客户端的长连接，如果客户端数量较多，那么服务端需要耗费大量的内存资源来保存每个连接，并
 * 且为了检测连接的有效性，还需要心跳机制来维持每个连接的状态。
 *
 * 对于 pull 模式，客户端需要定时从服务端拉取数据，由于定时任务会存在一定时间的间隔，所以不能保证数据的实时性，并且在服务
 * 端配置长时间不更新的情况下，客户端的定时任务会做一些无效的 pull 操作。
 *
 * Nacos 服务地址是 push 推送，而服务配置是使用 pull 拉取。但它不是简单的 pull 而是一种长轮询机制，结合 push 和 pull 两
 * 者的优势。客户端采用长轮询的方式定时发起 pull 请求，去检查服务端配置是否发生了改变，如果有变更，则客户端会取得最新的配
 * 置信息。
 */
 public class LongPollingDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

       /**
        * 所谓长轮询，是客户端发起轮询请求后，如果服务端配置发生了变更，就直接返回。如果没有变更，则服务端会先 hold 住这个请求，
        * 即服务端拿到这个请求后在指定的时间内一直不返回结果，直到在此时间内配置发生了变更，服务端就会把原来 hold 住的请求返回。
        *
        * Nacos 是先接收请求 -》检查配置是否变更 -》若没有则设置一个定时任务，延期 29.5s 执行，并把当前客户端的长轮询连接加入
        * allSubs 队列。这时就有两种方式触发该连接结果的返回：
        *
        * 1，在等待 29.5s 后触发自动检查机制，这时在经过检查后（0.5s 的检查期），不管配置是否有变更，都会把结果放入到 allSubs
        *  队列并返回给客户端。29.5s 就是这个长连接保持的时间，设置这个值是因为 http 会话默认的超时时间是 30s。
        *
        * 2，在 29.5s 内的任一时间，通过 Nacos Dashboard 或 API 的方式对配置进行修改，这会触发一个事件机制，监听到该事件的任务
        * 会遍历 allSubs 队列，找到发生变更的配置项对应的 ClientLongPolling 任务，将变更的数据通过该任务中的连接进行返回，这就完
        * 成了一次推送的操作。
        *
        * 这样即能够保证客户端实时感知配置的变化，也降低了服务端的压力。在 SpringBoot 项目启动时，spring 的 Environment 环境配
        * 置就会自动去获取远程服务端的配置信息（通过 spring SPI 机制（service provider interface 服务发现机制）来扫描到 META-INF/spring.factories
        * 中配置的 NacosConfigBootstrapConfiguration）。
        *
        *
        * 在客户端的请求 header 中添加 Long-Polling-Timeout-No-Hangup 属性是建立长连接，但它不是 httpservletrequest 的参数，
        * 而是客户端与服务端约定好的开启长连接的参数。
        * httpservletrequest.startAsync()，
        */
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        // 一定要由当前请求的线程进行连接操作以实现长连接，否则离开容器后它会立即返回响应。
        final AsyncContext asyncContext = request.startAsync();

        // 并且默认请求会话的超时时间不准，所以需要自己控制（在 httpservletrequest 中有定死的一个超时时间 30s）。可使用一个线程
        // 池定时器 ScheduledExecutorService 来生成一个定时任务处理。
        asyncContext.setTimeout(0L);

        /**
         * 使用线程池启动定时器：
         * schedule（调用一个 runnable 对象执行任务，间隔时间，时间单位），该方法只会在指定的时间之后执行一次。
         * scheduleAtFixedRate（调用 runnable 对象执行任务，间隔时间，之后间隔的时间，时间单位），该方法会在指定的时间之后
         * 执行一次，然后再按照指定的时间间隔有频率的执行。
         */
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.execute(new Runnable() {

            @Override
            public void run() {

                scheduler.schedule(new Runnable() {
                    @Override
                    public void run() {
                        // 读取本服务端的配置是否发生变更（使用 MD5 摘要对配置文件进行比对），并返回给客户端。
                    }
                }, 29500L, TimeUnit.MILLISECONDS);
            }
        });
    }

    @Override
    public void destroy() {

    }
}
