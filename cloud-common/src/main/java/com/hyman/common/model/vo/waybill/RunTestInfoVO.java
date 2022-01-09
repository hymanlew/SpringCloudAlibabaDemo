package com.hyman.common.model.vo.waybill;

import com.hyman.common.model.vo.driver.DriverBusiInfoVO;
import com.hyman.common.model.vo.line.LineInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/8/27
 */
@Data
@ApiModel("试跑在跑vo")
public class RunTestInfoVO implements Serializable {

    private static final long serialVersionUID = 5295268110026850461L;
    /**
     * 自增ID
     */
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 试跑在跑编号
     */
    @ApiModelProperty(value = "试跑在跑编号")
    private String runTestId;


    /**
     * 试跑在跑状态
     */
    @ApiModelProperty(value = "试跑在跑状态")
    private Integer status;

    /**
     * 线路编号
     */
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private Integer createId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 最后一次修改人员
     */
    @ApiModelProperty(value = "最后一次修改人员")
    private Integer updateId;

    /**
     * 最后一次修改时间
     */
    @ApiModelProperty(value = "最后一次修改时间")
    private Date updateDate;

    /**
     * 删除标识（0：不存在，1：存在）
     */
    @ApiModelProperty(value = "删除标识（0：不存在，1：存在）")
    private Integer delFlag;

    /**
     * 掉线时间
     */
    @ApiModelProperty(value = "掉线时间")
    private Date droppedTime;

    /**
     * 线路快照 id
     */
    @ApiModelProperty(value = "线路快照 id")
    private String lineSnapshotId;

    /**
     * 司机信息快照 id
     */
    @ApiModelProperty(value = "司机信息快照 id")
    private String driverSnapshotId;

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String orderId;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    private Integer busiType;

    /**
     * 补录标志
     */
    @ApiModelProperty(value = "补录标志")
    private Integer makeUpFlag;

    /**
     * 配送开始时间
     */
    @ApiModelProperty(value = "配送开始时间")
    private Date deliveryStartDate;

    /**
     * 配送结束时间
     */
    @ApiModelProperty(value = "配送结束时间")
    private Date deliveryEndDate;

    /**
     * 试跑在跑记录
     */
    @ApiModelProperty(value = "试跑在跑记录VO")
    private List<RunTestStatusRecordVO> runTestStatusRecordVOList;

    /**
     * 司机详情
     */
    @ApiModelProperty(value = "司机详情")
    private DriverBusiInfoVO driverBusiInfoVO;

    /**
     * 线路详情
     */
    @ApiModelProperty(value = "线路详情")
    private LineInfoVO lineInfoVO;


    /**
     * 是否发送过岗前叮嘱短信 0 未发送 1 已发送
     */
    private Integer haveSendMessage;

    /**
     * 线路类型
     */
    @ApiModelProperty(value = "线路分类 1:稳定线路  2：临时线路")
    private Integer lineCategory;

    /**
     *是否发送跟车短信
     */
    @ApiModelProperty(value = "是否发送跟车短信 默认为0 未发送 1已发送")
    private Integer haveSendFollowCarMessage;

    @ApiModelProperty(value = "撮合单编号")
    private String matchId;
}
