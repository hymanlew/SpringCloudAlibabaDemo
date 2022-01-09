package com.hyman.common.model.dto.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Changyuan Su
 * @date 2019/11/18 下午2:30
 * @Description:
 */
@NoArgsConstructor
@Data
public class WechatSendSubscribeMessageDTO implements Serializable {
    private static final long serialVersionUID = 2428762631730540677L;


    /**
     * touser : OPENID
     * template_id : TEMPLATE_ID
     * page : index
     * data : {"number01":{"value":"339208499"},"date01":{"value":"2015年01月05日"},"site01":{"value":"TIT创意园"},"site02":{"value":"广州市新港中路397号"}}
     */


    @NotBlank
    @ApiModelProperty(name = "接收者（用户）的 openid", required = true, dataType = "String")
    private String touser;
    @NotBlank
    @ApiModelProperty(name = "所需下发的订阅模板id", required = true, dataType = "String")
    @JsonProperty("template_id")
    private String templateId;

    @Nullable
    @ApiModelProperty(name = "点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转", required = false, dataType = "String")
    private String page;

    @Size(min = 1)
    @NotNull
    @ApiModelProperty(name = "模板内容，格式形如 { \"key1\": { \"value\": any }, \"key2\": { \"value\": any } }", required = true)
    private Map<String, Object> data;

}
