package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yantao
 * @Date 2021/1/20 11:29
 */
@Data
@Builder
public class DriverUpdateStatusInnersDTO implements Serializable {

    private static final long serialVersionUID = -7551898891438250504L;

    @NotNull
    @ApiModelProperty(value = "司机id")
    private String driverId;

    @NotNull
    @ApiModelProperty(value = "状态")
    private Integer status;

    @NotNull
    @ApiModelProperty(value = "操作人id")
    private Long userId;

    @Nullable
    @ApiModelProperty(value = "操作原因")
    private String operType;


}
