package com.hyman.common.model.dao.log;

import com.hyman.common.enums.BusiOperLogModuleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Changyuan Su
 * @date 2019-04-09 18:04:33
 * 操作日志
 */
@ApiModel("操作日志DO")
@Getter
@Builder
public class BusiOperLogDO {
    /**
     * 业务ID
     */
    @NotBlank
    @ApiModelProperty(value = "业务ID")
    private String businessId;

    /**
     * 模块
     */
    @NotNull
    @ApiModelProperty(value = "模块")
    private BusiOperLogModuleEnum module;

    /**
     * 操作类型
     */
    @NotBlank
    @ApiModelProperty(value = "操作类型")
    private String operType;

    /**
     * 操作描述
     */
    @Nullable
    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    /**
     * 操作后状态
     */
    @NotNull
    @ApiModelProperty(value = "操作后状态")
    private Integer afterState;

    /**
     * 备注
     */
    @Nullable
    @ApiModelProperty(value = "备注")
    private String remarks;


    /**
     * 创建者ID
     */
    @NotNull
    @ApiModelProperty(value = "创建者ID")
    private Long createId;

    /**
     * 操作结果
     */
    @Nullable
    @ApiModelProperty(value = "操作结果")
    private String result;
}
