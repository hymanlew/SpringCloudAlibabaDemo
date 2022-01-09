package com.hyman.common.crm.service.exchange.line;

import com.hyman.common.crm.common.CrmRemoteConfig;
import com.hyman.common.crm.service.CrmAbsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:yanwei
 * @Date: 2020/9/7 - 19:33
 *
 * crm- 线路云-项目传输介质
 */
@Component
public class CrmLineProjectService extends CrmAbsService {

    @Resource
    private CrmRemoteConfig crmRemoteConfig;
    @Override
    protected CrmRemoteConfig remoteConfig() {
        return crmRemoteConfig;
    }

    /**
     * 更新crm 某个字段的值
     */


}
