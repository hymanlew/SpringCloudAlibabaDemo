package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: DutyRoleInfo <br>
 * @date: 2021/3/17 11:38 <br>
 * @author: hyman <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class DutyRoleInfo implements Serializable {
    
    private static final long serialVersionUID = -2789860791495636847L;
    
    @ApiModelProperty("角色Id")
    private Integer roleId;
    
    @ApiModelProperty("角色名")
    private String roleName;
    
    @ApiModelProperty("职责Id")
    private Integer dutyId;
    
    @ApiModelProperty("职责名")
    private String dutyName;
    
    @ApiModelProperty("业务线 0 专车 1 共享 9 全部")
    private Integer busiType;
}
