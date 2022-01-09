package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 梧桐司机-自承运 打标签(免抽佣，免押金)
 *
 * @author hucl
 * @date 2020/11/18 14:33
 */
@Getter
@Setter
@ApiModel
@ToString
public class WTDriverLabelSyncDTO implements Serializable {
    private static final long serialVersionUID = 3809519827575074915L;

    @ApiModelProperty(value = "梧桐司机ID")
    @NotEmpty(message = "梧桐司机ID不能为空")
    private String driverId;

    @ApiModelProperty(value = "自承运司机ID，7位数字")
    @NotNull(message = "自承运司机ID不能为空")
    private String otherDriverId;

    @ApiModelProperty(value = "梧桐司机业务线：0专车，1共享")
    @NotNull(message = "梧桐司机业务线不能为空")
    private Integer businessLine;


}
