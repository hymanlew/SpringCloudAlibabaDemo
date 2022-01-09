package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author: tianc
 * @create: 2020-03-10
 * @description: 司机的企业微信用户id
 **/
@Data
@ApiModel("司机的企业微信用户id")
public class CorpUserIdOfDriversVO implements Serializable {

    private static final long serialVersionUID = 7194010702688961084L;

    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "企业微信用户编号")
    private String corpUserId;
}