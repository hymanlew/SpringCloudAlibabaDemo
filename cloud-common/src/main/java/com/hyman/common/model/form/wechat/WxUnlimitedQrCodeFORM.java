package com.hyman.common.model.form.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel("小程序无限制二维码接口入参")
public class WxUnlimitedQrCodeFORM {

    @ApiModelProperty(value = "二维码类型")
    @NotBlank(message = "二维码类型不能为空")
    private String type;

    @ApiModelProperty(value = "页面路径")
    @NotBlank(message = "页面路径不能为空")
    private String page;

    @ApiModelProperty(value = "页面参数")
    @NotBlank(message = "页面参数不能为空")
    private String pageParam;

    @ApiModelProperty(value = "二维码的宽度，单位 px")
    @NotNull(message = "二维码的宽度不能为空")
    private Integer width;

    @ApiModelProperty(value = "是否需要透明底色")
    @NotNull(message = "是否需要透明底色不能为空")
    private Boolean ishyaline;

    @ApiModelProperty(value = "过期时间")
    private Date expireDate;

    @ApiModelProperty(value = "业务类型")
    @NotNull(message = "业务类型不能为空")
    private Integer busiType;

}