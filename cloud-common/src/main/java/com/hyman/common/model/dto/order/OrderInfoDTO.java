package com.hyman.common.model.dto.order;

import com.hyman.common.model.dto.bill.OrderPayRecordInfoDTO;
import com.hyman.common.model.dto.driver.DriverInfoBusiDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @Classname OrderInfoDTO
 * @Description
 * @Date 2020/7/7
 * @Created by xiefujiang
 */

@Data
@ApiModel("订单信息")
public class OrderInfoDTO implements Serializable {

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
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private Integer state;

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
     * 创建来源,0-喜鹊，10云雀，20web
     */
    @ApiModelProperty(value = "创建来源,0-喜鹊，10云雀，20web")
    private Integer createSource;

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
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payType;

    /**
     * 支付完成时间
     */
    @ApiModelProperty(value = "支付完成时间")
    private Date payCompleteTime;

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
    @ApiModelProperty(value = "年检有效期")
    private Date inspectionTime;

    /**
     * 保险有效期
     */
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
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String productId;

    /**
     * 合作车型
     */
    @ApiModelProperty(value = "合作车型")
    private Integer cooperationCar;

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
     * 操作标识
     */
    @ApiModelProperty(value = "操作标识 creat订单创建  cancel订单手动取消 ,小程序需要confirm订单确认,auditPass审核通过 auditNotPass 审核不通过  rePay订单再支付")
    private String operateFlag;

    /**
     * 订单支付记录
     */
    @ApiModelProperty(value = "订单支付记录")
    private List<OrderPayRecordInfoDTO> orderPayRecordInfoDTOList;

    /**
     * 司机信息
     */
    @ApiModelProperty(value = "司机信息")
    private DriverInfoBusiDTO driverInfoDTO;

}

