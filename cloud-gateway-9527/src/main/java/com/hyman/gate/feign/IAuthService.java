package com.hyman.gate.feign;

import com.hyman.common.msg.Result;
import com.hyman.gate.config.FeignSupportConfig;
import com.hyman.gate.fallback.IAuthServiceFallback;
import com.hyman.gate.model.vo.VerificationTokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:
 * @Date: 2019年03月05日14:05:53
 * @Description:
 */
@FeignClient(value = "cloud-alibaba-domain-auth", fallbackFactory = IAuthServiceFallback.class, configuration = FeignSupportConfig.class)
public interface IAuthService {

    /**
     * 验证token 的权限
     *
     * @param uri
     * @return
     */
    @RequestMapping(value = "/bss/jwt/verificationToken", method = RequestMethod.POST)
    Result<VerificationTokenVo> verificationToken(@RequestParam("uri") String uri, @RequestHeader("token") String token);
}
