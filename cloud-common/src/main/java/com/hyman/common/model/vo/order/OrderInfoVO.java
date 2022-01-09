package com.hyman.common.model.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hyman.common.model.vo.bill.OrderPayRecordInfoVO;
import com.hyman.common.model.vo.driver.DriverBusiInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author xiefujiang
 * @Classname OrderInfoVO
 * @Description
 * @Date 2020/7/7
 */
@Data
@ApiModel("订单信息vo")
public class OrderInfoVO implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    private Integer busiType;

    /**
     * 业务类型name
     */
    @ApiModelProperty(value = "业务类型name")
    private String busiTypeName;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private Integer status;

    /**
     * 订单状态name
     */
    @ApiModelProperty(value = "订单状态")
    private String statusName;

    /**
     * 备注，这里存放审核拒绝原因
     */
    @ApiModelProperty(value = "这里存放审核拒绝原因")
    private String remarks;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 司机姓名
     */
    @ApiModelProperty(value = "司机姓名")
    private String driverName;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private Integer city;

    /**
     * 合作模式(1购车 2租车 3带车)
     */
    @ApiModelProperty(value = "合作模式(1购车 2租车 3带车)")
    private Integer cooperationModel;

    /**
     * 合作模式(1购车 2租车 3带车)name
     */
    @ApiModelProperty(value = "合作模式(1购车 2租车 3带车)")
    private String cooperationModelName;

    /**
     * 创建来源,0-喜鹊，10云雀，20web
     */
    @ApiModelProperty(value = "创建来源,0-喜鹊，10云雀，20web")
    private Integer createSource;

    /**
     * 创建来源,0-喜鹊，10云雀，20web name
     */
    @ApiModelProperty(value = "创建来源,0-喜鹊，10云雀，20web name")
    private String createSourceName;

    /**
     * 是否交付，0为否，1为是
     */
    @ApiModelProperty(value = "是否交付，0为否，1为是")
    private Integer isDeliver;

    /**
     * 交付完成时间
     */
    @ApiModelProperty(value = "交付完成时间")
    private Date deliverDate;

    /**
     * 是否完成支付
     */
    @ApiModelProperty(value = "是否完成支付，0为否，1为是")
    private Integer isPay;

    /**
     * 支付完成时间
     */
    @ApiModelProperty(value = "支付完成时间")
    private Date payCompleteTime;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payType;

    /**
     * 支付方式 name
     */
    @ApiModelProperty(value = "支付方式")
    private String payTypeName;

    /**
     * 是否退款
     */
    @ApiModelProperty(value = "是否退款")
    private Integer isRefund;

    /**
     * 退款时间
     */
    @ApiModelProperty(value = "退款时间")
    private Date refundTime;

    /**
     * 合作期限（月）
     */
    @ApiModelProperty(value = "合作期限（月）")
    private Integer cooperationTime;

    /**
     * 收入保障
     */
    @ApiModelProperty(value = "收入保障")
    private BigDecimal incomeGuarantee;

    /**
     * 抽佣比例(%)
     */
    @ApiModelProperty(value = "抽佣比例(%)")
    private Double rake;

    /**
     * 商品金额
     */
    @ApiModelProperty(value = "商品金额")
    private BigDecimal goodsAmount;

    /**
     * 已支付金额
     */
    private BigDecimal havePayAmount;

    /**
     * 年检有效期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "年检有效期")
    private Date inspectionTime;

    /**
     * 保险有效期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "保险有效期")
    private Date insuranceTime;

    /**
     * 供应商
     */
    @ApiModelProperty(value = "供应商")
    private String supplier;

    /**
     * 车辆型号
     */
    @ApiModelProperty(value = "车辆型号")
    private String carModel;


    /**
     *车辆信息
     */
    @ApiModelProperty(value = "车辆信息")
    private String carMessage;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String productId;

    /**
     * 合作车型
     */
    @ApiModelProperty(value = "合作车型")
    private Integer cooperationCar;

    @ApiModelProperty(value = "合作车型中文")
    private String cooperationCarName;

    /**
     * 无税车价
     */
    @ApiModelProperty(value = "无税车价")
    private BigDecimal carPrice;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String plateNo;

    /**
     * 运力配额
     */
    @ApiModelProperty(value = "运力配额")
    private Integer capacityQuota;

    /**
     * 订单确认人
     */
    @ApiModelProperty(value = "订单确认人")
    private Integer confirmId;

    /**
     * 订单确认人姓名
     */
    @ApiModelProperty(value = "订单确认人姓名")
    private String confirmName;

    /**
     * 订单确认时间
     */
    @ApiModelProperty(value = "订单确认时间")
    private Date confirmTime;

    /**
     * 审核不通过人
     */
    @ApiModelProperty(value = "审核不通过人")
    private Integer notPassId;

    /**
     * 审核不通过人姓名
     */
    @ApiModelProperty(value = "审核不通过人姓名")
    private String notPassName;

    /**
     * 审核不通过时间
     */
    @ApiModelProperty(value = "审核不通过时间")
    private Date notPassTime;

    /**
     * 审核通过人
     */
    @ApiModelProperty(value = "审核通过人")
    private Integer passId;

    /**
     * 审核通过人姓名
     */
    @ApiModelProperty(value = "审核通过人姓名")
    private String passName;

    /**
     * 审核通过时间
     */
    @ApiModelProperty(value = "审核通过时间")
    private Date passTime;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private Integer createId;

    /**
     * 创建者姓名
     */
    @ApiModelProperty(value = "创建者姓名")
    private String createName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 截至时间
     */
    @ApiModelProperty(value = "截至时间，毫秒")
    private Long terminationTime;

    /**
     * 最后一次修改人员
     */
    @ApiModelProperty(value = "最后一次修改人员")
    private Integer updateId;

    /**
     * 最后一次修改人员姓名
     */
    @ApiModelProperty(value = "最后一次修改人员姓名")
    private String updateName;

    /**
     * 最后一次修改时间
     */
    @ApiModelProperty(value = "最后一次修改时间")
    private Date updateDate;

    /**
     * 操作标识
     */
    @ApiModelProperty(value = "操作标识 creat订单创建  cancel订单手动取消 ,小程序需要confirm订单确认,auditPass审核通过 auditNotPass 审核不通过  rePay订单再支付，resubmitAndCommit重新提交")
    private String operateFlag;

    /**
     * 订单支付记录
     */
    @ApiModelProperty(value = "订单支付记录")
    private List<OrderPayRecordInfoVO> orderPayRecordInfoVOList;

    /**
     * 司机信息
     */
    @ApiModelProperty(value = "司机信息")
    private DriverBusiInfoVO driverInfoVO;

    @ApiModelProperty(value = "合同状态")
    private Integer contractStatus;

    @ApiModelProperty(value = "专车购车是否全藏")
    private Boolean allHide;

    @ApiModelProperty(value = "重新提交时间")
    private Date resubmitDate;

    @ApiModelProperty(value = "重新提交人")
    private String resubmitName;

    @ApiModelProperty(value = "订单终止时间")
    private Date abortTime;

    @ApiModelProperty(value = "订单终止人")
    private String abortName;

    @ApiModelProperty(value = "订单终止原因")
    private String orderTerminationReasons;

    @ApiModelProperty(value = "订单终止原因")
    private String orderTerminationReasonsName;

    @ApiModelProperty(value = "合同编号")
    private String contractId;

}
