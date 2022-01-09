package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("线路云-项目详情")
public class LineCloudProjectVO {

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private String projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    private String projectName;

    /**
     * 客户编号
     */
    @ApiModelProperty("客户编号")
    private String customerId;

    /**
     * 客户名称
     */
    @ApiModelProperty("客户名称")
    private String customerName;

    /**
     * 客户名称
     */
    @ApiModelProperty("客户手机号_ 额外提供")
    private String customerPhone;

    /**
     * 线索编号
     */
    @ApiModelProperty("线索编号")
    private String clueId;

    /**
     * 线索名称
     */
    @ApiModelProperty("线索名称")
    private String clueName;

    /**
     * 审核状态;1待审核,2审核通过
     */
    @ApiModelProperty("审核状态;1待审核,2审核通过")
    private Integer auditState;


    /**
     * 项目状态;1禁用,2启用
     */
    @ApiModelProperty("项目状态;1禁用,2启用")
    private Integer projectState;

    /**
     * 上岗经理
     */
    @ApiModelProperty("上岗经理 id")
    private Integer dutyManagerId;

    /**
     * 上岗经理名称
     */
    @ApiModelProperty("上岗经理名称")
    private String dutyManagerName;

    /**
     * 外线销售ID
     */
    @ApiModelProperty("外线销售ID")
    private Integer lineSaleId;

    /**
     * 外线销售名称
     */
    @ApiModelProperty("外线销售名称")
    private String lineSaleName;

    /**
     * 所属城市
     */
    @ApiModelProperty("所属城市code")
    private Integer city;

    /**
     * 所属城市名称
     */
    @ApiModelProperty("所属城市名称")
    private String cityName;

    /**
     * 项目联系人名称
     */
    @ApiModelProperty("项目联系人名称")
    private String bussinessName;

    /**
     * 项目联系人电话
     */
    @ApiModelProperty("项目联系人电话")
    private String bussinessPhone;


    /**
     * 收货点类型
     */
    @ApiModelProperty("收货点类型")
    private Integer receivingPoint;

    /**
     * 收货点类型名称
     */
    @ApiModelProperty("收货点类型名称")
    private String receivingPointName;

    /**
     * 总线路数
     */
    @ApiModelProperty("总线路数")
    private Integer lineNum;

    /**
     * 有效线路
     */
    @ApiModelProperty("有效线路")
    private Integer effectiveLineNum;

    /**
     * 再跑线路
     */
    @ApiModelProperty("再跑线路")
    private Integer runLineNum;


    /**
     * 仓名称
     */
    @ApiModelProperty("仓名称")
    private String warehouseName;

    /**
     * 仓联系人
     */
    @ApiModelProperty("仓联系人")
    private String warehouseContactName;

    /**
     * 仓联系人电话
     */
    @ApiModelProperty("仓联系人电话")
    private String warehouseContactPhone;

    /**
     * 仓开放时间
     */
    @ApiModelProperty("仓开放时间")
    private String warehouseOpen;

    /**
     * 仓关闭时间
     */
    @ApiModelProperty("仓关闭时间")
    private String warehouseClose;

    /**
     * 仓位置-省
     */
    @ApiModelProperty("仓位置-省")
    private Integer warehouseProvince;
    /**
     * 仓位置-省名称
     */
    @ApiModelProperty("仓位置-省名称")
    private String warehouseProvinceName;


    /**
     * 仓位置-市
     */
    @ApiModelProperty("仓位置-市名称")
    private String warehouseCityName;

    /**
     * 仓位置-市
     */
    @ApiModelProperty("仓位置-市")
    private Integer warehouseCity;

    /**
     * 仓位置-区、县
     */
    @ApiModelProperty("仓位置-区、县")
    private Integer warehouseCounty;
    /**
     * 仓位置-区、县
     */
    @ApiModelProperty("仓位置-区、县名称")
    private String warehouseCountyName;

    /**
     * 仓详细地址
     */
    @ApiModelProperty("仓详细地址")
    private String warehouseDistrict;

    /**
     * 仓备注
     */
    @ApiModelProperty("仓备注")
    private String warehouseRemark;

    /**
     * 是否走高速（1：是 2：否）
     */
    @ApiModelProperty("是否走高速（1：是 2：否）")
    private Integer runSpeed;

    /**
     * 是否需要回单;1:是 ,2:否
     */
    @ApiModelProperty("是否需要回单;1:是 ,2:否")
    private Integer returnBill;

    /**
     * 配送车型
     */
    @ApiModelProperty("配送车型")
    private Integer carType;

    /**
     * 配送车型
     */
    @ApiModelProperty("配送车型名称")
    private String carTypeName;

    /**
     * 配送经验：（1 有需求，2 无需求）
     */
    @ApiModelProperty("配送经验：（1 有需求，2 无需求）")
    private Integer isDelivery;
    /**
     * 配送点数量
     */
    @ApiModelProperty("配送点数量")
    private Integer deliveryNum;

    /**
     * 配送总里程
     */
    @ApiModelProperty("配送总里程")
    private Integer distance;

    /**
     * 预计工作时长_总和
     */
    @ApiModelProperty("预计工作时长_总和")
    private String timeDiff;

    @ApiModelProperty("预计工作时长")
    List<LineProjectWorkerVO> lineProjectWorkerVOS;

    /**
     * 限行区域说明
     */
    @ApiModelProperty("限行区域说明")
    private String limitRemark;

    /**
     * 货物类型
     */
    @ApiModelProperty("货物类型")
    private Integer cargoType;

    /**
     * 货物类型
     */
    @ApiModelProperty("货物类型名称")
    private String cargoTypeName;

    /**
     * 货物件数
     */
    @ApiModelProperty("货物件数")
    private Integer cargoNum;

    /**
     * 是否搬运;1,是;2,否
     */
    @ApiModelProperty("是否搬运;1,是;2,否")
    private Integer carry;

    /**
     * 其它上岗要求
     */
    @ApiModelProperty("其它上岗要求")
    private String dutyRemark;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Integer createId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private Integer updateId;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateDate;

    /**
     * 装卸要求
     */
    @ApiModelProperty(value = "装卸要求")
    private Integer handlingDifficulty;

    /**
     * 装卸要求中文
     */
    @ApiModelProperty(value = "装卸要求中文")
    private String handlingDifficultyName;

    /**
     * 是否需要返仓（1是 2否）
     */
    @ApiModelProperty(value = "是否需要返仓（1是 2否）")
    private Integer returnWarehouse;

    /**
     * 是否需要返仓中文
     */
    @ApiModelProperty(value = "是否需要返仓中文")
    private String returnWarehouseName;

}