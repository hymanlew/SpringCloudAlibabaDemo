package com.hyman.common.feign;

import com.hyman.common.fallback.IMQFeignFallBack;
import com.hyman.common.model.dto.mq.PublishMessageDTO;
import com.hyman.common.msg.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author hyman
 * @date 2020/8/7 16:32
 */
@FeignClient(value = "microservice-mq", fallbackFactory = IMQFeignFallBack.class, primary = false)
public interface IMQFeign {

    /**
     * 发布消息
     *
     * @param publishMessageDTO 消息协议体
     * @return Result
     */
    @PostMapping("/mq/publish")
    Result publish(@RequestBody PublishMessageDTO publishMessageDTO);
}
