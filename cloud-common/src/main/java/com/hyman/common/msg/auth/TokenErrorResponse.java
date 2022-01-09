package com.hyman.common.msg.auth;

import com.hyman.common.constant.RestCodeConstants;
import com.hyman.common.msg.BaseResponse;

/**
 * @Author tianchong 目前用于小程序端token验证问题反馈，需要重新换取token
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
