package com.hyman.common.model.form.waybill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/6/5 12:40
 * @Description:
 */
@ApiModel("具有日期时间查询的query")
@Data
public class KeyAndDateTimeQuery extends KeyQuery implements Serializable {

    private static final long serialVersionUID = -7861607739663788971L;
    @Nullable
    @ApiModelProperty(value = "开始时间[时间戳]选中日期当天的 00:00:00", required = false)
    private Long startDate;

    @Nullable
    @ApiModelProperty(value = "结束时间[时间戳]，选中日期当天的 23:59:59", required = false)
    private Long endDate;

}
