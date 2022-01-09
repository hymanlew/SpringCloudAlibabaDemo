package com.hyman.common.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.hyman.common.crm.business.AuthRemote;
import com.hyman.common.crm.common.CrmRemoteConfig;
import com.hyman.common.crm.constant.CrmConstant;
import com.hyman.common.crm.model.AccessToken;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:yanwei
 * @Date: 2020/9/3 - 9:16
 */
@Slf4j
public abstract class CrmAbsService implements CrmService {
    private volatile AccessToken accessToken;
    private ReentrantLock lock = new ReentrantLock();

    protected abstract CrmRemoteConfig remoteConfig();

    /**
     * 获取TOKEN 信息
     *
     * @return
     */
    protected AccessToken getToken() {
        log.info("#########################################################");
        log.info("token is :{}",JSONObject.toJSONString(accessToken));
        log.info("#########################################################");
        if (Objects.nonNull(accessToken) && !accessToken.isExpired())
            return accessToken;
        lock.lock();
        try {
            if (Objects.nonNull(accessToken) && !accessToken.isExpired())
                return accessToken;
            CrmRemoteConfig crmRemoteConfig = remoteConfig();
            HashMap<String, Object> formBody = Maps.newHashMap();
            formBody.put("username", crmRemoteConfig.getUsername());
            formBody.put("password", crmRemoteConfig.getAuthPassword());
            formBody.put("client_secret", crmRemoteConfig.getClientSecret());
            formBody.put("client_id", crmRemoteConfig.getClientId());
            formBody.put("grant_type", crmRemoteConfig.getGrantType());
            int timeout = crmRemoteConfig.getTimeout();
            accessToken = AuthRemote.getAuthToken(crmRemoteConfig.getUrl().concat(CrmConstant.AUTH_URN), formBody, timeout);
        } finally {
            lock.unlock();
        }
        log.info("#########################################################");
        log.info("token is :{}",JSONObject.toJSONString(log));
        log.info("#########################################################");
        return accessToken;
    }

    // 刷新token
    protected void reSetToken() {
        accessToken = null;
        getToken();
    }
}
