package com.hyman.common.enums.order;

import org.apache.commons.lang3.StringUtils;

/**
 * 支付方式枚举类
 * Created by tianc on 2019/9/2.
 */
public enum PayTypeEnum {
    ACCT_BOOK(1, "梧桐账户"),
    WECHAT(2, "微信支付"),
    YUNNIAO_WALLET(3, "A端扣除"),
    ALIPAY(4, "支付宝"),
    UNIONPAY(5, "银联"),
    CASH(6,"现金"),
    SWIPE(7,"对公转账（银行卡转账）"),
    COMBINATION(8,"组合"),
    ORDER_REFUND(9, "订单退款"),
    WECHAT_XCX(10,"微信小程序"),
    SYSTEM(99, "平台系统"),
    POSS(11,"POSS机"),
    ZX_BANK(12,"中信银行（扫加盟收款码）"),
    ;

    private Integer code;
    private String name;

    PayTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }



    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (PayTypeEnum payTypeEnum : values()) {
                if (code.intValue() == payTypeEnum.code) {
                    return payTypeEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer getCodeByName(String desc) {
        if (StringUtils.isNotBlank(desc)) {
            for (PayTypeEnum value : values()) {
                if (value.name.equals(desc.trim())) {
                    return value.getCode();
                }
            }
        }
        return null;
    }

}
