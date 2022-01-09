package com.hyman.common.msg.sms;

import cn.hutool.http.HttpStatus;
import com.hyman.common.feign.ICoreFeign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午4:10
 * @Description:
 */
@Slf4j
public class DefaultVerifySmsSender extends SmsMessageSender<VerifySmsMessage, VerifySmsResponse> implements VerifySmsSender<VerifySmsMessage, VerifySmsResponse> {

    /**
     * 验证码key
     */
    protected final String REDIS_VERIFY_CODE_KEY = "{base:sms:verify_code}:",
            REDIS_SEND_TIME_KEY = "{base:sms:verify_code}:repeat:";

    public static final String VERIFY_CODE_KEY = "verifyCode";

    //language=LUA
    private static final String SCRIPT =
            "redis.call('DEL', KEYS[1], KEYS[2]) \n" +
                    "redis.call('SET', KEYS[1], ARGV[1], 'PX', ARGV[2])\n" +
                    "redis.call('SET', KEYS[2], ARGV[4], 'PX', ARGV[3])\n" +
                    "return true";

    private final StringRedisTemplate redisTemplate;
    private final DefaultRedisScript<Boolean> assignCodeScript;

    public DefaultVerifySmsSender(ICoreFeign coreFeign, Executor executor, StringRedisTemplate redisTemplate) {
        super(coreFeign, executor);
        this.redisTemplate = redisTemplate;
        this.assignCodeScript = new DefaultRedisScript<>(SCRIPT, Boolean.class);
    }

    public DefaultVerifySmsSender(ICoreFeign coreFeign, StringRedisTemplate redisTemplate) {
        super(coreFeign);
        this.redisTemplate = redisTemplate;
        this.assignCodeScript = new DefaultRedisScript<>(SCRIPT, Boolean.class);
    }


    @Override
    public VerifySmsResponse sendCode(VerifySmsMessage msg, String code) {
        beforeSendCode(msg, code);
        long l = System.currentTimeMillis();
        //todo 日志打印测试性能
        log.info("【发送短信验证码】开始发送验证码--开始");
        boolean b = send(msg);
        log.info("【发送短信验证码】开始发送验证码--结束{}ms", System.currentTimeMillis() - l);
        if (b) {
            afterSendCode(msg, code);
        }

        VerifySmsResponse response = new VerifySmsResponse();
        response.setVerifyCode(b ? code : null);
        response.setSuccess(b);
        return response;
    }

    @Override
    public void sendCode(VerifySmsMessage msg, @NotBlank String code, Callback<VerifySmsResponse> listener) {
        executor.execute(() -> {
            beforeSendCode(msg, code);
            LocalDateTime now = LocalDateTime.now();
            VerifySmsResponse res = sendCode(msg, code);
            afterSendCode(msg, code);
            if (Objects.isNull(listener)) {
                return;
            }

            VerifySmsResponse r = getMeType();
            r.setSendTime(now);
            r.setFinishedTime(LocalDateTime.now());
            r.setVerifyCode(code);
            afterSend(msg, r);
            if (res.isSuccess()) {
                r.setCode(HttpStatus.HTTP_OK);
                listener.onSuccess(r);
            } else {
                r.setCode(HttpStatus.HTTP_BAD_REQUEST);
                listener.onFail(r, null);
            }
        });
    }

    private void beforeSendCode(VerifySmsMessage msg, String code) {
        beforeSendCode(msg.getToSbId());

        Map<String, Object> param = msg.getParam();
        param = CollectionUtils.isEmpty(param) ? Collections.singletonMap(VERIFY_CODE_KEY, code) : param;
        if (!param.containsKey(VERIFY_CODE_KEY)) {
            param.put(VERIFY_CODE_KEY, code);
        }
        msg.setParam(param);
        if (StringUtils.isBlank(msg.getVerifyCode())) {
            msg.setVerifyCode(code);
        }
    }

    @Override
    public boolean isAllowRepeatSend(@NotBlank String phone) {
        return !redisTemplate.hasKey(REDIS_SEND_TIME_KEY.concat(phone));
    }

    @Override
    public boolean isCodeExpired(@NotBlank String phone) {
        return !redisTemplate.hasKey(REDIS_VERIFY_CODE_KEY.concat(phone));
    }

    @Override
    public String getCode(@NotBlank String phone) {
        return redisTemplate.opsForValue().get(REDIS_VERIFY_CODE_KEY.concat(phone));
    }

    @Override
    public boolean clear(@NotBlank String phone) {
        /**
         * 删除redis中的键值
         */
        redisTemplate.delete(Arrays.asList(REDIS_VERIFY_CODE_KEY.concat(phone), REDIS_SEND_TIME_KEY.concat(phone)));
        return true;
    }

    @Override
    public long getLastSendTime(@NotBlank String phone) {
        String v = redisTemplate.opsForValue().get(REDIS_SEND_TIME_KEY.concat(phone));
        return StringUtils.isBlank(v) ? 0 : Long.parseLong(v);
    }

    @Override
    public long getDelaySecondsOfNext(@NotBlank String phone) {
        Long expire = null;
        return isAllowRepeatSend(phone) || Objects.isNull(expire = redisTemplate.getExpire(REDIS_SEND_TIME_KEY.concat(phone))) ? 0 : expire;
    }

    private void afterSendCode(VerifySmsMessage msg, String code) {
        long expireTime = msg.getExpireTime();
        long repeatTime = msg.getRepeatTime();
        String phone = msg.getToSbId();

        boolean success = redisTemplate.execute(this.assignCodeScript,
                Arrays.asList(REDIS_VERIFY_CODE_KEY.concat(phone), REDIS_SEND_TIME_KEY.concat(phone)),
                code, String.valueOf(expireTime), String.valueOf(repeatTime), String.valueOf(System.currentTimeMillis()));
    }

    private void beforeSendCode(String phone) {
        clear(phone);
    }


    /**
     * 目前权宜之计，采用模板方法获取对象
     *
     * @return
     */
    @Override
    protected VerifySmsResponse getMeType() {
        return new VerifySmsResponse();
    }


}
