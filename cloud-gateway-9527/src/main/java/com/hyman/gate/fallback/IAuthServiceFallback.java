package com.hyman.gate.fallback;

import com.hyman.common.msg.Result;
import com.hyman.gate.feign.IAuthService;
import com.hyman.gate.model.vo.VerificationTokenVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Date: 2019年03月05日14:05:53
 * @Description:
 */
@Service
@Slf4j
public class IAuthServiceFallback implements FallbackFactory<IAuthService> {


    @Override
    public IAuthService create(Throwable cause) {
        return new IAuthService() {

            @Override
            public Result<VerificationTokenVo> verificationToken(String uri, String token) {
                return null;
            }
        };
    }
}
