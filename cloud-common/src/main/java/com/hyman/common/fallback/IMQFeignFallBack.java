package com.hyman.common.fallback;

import com.hyman.common.feign.IMQFeign;
import com.hyman.common.model.dto.mq.PublishMessageDTO;
import com.hyman.common.msg.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * mq feign 回调
 *
 * @author hucl
 * @date 2020/8/7 16:34
 */
@Slf4j
@Service
public class IMQFeignFallBack implements FallbackFactory<IMQFeign> {
    @Override
    public IMQFeign create(Throwable throwable) {
        return new IMQFeign() {
            @Override
            public Result publish(PublishMessageDTO publishMessageDTO) {
                log.warn("mq发送消息失败,cause=[{}],msg=[{}]", throwable.getCause(), throwable.getMessage());
                return null;
            }
        };
    }
}
