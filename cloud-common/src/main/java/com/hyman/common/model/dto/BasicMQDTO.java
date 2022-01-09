package com.hyman.common.model.dto;

import java.util.UUID;

/**
 * Mq消息体基类
 *
 * @author hucl
 * @date 2021/5/12 2:24 下午
 */
public class BasicMQDTO {

    /**
     * 唯一ID
     */
    private String uniqueId = UUID.randomUUID().toString().replace("-", "");

    /**
     * 推送时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
