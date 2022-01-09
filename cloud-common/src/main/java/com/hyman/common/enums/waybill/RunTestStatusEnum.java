package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author xiefujiang
 * @Classname RunTestStatusEnum
 * @Description
 * @Date 2020/8/28
 */
@Getter
public enum RunTestStatusEnum {
    /**
     * 试跑在跑状态枚举
     */
    //-1 待上岗 意向失败、跟车失败、试跑失败、稳定掉线
    WAIT_TO_TUN(0, "无"),
    TO_CONFIRM_INTENTION(50,"待确认意向"),
    TO_TRY_RUN(100, "待确认到场"),
    INTENTION_FAILURE(150, "意向失败"),
    HAVE_TRY_RUN(200, "试跑中"),
    HAVE_FOLLOW_CAR(300, "跟车中"),
    FOLLOW_CAR_DROPPED(400, "跟车失败"),
    STEADY_RUNNING(500, "稳定在跑"),
    TRY_RUN_DROPPED(600, "试跑失败"),
    STEADY_RUNNING_DROPPED(700, "稳定掉线");


    /**
     * 订单状态code
     */
    private Integer code;
    /**
     * 订单状态名字
     */
    private String name;

    RunTestStatusEnum(Integer code, String Name) {
        this.name = Name;
        this.code = code;
    }


    public static RunTestStatusEnum getEnum(Integer code) {
        if (code != null) {
            for (RunTestStatusEnum runTestStatusEnum : values()) {
                if (code.intValue() == runTestStatusEnum.code) {
                    return runTestStatusEnum;
                }
            }
        }
        return null;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (RunTestStatusEnum runTestStatusEnum : values()) {
                if (code.intValue() == runTestStatusEnum.code) {
                    return runTestStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

  /*  public static Boolean checkSales(Integer code) {
        if (code != null) {
            Integer[] arr = new Integer[]{HAVE_TRY_RUN.code, STEADY_RUNNING.code};
            List<Integer> integers = Arrays.asList(arr);
            boolean contains = integers.contains(code);
            boolean tryRun = code.equals(HAVE_TRY_RUN.code);
            return contains && tryRun;

        } else {
            return Boolean.FALSE;
        }

    }

    public static Boolean checkOff(Integer code) {
        if (code != null) {
            Integer[] arr = new Integer[]{TRY_RUN_DROPPED.code, STEADY_RUNNING_DROPPED.code};
            List<Integer> integers = Arrays.asList(arr);
            return integers.contains(code);

        } else {
            return Boolean.FALSE;
        }

    }*/

    /**
     * 判断状态是否移除
     **/
    public static Boolean removeLine(Integer code) {
        if (Objects.isNull(code)) {
            return Boolean.FALSE;
        }
        Integer[] arr = new Integer[]{TO_CONFIRM_INTENTION.code};
        List<Integer> integers = Arrays.asList(arr);
        return integers.contains(code);
    }

    /**
     * 判断状态是否创建
     **/
    public static Boolean creatLine(Integer code) {
        if (Objects.isNull(code)) {
            return Boolean.FALSE;
        }
        Integer[] arr = new Integer[]{INTENTION_FAILURE.code, FOLLOW_CAR_DROPPED.code, WAIT_TO_TUN.code};
        List<Integer> integers = Arrays.asList(arr);
        return integers.contains(code);
    }

    public static RunTestStatusEnum getPositiveEnum(Integer code) {
        if (code != null) {
            RunTestStatusEnum runTestStatusEnum = getEnum(code);
            if(runTestStatusEnum != null && (
                RunTestStatusEnum.TO_CONFIRM_INTENTION == runTestStatusEnum ||
                RunTestStatusEnum.TO_TRY_RUN == runTestStatusEnum ||
                RunTestStatusEnum.HAVE_TRY_RUN == runTestStatusEnum ||
                RunTestStatusEnum.HAVE_FOLLOW_CAR == runTestStatusEnum ||
                RunTestStatusEnum.STEADY_RUNNING == runTestStatusEnum) ) {
                return runTestStatusEnum;
            }
        }
        return null;
    }

    public static List<RunTestStatusEnum> getPositiveEnum(List<Integer> codes) {
        List<RunTestStatusEnum> runTestStatusEnums = new ArrayList<>();
        if (codes != null) {
            for (Integer code : codes) {
                RunTestStatusEnum runTestStatusEnum = getEnum(code);
                if (runTestStatusEnum != null && (
                        RunTestStatusEnum.TO_CONFIRM_INTENTION == runTestStatusEnum ||
                                RunTestStatusEnum.TO_TRY_RUN == runTestStatusEnum ||
                                RunTestStatusEnum.HAVE_TRY_RUN == runTestStatusEnum ||
                                RunTestStatusEnum.HAVE_FOLLOW_CAR == runTestStatusEnum ||
                                RunTestStatusEnum.STEADY_RUNNING == runTestStatusEnum)) {
                    runTestStatusEnums.add(runTestStatusEnum);
                }
            }
        }
        return runTestStatusEnums;
    }

    public static Boolean isNegativeEnum(List<Integer> codes) {
//        意向失败、跟车失败、试跑失败、稳定掉线
        if (codes != null && codes.size() > 0) {
            for (Integer code : codes) {
                RunTestStatusEnum runTestStatusEnum = getEnum(code);
                if(!(RunTestStatusEnum.INTENTION_FAILURE == runTestStatusEnum ||
                                RunTestStatusEnum.FOLLOW_CAR_DROPPED == runTestStatusEnum ||
                                RunTestStatusEnum.TRY_RUN_DROPPED == runTestStatusEnum ||
                                RunTestStatusEnum.STEADY_RUNNING_DROPPED == runTestStatusEnum)) {
                    return false;
                }
            }
        }
        return true;
    }

}
