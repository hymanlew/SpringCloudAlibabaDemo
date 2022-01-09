package com.hyman.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date: 2018/5/19 15:26
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliyunOSSResult {
    @ApiModelProperty(value = "返回Key值")
    private String key;
    @ApiModelProperty(value = "文件名称")
    private String name;
    @ApiModelProperty(value = "文件访问URL")
    private String url;
    @ApiModelProperty(value = "Hash值")
    private String hash;
}
