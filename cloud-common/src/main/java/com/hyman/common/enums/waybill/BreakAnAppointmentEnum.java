package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author NiuZhiPeng
 * @date 2020/12/14 17:32
 * @Description： 爽约原因枚举
 */
@Getter
public enum BreakAnAppointmentEnum {

    SUBJECTIVE_REASONS(17,"主观原因（就不来）"),
    OBJECTIVE_REASONS(18,"客观原因（生病/交警抓车）"),
    OTHER(19,"其他"),

    //2021/02/02 NiuZhiPeng
    CUSTOMER_CANCEL_USER_CAR(20,"客户取消用车"),
    CUSTOMER_OF_CONTRACT(21,"客户改约"),
    DRIVER_CAN_NOT_CONTACT(22,"司机联系不上"),
    DRIVER_REPENTANCE(23,"司机反悔"),
    DRIVER_OF_CONTRACT(24,"司机改约");

    private Integer code;
    private String name;

    BreakAnAppointmentEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code){
        if (code != null){
            for (BreakAnAppointmentEnum breakAnAppointmentEnum : values()){
                if (code.intValue() == breakAnAppointmentEnum.getCode()){
                    return breakAnAppointmentEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static BreakAnAppointmentEnum getEnum(Integer code){
        if (code != null){
            for (BreakAnAppointmentEnum breakAnAppointmentEnum : values()){
                if (code.intValue() == breakAnAppointmentEnum.getCode()){
                    return breakAnAppointmentEnum;
                }
            }
        }
        return null;
    }
}
