package com.hyman.common.enums.bill;

/**
 * @description: 缴费类型 <br>
 * @date: 2020/12/16 16:23 <br>
 * @author: hyman <br>
 */
public enum PayCostTypeEnum {
    
    ORDER_RENEWAL(1,"订单续费"),
    NOT_ORDER_CHARGE(0,"无订单充值");
    ;
    
    private final Integer code;
    private final String desc;
    
    PayCostTypeEnum(int code, String desc){
        this.code = code;
        this.desc  = desc;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public static String getValueByCode(Integer code) {
        for (PayCostTypeEnum ele : values()) {
            if(ele.getCode().equals(code)){
                return ele.desc;
            }
        }
        return "";
    }
}
