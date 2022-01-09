package com.hyman.common.model.dto.waybill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 司机/客户运费账户创建所需信息
 *
 * @author wanghaitong
 * @date 2020/9/30 11:22
 */
@Data
@ApiModel("司机、客户运费账户创建所需信息Dto")
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAcctDto implements Serializable {

    @NotNull
    @ApiModelProperty("司机/客户ID")
    private String userId;

    @NotNull
    @ApiModelProperty("账户类型 {1:个人, 2:组织}")
    private Integer acctType;

    @ApiModelProperty("支付密码")
    private String payPassword;
}
