package com.hyman.common.aspect;

import cn.hutool.core.collection.CollectionUtil;
import com.hyman.common.annotation.ConsumeDuplicationCheck;
import com.hyman.common.util.AopUtil;
import com.hyman.common.util.AssertUtil;
import com.hyman.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hucl
 * @date 2021/6/8 3:04 下午
 */
@Component
@Aspect
@Slf4j
public class ConsumeDuplicationCheckAspect {
    @Resource
    private RedisUtil redisUtil;

    @Pointcut(value = "execution( * com.hyman..*.*(..)) && @annotation(com.hyman.common.annotation.ConsumeDuplicationCheck)")
    public void pointCut() {}


    @Around(value = "pointCut()")
    private Object preAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        ConsumeDuplicationCheck anno = AopUtil.getMethodAnnotation(joinPoint, ConsumeDuplicationCheck.class);
        long expire = anno.expire();

        // Arrays.stream(joinPoint.getArgs()).forEach(o -> System.out.println("arg value: " + o.toString()));

        String key = getKey(joinPoint, anno.redisPrefix(), anno.redisSuffix());
        if (redisUtil.hasKey(key)) {
            log.info("消息已被消费过!");
            return null;
        } else {
            setValue(key, "1", expire);
        }

        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            del(key);
            throw e;
        }
    }


    private String getKey(JoinPoint joinPoint, String prefix, String suffixField) throws NoSuchFieldException {
        List<Object> suffixList = AopUtil.getParamValueByFieldName(joinPoint, suffixField);
        AssertUtil.isTrue(CollectionUtil.isNotEmpty(suffixList), "消息唯一id不能为null, methodName:{} ", joinPoint.getSignature().getName());
        return prefix.concat(String.valueOf(suffixList.get(0)));
    }

    private void setValue(String key, String value, long expireTime) {
        redisUtil.set(key, value, expireTime);
    }

    private void del(String key) {
        redisUtil.del(key);
    }



}
