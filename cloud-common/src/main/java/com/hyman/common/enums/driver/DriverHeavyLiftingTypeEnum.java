package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author yantao
 * @Date 2021/4/22 14:43
 * @Describe 装卸接受度
 */
public enum DriverHeavyLiftingTypeEnum {

    //no need Loading and unloading
    NO_NEED_LOADING_UNLOADING(1, "不需要装卸"),
    //light Loading and unloading
    LIGHT_LOADING_UNLOADING(2, "轻装卸"),
    //heavy Loading and unloading
    HEAVY_LOADING_UNLOADING(3, "重装卸"),
    ;

    private Integer code;
    private String value;

    DriverHeavyLiftingTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (DriverHeavyLiftingTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverHeavyLiftingTypeEnum getByValue(int value) {
        for (DriverHeavyLiftingTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }

    /**
     * 司机测 向 撮合侧的枚举值转换
     * <p>撮合测：
     * 不需要装卸：2 <br>
     * 轻装卸：1 <br>
     * 重装卸：0 <br>
     * </p>
     *
     * <p>司机测：
     * 不需要装卸：1 <br>
     * 轻装卸：2 <br>
     * 重装卸：3 <br>
     * </p>
     *
     * @param driverValue 司机侧的值
     * @return 转换成撮合测得值
     */
    public static Integer driverValueConvertToMatchValue(Integer driverValue) {
        if (driverValue == null) return null;

        if (Objects.equals(1, driverValue)) {
            return 2;
        } else if (Objects.equals(2, driverValue)) {
            return 1;
        } else if (Objects.equals(3, driverValue)) {
            return 0;
        } else {
            return null;
        }
    }

    /**
     * 撮合测 向 司机侧的枚举值转换
     *
     * <p>撮合测：
     * 不需要装卸：2 <br>
     * 轻装卸：1 <br>
     * 重装卸：0 <br>
     * </p>
     *
     * <p>司机测：
     * 不需要装卸：1 <br>
     * 轻装卸：2 <br>
     * 重装卸：3 <br>
     * </p>
     *
     * @param matchValue 撮合测的值
     * @return 转换成司机测的值
     */
    public static Integer matchValueConvertToDriverValue(Integer matchValue) {
        if (matchValue == null) return null;

        if (Objects.equals(2, matchValue)) {
            return NO_NEED_LOADING_UNLOADING.getCode();
        } else if (Objects.equals(1, matchValue)) {
            return LIGHT_LOADING_UNLOADING.getCode();
        } else if (Objects.equals(0, matchValue)) {
            return HEAVY_LOADING_UNLOADING.getCode();
        } else {
            return null;
        }
    }
}
