package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author hucl
 * @date 2021/5/12 10:15 上午
 */
@Getter
@Setter
@ApiModel("司机部分标签信息")
public class DriverLabelPartInfoVO {

    /**
     * 司机情况
     */
    @ApiModelProperty(value = "司机情况Code")
    private Integer driverSituation;

    /**
     * 司机情况 name
     */
    @ApiModelProperty(value = "司机情况Name")
    private String driverSituationName;

    /**
     * 最后一次出车日期
     */
    @ApiModelProperty(value = "最后一次出车日期")
    private Date lastRunDate;

    /**
     * 成交日期
     */
    @ApiModelProperty(value = "成交日期")
    private Date dealDate;
}
