package com.hyman.common.model.dto.line;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/3/5 15:03
 * @Description: 线路任务
 */
@Data
public class LineTaskDetailDTO extends BaseDAO implements Serializable {

    private static final long serialVersionUID = 2628777302772224714L;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 线路名称
     */
    @ApiModelProperty(value = "线路名称")
    private String lineName;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private Integer carType;

    /**
     * 预计工作时间起始
     */
    @ApiModelProperty(value = "预计工作时间起始")
    private String workingTimeStart;

    /**
     * 预计工作时间截止
     */
    @ApiModelProperty(value = "预计工作时间截止")
    private String workingTimeEnd;

    @ApiModelProperty(value = "城市")
    private Integer city;

    @ApiModelProperty(value = "城市名称")
    private String cityName;

    @ApiModelProperty(value = "接收创建线路任务的创建者姓名")
    private String name;

    @ApiModelProperty("客户编号")
    private String customerId;

}
