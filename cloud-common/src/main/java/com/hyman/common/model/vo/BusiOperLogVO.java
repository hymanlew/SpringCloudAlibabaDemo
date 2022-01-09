package com.hyman.common.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Changyuan Su
 * @date 2019/3/23 13:42
 * @Description: 标书操作记录VO
 */
@Data
public class BusiOperLogVO implements Serializable {

    private static final long serialVersionUID = 1460734918756546462L;

    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String operType;

    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    /**
     * 操作后状态
     */
    @ApiModelProperty(value = "操作后状态")
    private String afterState;

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
