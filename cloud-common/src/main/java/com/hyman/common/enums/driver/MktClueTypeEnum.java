package com.hyman.common.enums.driver;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;

import java.util.Arrays;

/**
 * 司机侧-市场部线索-线索类型枚举
 *
 * @author hucl
 * @date 2021/3/2 11:39
 * @since v2.7
 */
@Getter
public enum MktClueTypeEnum {
    WT_SPECIAL(0, "梧桐专车"),
    WT_SHARE(1, "梧桐共享"),
    LN_CAR_POOL(2, "雷鸟车池"),
    LN_HIRE(3, "雷鸟租赁"),
    ;
    private final Integer code;
    private final String desc;

    MktClueTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (MktClueTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getDesc();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * description: 根据表名获取枚举值
     * param: [tableName]
     * return: TableNameEnum
     * author  hyman
     * createTime: 2021/3/9
     */
    @Nullable
    public static MktClueTypeEnum getByCode(@NonNull Integer code) {
        return ObjectUtil.isNotNull(code) ? null : Arrays.stream(values()).filter(e -> e.getCode().intValue() == code).findAny().orElse(null);
    }
}
