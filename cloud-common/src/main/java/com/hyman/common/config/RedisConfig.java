package com.hyman.common.config;


import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;


//@ConditionalOnClass({RedisOperations.class})
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 设置 redis 数据默认过期时间
     * 设置@cacheable 序列化方式
     *
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        RedisSerializer redisSerializer = new GenericFastJsonRedisSerializer();
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .entryTtl(Duration.ofHours(1));
        return configuration;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        RedisSerializer valueSerializer = new GenericFastJsonRedisSerializer(),
                keySerializer = new StringRedisSerializer();
        template.setValueSerializer(valueSerializer);
        template.setHashValueSerializer(valueSerializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        return template;
    }

//    private static class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
//
//        private static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
//        private static final byte[] EMPTY_BYTE = new byte[0];
//
//        static {
//            ParserConfig.getGlobalInstance().setAutoTypeSupport(Boolean.TRUE);
//        }
//
//        private Class<T> clazz;
//
//        public FastJsonRedisSerializer(Class<T> clazz) {
//            super();
//            this.clazz = clazz;
//        }
//
//        @Override
//        public byte[] serialize(T t) throws SerializationException {
//            return Objects.isNull(t) ? EMPTY_BYTE : JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
//
////            if (t == null) {
////                return EMPTY_BYTE;
////            }
////            return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
//        }
//
//        @Override
//        public T deserialize(byte[] bytes) throws SerializationException {
//            if (bytes == null || bytes.length <= 0) {
//                return null;
//            }
//            String str = new String(bytes, DEFAULT_CHARSET);
//            return (T) (Objects.isNull(clazz) ? JSON.parse(str) : JSON.parseObject(str, clazz));
//        }
//    }
}
