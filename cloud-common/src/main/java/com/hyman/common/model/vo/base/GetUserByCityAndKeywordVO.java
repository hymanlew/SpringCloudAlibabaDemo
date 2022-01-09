package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: GetUserByCityAndKeywordVO <br>
 * @date: 2020/12/28 11:18 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel("用户组织、用户名、用户手机号VO")
public class GetUserByCityAndKeywordVO {
    
    @ApiModelProperty("用户ID")
    private  Long id;
    
    @ApiModelProperty("用户手机号")
    private String mobile;
    
    @ApiModelProperty("用户名")
    private String nickName;
    
    @ApiModelProperty("城市编码")
    private Integer cityCode;
    
    @ApiModelProperty("用户详细组织名")
    private String officeNameDetail;
    
    @ApiModelProperty("用户状态：1启用、2禁用")
    private Integer status;
}
