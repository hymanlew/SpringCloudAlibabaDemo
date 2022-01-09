package com.hyman.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Changyuan Su
 * @date 2018/12/12 19:14
 * @Description: 客户来源ENUM
 */
@Getter
@AllArgsConstructor
public enum CustSourceEnum {

    WuTongApp(2,"梧桐APP","梧桐app注册而来的用户"),
    Insurance(3,"云鸟","梧桐买保险创建用户"),
    WuTongApplets(4,"梧桐小程序","梧桐小程序产生的用户【普通游客提交线索生成的潜客；登录注册上来的用户】"),
    YOUZAN(5,"有赞","来源于有赞");

    /**
     * 来源编码
     */
    private int source;

    /**
     * 来源平台
     */
    private String platform;

    /**
     * 来源描述
     */
    private String desc;

    /**
     * 获取来源
     *
     * @param source
     * @return
     */
    public static String getPlatformBySource(int source) {
        for (CustSourceEnum custSourceEnum : values()) {
            if (source == custSourceEnum.source) {
                return custSourceEnum.getPlatform();
            }
        }
        return null;
    }

}
