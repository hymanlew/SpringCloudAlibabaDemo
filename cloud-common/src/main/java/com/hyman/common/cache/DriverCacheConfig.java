package com.hyman.common.cache;

import com.hyman.common.feign.IDriverFeign;
import com.hyman.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author Changyuan Su
 * @date 2020/12/1 下午5:53
 * @Description:
 */
@Configuration
@DependsOn({"redisUtil"})
public class DriverCacheConfig {

    //    @Lazy
    @DependsOn("driverDbCache")
    @Autowired
    @Bean(name = "driverRedisCache")
    public Cache getRedisCache(RedisUtil redisUtil, @Qualifier("driverDbCache") Cache driverDbCache) {
        Cache cache = new DriverRedisCache(redisUtil, driverDbCache);
        return cache;
    }


    //    @Lazy
    @Autowired
    @Bean(name = "driverDbCache")
    @ConditionalOnClass(value = {FeignDriverDbCache.class, com.hyman.common.feign.IDriverFeign.class})
    @ConditionalOnMissingBean(name = "driverDbCache")
    public Cache getDbCache1(@Qualifier("com.hyman.common.feign.IDriverFeign") IDriverFeign driverFeign) {
        Cache cache = new FeignDriverDbCache(driverFeign);
        return cache;
    }


}
