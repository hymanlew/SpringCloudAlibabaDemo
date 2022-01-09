package com.hyman.common.enums.driver;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 司机侧-市场部线索-线索类型枚举
 *
 * @author hucl
 * @date 2021/3/2 11:39
 * @since v2.7
 */
@Getter
public enum MktClueBusiTypeEnum {
    WT_SPECIAL(0, "梧桐专车"),
    WT_SHARE(1, "梧桐共享"),
    LN_CAR_POOL(2, "雷鸟车池"),
    LN_HIRE_C(3, "雷鸟租赁")
    ;
    private final Integer code;
    private final String desc;

    MktClueBusiTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (MktClueBusiTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getDesc();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
