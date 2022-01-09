package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author NiuZhiPeng
 * @date 2020/12/14 17:07
 * @Description： 取消试跑意向原因
 */
@Getter
public enum CancelRunTestIntentionEnum {

    RUN_TEST_INFORMATION_ERROR(11,"试跑意向信息有误（线路/司机）"),
    DRIVER_TMP_BUSY(12,"司机临时有事"),
    CUSTOMER_CANCEL_USER_CAR(13,"客户取消用车"),
    DRIVER_CAN_NOT_CONTACT(14,"司机联系不上"),
    DRIVER_NOT_KNOW_RUN_TEST_INTENTION(15,"司机不知道试跑意向"),
    OTHER(16,"其他");



    private Integer code;
    private String name;

    CancelRunTestIntentionEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code){
        if (code != null){
            for (CancelRunTestIntentionEnum cancelRunTestIntentionEnum : values()){
                if (code.intValue() == cancelRunTestIntentionEnum.getCode()){
                    return cancelRunTestIntentionEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static CancelRunTestIntentionEnum getEnum(Integer code){
        if (code != null){
            for (CancelRunTestIntentionEnum intentionFailureTypeEnum : values()){
                if (code.intValue() == intentionFailureTypeEnum.getCode()){
                    return intentionFailureTypeEnum;
                }
            }
        }
        return null;
    }
}
