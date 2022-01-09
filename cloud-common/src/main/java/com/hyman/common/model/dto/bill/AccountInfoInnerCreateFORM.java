package com.hyman.common.model.dto.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 梧桐司机账户新增表单
 *
 * @author hucl
 * @date 2020/9/29 17:52
 */
@Data
@ApiModel(value = "梧桐司机新增Form")
public class AccountInfoInnerCreateFORM implements Serializable {

    private static final long serialVersionUID = -3950906607044144927L;


    /**
     * 用户编号, 目前是针对司机编号，其他含义待以后业务扩展
     */
    @ApiModelProperty(value = "用户编号[司机编号..]", required = true)
    @NotBlank(message = "用户编号不能为空")
    private String driverId;


    /**
     * 支付密码
     */
    @Nullable
    @ApiModelProperty(value = "支付密码")
    private String payPassword;


}
