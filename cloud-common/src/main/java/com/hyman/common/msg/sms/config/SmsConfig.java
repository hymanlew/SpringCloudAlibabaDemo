package com.hyman.common.msg.sms.config;

import com.hyman.common.feign.ICoreFeign;
import com.hyman.common.msg.sms.DefaultVerifySmsSender;
import com.hyman.common.msg.sms.MessageSender;
import com.hyman.common.msg.sms.SmsMessageSender;
import com.hyman.common.msg.sms.VerifySmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Changyuan Su
 * @date 2020/12/8 上午9:41
 * @Description:
 */
@Configuration
public class SmsConfig {

    /**
     * 核心线程数
     */
    private final int corePoolSize = Runtime.getRuntime().availableProcessors(),
    /**
     * 最大线程数
     */
    maxPoolSize = corePoolSize << 1,
    /**
     * 队列数
     */
    queueCapacity = maxPoolSize << 3;

    @Lazy
    @Bean(value = "smsTaskExecutor")
    public Executor taskExecutor() {
        final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize << 2);
        taskExecutor.setMaxPoolSize(maxPoolSize << 3);
        taskExecutor.setQueueCapacity(queueCapacity << 4);
        taskExecutor.setKeepAliveSeconds(100);
        taskExecutor.setThreadNamePrefix("sms-thread-");
        //用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }


    @ConditionalOnClass(value = {ICoreFeign.class, StringRedisTemplate.class})
    @ConditionalOnMissingBean(value = VerifySmsSender.class)
    @Autowired
    @Bean
    public VerifySmsSender verifySmsSender(ICoreFeign coreFeign, StringRedisTemplate redisTemplate) {
        return new DefaultVerifySmsSender(coreFeign, taskExecutor(), redisTemplate);
    }

    @ConditionalOnClass(value = {ICoreFeign.class})
    @ConditionalOnMissingBean(value = MessageSender.class)
    @Autowired
    @Bean
    public MessageSender smsMessageSender(ICoreFeign coreFeign) {
        return new SmsMessageSender(coreFeign, taskExecutor());
    }


}
