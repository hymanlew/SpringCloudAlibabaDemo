package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/12/28 下午2:22
 * @Description:
 */
@ApiModel("用户基础信息")
@Getter
@Setter
public class BasicUserInfoVO implements Serializable {
    private static final long serialVersionUID = 1695017792434565978L;


    @ApiModelProperty(value = "用户Id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String nickName;

    @ApiModelProperty(value = "手机号")
    private String mobile;
}
