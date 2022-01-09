package com.hyman.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: tianchong
 * @Date: 2018/5/16 16:41
 * @Description:
 */
@Getter
@NoArgsConstructor
@ApiModel("分页对象【Page】")
public class Page implements Serializable {
    private static final long serialVersionUID = -5697359585041976881L;
    @ApiModelProperty(value = "页号 默认1")
    private Integer page;
    @ApiModelProperty(value = "每页条数 默认10")
    private Integer limit = 10;
    @ApiModelProperty(value = "总条数")
    private Long total;

    public Page(Integer page, Integer limit, Long total) {
        this.page = (page == null || page.intValue() < 1) ? 1 : page;
        this.limit = limit;
        this.total = total;
    }

    public void setPage(Integer page) {
        this.page = (page == null || page.intValue() < 1) ? 1 : page;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
