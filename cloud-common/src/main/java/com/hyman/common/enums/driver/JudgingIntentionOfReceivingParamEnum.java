package com.hyman.common.enums.driver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;

/**
 * 司机接活意向字典值
 *
 * @author
 * @date 2020-04-09
 **/
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum JudgingIntentionOfReceivingParamEnum {

    ERROR(StringUtils.EMPTY, "不可能出现"),


    CAR_TYPE("Intentional_compartment", "意向车型"),
    CARGO_TYPE("type_of_goods", "货物类型"),
    // 不从字典表里走，从区域表出
    DELIVERY_AREA("area_no_dict_delivery", "配送区域，对应线路配送区域"),
    ARRIVAL_AREA("area_no_dict_arrival", "到仓区域,对应线路仓位置"),

    HANDLING_DIFFICULTY_DEGREE("handling_difficulty_degree", "装卸难度"),
    DEPARTURE_TIME("departure_time_interval", "出车时段");

    private String dictType, description;

    public static JudgingIntentionOfReceivingParamEnum getByDictType(@NotBlank String dictType) {
        return Arrays.stream(values()).filter(e -> e.dictType.equals(dictType)).findAny().orElse(ERROR);
    }


}
