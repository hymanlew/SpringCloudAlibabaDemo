package com.hyman.common.model.form.bill;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("创建账户信息对象")
@Data
public class AcctInfoAddForm {

    @NotNull(message = "账户类型不能为空")
    @ApiModelProperty(value = "账户类型(1个人账户 2组织账户)", required = true)
    private Integer acctType;

    @NotNull(message = "用户编号不能为空")
    @ApiModelProperty(value = "用户编号", required = true)
    private String userId;

    @ApiModelProperty(value = "账户状态(1待激活 2正常 3冻结)", required = true)
    private Integer acctStatus = 2;

    @ApiModelProperty(value = "生效时间，为空则默认当前时间", required = false)
    private Date effectDate = new Date();

    @ApiModelProperty(value = "失效时间，为空则默认永久生效", required = false)
    private Date expireDate = DateUtil.parseDate("9999-01-01");

}
