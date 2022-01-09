package com.hyman.common.msg.auth;

import com.hyman.common.constant.RestCodeConstants;
import com.hyman.common.msg.BaseResponse;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
