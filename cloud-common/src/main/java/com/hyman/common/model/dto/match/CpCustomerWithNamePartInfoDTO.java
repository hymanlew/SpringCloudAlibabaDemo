package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Changyuan Su
 * @date 2020/6/2 下午5:48
 * @Description:
 */
@ApiModel("企业微信成员部分信息DTO")
@Getter
@AllArgsConstructor
public class CpCustomerWithNamePartInfoDTO implements Serializable {
    private static final long serialVersionUID = -7660666769934584248L;

    @ApiModelProperty("客户昵称")
    private String customerName;

    @ApiModelProperty("添加了此客户的企业成员id")
    private Set<String> cpUserIds;

}
