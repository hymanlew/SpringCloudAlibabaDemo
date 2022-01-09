package com.hyman.common.model.vo.line;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:zhanglichao
 * @Date:2021/3/25 15:25
 * @Description:
 */
@Data
public class LineShelfBusiOperLogVO implements Serializable {

    private static final long serialVersionUID = 1460734918756546462L;

    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String operType;

    /**
     * 操作类型名称
     */
    @ApiModelProperty(value = "操作类型名称")
    private String operTypeName;

    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    /**
     * 操作后状态
     */
    @ApiModelProperty(value = "操作后状态")
    private Integer afterState;

    /**
     * 操作后状态名称
     */
    @ApiModelProperty(value = "操作后状态名称")
    private String afterStateName;

    /**
     * 操作前状态名称
     */
    @ApiModelProperty(value = "操作前状态名称")
    private String beforeStateName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;


    @ApiModelProperty(value = "创建者ID")
    protected String createrName;

    @ApiModelProperty(value = "执行结果")
    private String result;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "创建时间")
    protected Date createDate;
}
