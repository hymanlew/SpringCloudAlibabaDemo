package com.hyman.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * @Date: 2018/5/17 10:32
 * @Description:
 */
@Getter
@Setter
public class BooleanResult {
    /**
     * 返回结果成功失败标志
     */
    @ApiModelProperty(value = "返回结果标志(true:成功，false:失败)",required=false,example = "true")
    public boolean success;

    @ApiModelProperty(value = "处理失败时的备注",required=false)
    public String memo;

    public BooleanResult() {

    }

    public BooleanResult(boolean success) {
        this.success = success;
    }

    public BooleanResult(boolean success, String memo) {
        this.success = success;
        this.memo = memo;
    }
}
