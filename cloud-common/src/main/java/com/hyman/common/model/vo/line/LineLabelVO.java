package com.hyman.common.model.vo.line;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @description: LineLabelVO <br>
 * @date: 2020/11/2 9:45 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel(value = "线路标签VO")
@Builder
public class LineLabelVO {
    
    @ApiModelProperty(value = "id")
    private Long id;
    
    @ApiModelProperty(value = "城市名字")
    private String cityName;
    
    @ApiModelProperty(value = "城市code")
    private Integer cityCode;
    
    @ApiModelProperty(value = "专车标签名")
    private String[] sepcialName;
    
    @ApiModelProperty(value = "专车标签code")
    private String[] sepcialCode;
    
    @ApiModelProperty(value = "共享标签名")
    private String[] shareName;
    
    @ApiModelProperty(value = "共享标签code")
    private String[] shareCode;
    
    @ApiModelProperty(value = "调整人")
    private String person;
    
    @ApiModelProperty(value = "调整时间")
    private Date time;
    
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private Long updateId;
}
