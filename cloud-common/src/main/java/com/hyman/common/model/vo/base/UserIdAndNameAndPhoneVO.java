package com.hyman.common.model.vo.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Splitter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tc
 * @date 2019-12-05
 * @Description:
 */
@ApiModel("用户id、姓名、手机号VO")
@Data
public class UserIdAndNameAndPhoneVO implements Serializable {

    private static final long serialVersionUID = -9059780080055930129L;

    @ApiModelProperty("用户编号")
    private String userId;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("用户拥有的城市权限，null或空代表拥有全部城市权限")
    private String cities;

    public Set<String> getCitySet() {
        return StringUtils.isNotBlank(cities) ? new HashSet<String>(Splitter.on(',').omitEmptyStrings().splitToList(cities)) : null;
    }

    @JsonIgnoreProperties
    private Set<String> citySet;

}
