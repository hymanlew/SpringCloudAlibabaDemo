package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author NiuZhiPeng
 * @date 2020/12/14 17:37
 * @Description： 到场扭头就走
 */
@Getter
public enum  TurnAroundEnum {

    DRIVER_EXPECT_HIGH(20,"司机期望比较值高"),
    CUSTOMER_TEMP_NOT_USER_CAR(21,"客户临时不用车"),
    CUSTOMER_THINK_DRIVER_CAR_NOT_MATCH(13,"客户认为司机车型不符"),
    OTHER(22,"其他"),

    //2021/02/02 NiuZhiPeng
    RECEPTIONIST_ATTITUDE_BAD(24,"接待人态度不好"),
    DRIVER_FEEL_CHEATED(25,"司机觉得被骗了"),
    DRIVER_FEEL_NOT_DO_WORK(26,"司机觉得活干不了");


    private Integer code;
    private String name;

    TurnAroundEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code){
        if (code != null){
            for (TurnAroundEnum turnAroundEnum : values()){
                if (code.intValue() == turnAroundEnum.getCode()){
                    return turnAroundEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static TurnAroundEnum getEnum(Integer code){
        if (code != null){
            for (TurnAroundEnum turnAroundEnum : values()){
                if (code.intValue() == turnAroundEnum.getCode()){
                    return turnAroundEnum;
                }
            }
        }
        return null;
    }
}
