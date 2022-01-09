package com.hyman.common.enums.mq;

import lombok.Getter;

/**
 * mq发布 基础信息
 *
 * @author hucl
 * @date 2020/8/7 16:59
 */
@Getter
public enum BasicMQPublishEnum {
    AUTH_SYNC_USER("szjw-domain-auth", "authSyncTag", "auth"),
    BASE_SYNC_ROLE("szjw-domain-base", "baseSyncTag", "base"),
    Driver_CREATED_EVENT("szjw-domain-driver", "driverCreated", "driver"),
    Driver_UPDATED_EVENT("szjw-domain-driver", "driverUpdated", "driver"),
    // 司机-撮合 标签同步topic
    Driver_MATCH_LABEL_SYNC_EVENT("szjw-driver-match-labelsync", "labelSyncCommonTag", "driver");

    // mq主题
    private String topic;
    // mq主题下的标签
    private String tag;
    // 来源(客户端)
    private String source;

    BasicMQPublishEnum(String topic, String tag, String source) {
        this.topic = topic;
        this.tag = tag;
        this.source = source;
    }
}
