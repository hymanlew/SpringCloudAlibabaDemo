package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author hucl
 * @date 2020/11/7 16:29
 */
@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffActiveInfoVO {
    //用户
    @ApiModelProperty("用户Id")
    private Long id;
    //手机号
    @ApiModelProperty("手机号")
    private String mobile;
    //
    @ApiModelProperty("用户的姓名")
    private String name;

    @ApiModelProperty("企业微信成员id")
    private String corpUserId;

    @ApiModelProperty("用户状态：1启用，2禁用")
    private Integer status;


}
