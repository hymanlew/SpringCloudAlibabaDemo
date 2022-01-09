package com.hyman.common.model.dao.line;

import com.hyman.common.model.dao.BaseDAO;
import lombok.Data;

import javax.persistence.Column;

@Data
public class LineCloudProjectCommonDAO extends BaseDAO {


    /**
     * 项目编号
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * crm系统唯一标识
     */
    @Column(name = "crm_id")
    private String crmId;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 客户编号
     */
    @Column(name = "customer_id")
    private String customerId;

    /**
     * 线索编号
     */
    @Column(name = "clue_id")
    private String clueId;

    /**
     * 线索名称
     */
    @Column(name = "clue_name")
    private String clueName;

    /**
     * 项目联系人名称
     */
    @Column(name = "bussiness_name")
    private String bussinessName;

    /**
     * 项目联系人电话
     */
    @Column(name = "bussiness_phone")
    private String bussinessPhone;

    /**
     * 审核状态;1待审核,2审核通过
     */
    @Column(name = "audit_state")
    private Integer auditState;

    /**
     * 项目状态;1禁用,2启用
     */
    @Column(name = "project_state")
    private Integer projectState;

    /**
     * 城市
     */
    private Integer city;

    /**
     * 外线销售
     */
    @Column(name = "line_sale_id")
    private Integer lineSaleId;

    /**
     * 上岗经理
     */
    @Column(name = "duty_manager_id")
    private Integer dutyManagerId;

    /**
     * 收货点类型
     */
    @Column(name = "receiving_point")
    private Integer receivingPoint;

    /**
     * 总线路数
     */
    @Column(name = "line_num")
    private Integer lineNum;

    /**
     * 有效线路
     */
    @Column(name = "effective_line_num")
    private Integer effectiveLineNum;

    /**
     * 再跑线路
     */
    @Column(name = "run_line_num")
    private Integer runLineNum;

    /**
     * 仓名称
     */
    @Column(name = "warehouse_name")
    private String warehouseName;

    /**
     * 仓联系人
     */
    @Column(name = "warehouse_contact_name")
    private String warehouseContactName;

    /**
     * 仓联系人电话
     */
    @Column(name = "warehouse_contact_phone")
    private String warehouseContactPhone;

    /**
     * 仓开放时间
     */
    @Column(name = "warehouse_open")
    private String warehouseOpen;

    /**
     * 仓关闭时间
     */
    @Column(name = "warehouse_close")
    private String warehouseClose;

    /**
     * 仓位置-省
     */
    @Column(name = "warehouse_province")
    private Integer warehouseProvince;

    /**
     * 仓位置-市
     */
    @Column(name = "warehouse_city")
    private Integer warehouseCity;

    /**
     * 仓位置-区、县
     */
    @Column(name = "warehouse_county")
    private Integer warehouseCounty;

    /**
     * 仓详细地址
     */
    @Column(name = "warehouse_district")
    private String warehouseDistrict;

    /**
     * 仓备注
     */
    @Column(name = "warehouse_remark")
    private String warehouseRemark;

    /**
     * 是否走高速（1：是 2：否）
     */
    @Column(name = "run_speed")
    private Integer runSpeed;

    /**
     * 配送经验：（1 有需求，2 无需求）
     */
    @Column(name = "is_delivery")
    private Integer isDelivery;

    /**
     * 是否需要回单;1:是 ,2:否
     */
    @Column(name = "return_bill")
    private Integer returnBill;

    /**
     * 配送车型
     */
    @Column(name = "car_type")
    private Integer carType;

    /**
     * 配送点数量
     */
    @Column(name = "delivery_num")
    private Integer deliveryNum;

    /**
     * 配送总里程
     */
    private Integer distance;

    /**
     * 预计工作时长_总和
     */
    @Column(name = "time_diff")
    private String timeDiff;

    /**
     * 限行区域说明
     */
    @Column(name = "limit_remark")
    private String limitRemark;

    /**
     * 货物类型
     */
    @Column(name = "cargo_type")
    private Byte cargoType;

    /**
     * 货物件数
     */
    @Column(name = "cargo_num")
    private Integer cargoNum;

    /**
     * 是否搬运;1,是;2,否
     */
    private Integer carry;

    /**
     * 其它上岗要求
     */
    @Column(name = "duty_remark")
    private String dutyRemark;


    /**
     * 数据迁移（老梧桐数据线路表中的线路编号）
     */
    @Column(name = "old_project_id")
    private String oldProjectId;

    /**
     * 是否返仓
     */
    @Column(name = "return_warehouse")
    private Integer returnWarehouse;

    /**
     * 装卸难度
     */
    @Column(name = "handling_difficulty")
    private Integer handlingDifficulty;

    /**
     * 是否拜访
     */
    @Column(name = "is_visit")
    private Integer isVisit;

}