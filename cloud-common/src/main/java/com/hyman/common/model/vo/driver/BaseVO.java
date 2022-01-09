package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseVO {
    @ApiModelProperty(value = "创建人id")
    private Long createId;

    @ApiModelProperty(value = "创建人姓名")
    private String createName;

    @ApiModelProperty(value = "创建人手机号")
    private String createPhone;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改人")
    private Long updateId;

    @ApiModelProperty(value = "修改人姓名")
    private String updateName;

    @ApiModelProperty(value = "修改人手机号")
    private String updatePhone;

    @ApiModelProperty(value = "修改时间")
    private Date updateDate;
}
