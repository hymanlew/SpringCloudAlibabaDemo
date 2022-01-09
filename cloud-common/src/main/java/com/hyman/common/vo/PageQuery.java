package com.hyman.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author
 * @Date: 2018/5/17 09:48
 * @Description:
 */
@Data
public class PageQuery {
    //当前页码
    @ApiModelProperty(value = "页号 默认1",required=false)
    private int page = 1;
    //每页条数
    @ApiModelProperty(value = "页大小 默认100",required=false)
    private int limit = 100;

    @ApiModelProperty(value = "用于sql查询，当前页起始条数",required=false)
    private int pageNumber=0;

}
