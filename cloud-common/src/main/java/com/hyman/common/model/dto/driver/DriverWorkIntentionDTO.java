package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Changyuan Su
 * @date 2020/4/13 下午2:10
 * @Description:
 */
@ApiModel("司机接活意向实体")
@Data
public class DriverWorkIntentionDTO implements Serializable {

    private static final long serialVersionUID = -1361887160975840549L;
    @ApiModelProperty(value = "编号")
    private Integer id;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "值")
    private String value;

    @ApiModelProperty(value = "真实值")
    private List<String> realValues;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
}
