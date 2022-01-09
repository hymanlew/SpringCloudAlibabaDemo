package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: StaffInfoVO <br>
 * date: 2020/7/18 17:36 <br>
 * author: hyman <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInfoVO {
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
    
    @ApiModelProperty("状态：1启用，2禁用")
    private Integer status;
    
    public StaffInfoVO(Long id,String mobile,String name,String corpUserId){
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.corpUserId = corpUserId;
    }
    
    public static StaffInfoVO of(Long id,String mobile,String name,String corpUserId,Integer status){
        return new StaffInfoVO(id,mobile,name,corpUserId,status);
    }
    
    public static StaffInfoVO of(Long id,String mobile,String name,String corpUserId){
        return new StaffInfoVO(id,mobile,name,corpUserId);
    }
}
