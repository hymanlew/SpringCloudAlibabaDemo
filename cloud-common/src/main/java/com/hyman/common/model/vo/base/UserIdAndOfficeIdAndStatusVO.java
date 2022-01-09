package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: UserIdAndOfficeIdAndStatusVO <br>
 * @date: 2020/12/7 14:05 <br>
 * @author: hyman <br>
 */
@Data
public class UserIdAndOfficeIdAndStatusVO {
   
    @ApiModelProperty("用户Id")
    private Long id;
    
    @ApiModelProperty("组织id")
    private Integer officeId;
    
    @ApiModelProperty("状态：1启用，2禁用")
    private Integer status;
}
