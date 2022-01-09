package com.hyman.common.crm.business;

import cn.hutool.core.lang.Assert;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.hyman.common.crm.model.AccessToken;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:yanwei
 * @Date: 2020/9/3 - 16:32
 * 业务场景 —— 认证远程访问获取token信息
 */
@Slf4j
public class AuthRemote {
    public static AccessToken getAuthToken(String url, Map<String,Object> formBody,int timeout){
        HttpResponse response = HttpRequest.post(url).header(Header.CONTENT_TYPE, ContentType.FORM_URLENCODED.getValue())
                .form(formBody)
                 .timeout((int) TimeUnit.SECONDS.toMillis(timeout))
                  .execute();
        log.info("获取tokenResponse:{}",response.body());
           Assert.isTrue(response.getStatus() == 200,"获取认证token 失败,原因为:{}",response.body());
           return JSONUtil.toBean(response.body(), AccessToken.class);
    }
    public static AccessToken getAuthToken(String url, Map<String,Object> formBody){

        return getAuthToken(url, formBody,2);
    }
}
