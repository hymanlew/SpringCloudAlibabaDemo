package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiahao
 * @date 2020-04-14
 **/
@Data
@ApiModel("查看撮合跟进记录信息 出参")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchingDriverHistoryDTO implements Serializable {

    private static final long serialVersionUID = 2403663962133165931L;

    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private Integer id;

    /**
     * 司机id
     */
    @ApiModelProperty(value="司机id")
    private String driverId;

    /**
     * 线路id
     */
    @ApiModelProperty(value="线路id")
    private String lineId;

    /**
     * 跟进状态
     */
    @ApiModelProperty(value="跟进状态")
    private Integer state;

    /**
     * 跟进状态备注
     */
    @ApiModelProperty(value="跟进状态备注")
    private String remark;

    /**
     * 跟进人id
     */
    @ApiModelProperty(value="跟进人id")
    private Long createId;

    /**
     * 跟进时间
     */
    @ApiModelProperty(value="跟进时间")
    private Date createDate;
}
