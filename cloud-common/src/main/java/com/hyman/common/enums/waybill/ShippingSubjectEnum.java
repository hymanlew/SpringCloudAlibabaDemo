package com.hyman.common.enums.waybill;

import cn.hutool.core.lang.Assert;
import com.hyman.common.enums.bill.SubjectEnum;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运费费用科目枚举
 *
 * @author wanghaitong
 * @date 2020/9/30 10:47
 */
public enum ShippingSubjectEnum {

    /**
     * 运费费用科目
     */
    UNILATERAL_CONFIRMATION(1, "单边已确认", 0, SubjectEnum.WAY_BILL_UNILATERAL_CONFIRMATION),
    BILATERAL_CONFIRMATION(3, "已交叉确认", 0, SubjectEnum.WAY_BILL_BILATERAL_CONFIRMATION),
    INITIALIZATION(5, "运费初始化", 1, SubjectEnum.WAY_BILL_INITIALIZATION),
    ADJUSTMENT(6, "运费调整", 2, SubjectEnum.WAY_BILL_ADJUSTMENT),
    ;

    private final Integer code;
    private final String name;
    /**
     * 类型，0表示运费确认上报相关，1表示运费调整相关
     */
    private Integer opType = 1;
    private SubjectEnum wtSubject;

    ShippingSubjectEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    ShippingSubjectEnum(Integer code, String name, Integer subjectType) {
        this.code = code;
        this.name = name;
        this.opType = subjectType;
    }

    ShippingSubjectEnum(Integer code, String name, Integer opType, SubjectEnum wtSubject) {
        this.code = code;
        this.name = name;
        this.opType = opType;
        this.wtSubject = wtSubject;
    }

    public static Integer getSubjectCodeFromWayBillStatus(@Nonnull Integer status) {
        switch (WayBillStatusEnum.getByCode(status)){
            case CONFIRMED:
                return UNILATERAL_CONFIRMATION.getCode();
            case SECOND_CONFIRMED:
                return BILATERAL_CONFIRMATION.getCode();
            default:
                throw new IllegalArgumentException("没有对应状态:"+ status);
        }
    }

    public Integer getOpType() {
        return opType;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public SubjectEnum getWtSubject() {
        return wtSubject;
    }

    /**
     * 根据code换name
     *
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (ShippingSubjectEnum shippingSubjectEnum : values()) {
                if (code.intValue() == shippingSubjectEnum.code) {
                    return shippingSubjectEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 根据code换枚举
     *
     * @param code
     * @return
     */
    public static ShippingSubjectEnum getEnum(Integer code) {
        if (code != null) {
            for (ShippingSubjectEnum shippingSubjectEnum : values()) {
                if (code.intValue() == shippingSubjectEnum.code) {
                    return shippingSubjectEnum;
                }
            }
        }
        return null;
    }

    public static List<Map<String, String>> getDict(Integer subjectType) {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map;
        for (ShippingSubjectEnum value : ShippingSubjectEnum.values()) {
            if (subjectType != null && !value.opType.equals(subjectType)) {
                continue;
            }
            map = new HashMap<>(2);
            map.put("code", String.valueOf(value.getCode()));
            map.put("name", value.getName());
            list.add(map);
        }
        return list;
    }

    public static int getSubjectCodeOfWT(Integer code) {
        ShippingSubjectEnum anEnum = getEnum(code);
        Assert.isTrue(anEnum != null, "费用科目：{}不存在", code);
        return anEnum.getWtSubject().getCode();
    }
}
