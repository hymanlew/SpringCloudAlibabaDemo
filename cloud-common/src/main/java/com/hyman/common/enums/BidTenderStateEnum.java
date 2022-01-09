package com.hyman.common.enums;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Changyuan Su
 * @date 2019/4/15 10:53
 * @Description:
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BidTenderStateEnum {


    @Deprecated WAIT_APPLY(1, "待审核"),
    WAIT_PENDING(2, "待中标"),
    SUCCESSFUL_BIDDING(3, "中标未成交"),
    @Deprecated APPLY_NOT_PASS(6, "审核未通过"),
    SUCCESSFUL_BID_HAS_BEEN_COMPLETED(7, "中标已成交"),
    MANUAL_OFFLINE(8, "手动下线"),
    END_OF_DUE_LINE(9, "到期结束下线"),
    SUCCESSFUL_BID_AND_WINNING(10, "中标在跑"),

    // 合伙承运，标书状态
    // http://dev.xunhuji.me:18095/pages/viewpage.action?pageId=69831298


    /**
     * 当前需求上线日期为11月22日，截止到11月21日，系统使用的只有2个状态，分别是2，8
     * <p>
     * 为2状态的有119条 ；为8状态的有29条
     * <p>
     * 基于上诉原因，考虑到日后的兼容问题，目前做如下的设计
     * 原有代码如果使用【1，2，3，6，7，8，9，10】这几个状态，相应代码以及落入数据库状态码不变
     * 在聚合到elasticsearch时，旧状态码进行转变，使用新状态 【转变逻辑参看 下面 tenderStateTransfer 方法 】
     * <p>
     * 新代码，新逻辑使用下列新的状态值，elasticsearch 也一样保持
     */

    TOBECOMBINED(11, "待撮合"),
    FLOWMARKER(12, "流标"),
    HASWONTHEBID(13, "已中标"),
    UNFILLED(14, "未成交"),
    DEALDONE(15, "已成交"),
    SCRAP(16, "废标"),
    RUNNING(17, "在跑"),
    ;

    /**
     * 对用于字典中的 键值
     */
    @ApiModelProperty("编码值")
    private int code;

    /**
     * 对用于字典 标签
     */
    @ApiModelProperty("编码对应的value")
    private String value;

    /**
     * 根据code值获取中文名
     *
     * @param code
     * @return
     */
    public static String getValueByCode(Integer code) {
        if (Objects.isNull(code)) {
            return StringUtils.EMPTY;
        }
        return Arrays.stream(values()).filter(e -> code == e.code).map(e -> e.value).findAny().orElse(StringUtils.EMPTY);
    }


    public static BidTenderStateEnum getByValue(int value) {
        for (BidTenderStateEnum anEnum : values()) {
            if (anEnum.getCode() == value) {
                return anEnum;
            }
        }
        return null;
    }

    /**
     * 状态转变，旧状态转变成新状态
     */
    public static int tenderStateTransfer(int tenderState) {
        if (tenderState == 1 || tenderState == 2) {
            tenderState = 11;
        } else if (tenderState == 3 || tenderState == 6) {
            tenderState = 14;
        } else if (tenderState == 7) {
            tenderState = 15;
        } else if (tenderState == 8 || tenderState == 9) {
            tenderState = 16;
        } else if (tenderState == 10) {
            tenderState = 17;
        }
        return tenderState;
    }

}
