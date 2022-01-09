package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@ApiModel("根据城市平均分配BGL或加盟经理DTO")
@Data
public class CustomerServicePhoneDTO implements Serializable {


    private static final long serialVersionUID = -196514630466114855L;

    @ApiModelProperty("用户编号")
    private String userId;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;
}
