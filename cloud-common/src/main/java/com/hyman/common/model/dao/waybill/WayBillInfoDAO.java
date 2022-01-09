package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "way_bill_info")
public class WayBillInfoDAO implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 运单编号
     */
    @Column(name = "way_bill_id")
    private String wayBillId;

    /**
     * 运单名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 试跑在跑编号
     */
    @Column(name = "test_run_id")
    private String testRunId;

    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 司机id
     */
    @Column(name = "driver_id")
    private String driverId;

    /**
     * 线路id
     */
    @Column(name = "line_id")
    private String lineId;

    /**
     * 线路的每日趟数
     */
    @Column(name = "day_num")
    private Integer dayNum;

    /**
     * 上岗经理id
     */
    @Column(name = "duty_manager_id")
    private Integer dutyManagerId;

    /**
     * 加盟经理id
     */
    @Column(name = "gm_id")
    private Integer gmId;

    /**
     * 出车日期
     */
    @Column(name = "departure_date")
    private Date departureDate;

    /**
     * 运单金额
     */
    @Column(name = "way_bill_money")
    private BigDecimal wayBillMoney;

    /**
     * 总的状态，初始值为0，待确认>已确认>二次待确认>二次已确认
     */
    @Column(name = "status")
    private Integer status;

    @Column(name = "gmc_is_no_car")
    private Integer gmcIsNoCar;

    /**
     * 加盟侧状态
     */
    @Column(name = "gm_status")
    private Integer gmStatus;

    /**
     * 外线侧状态
     */
    @Column(name = "line_status")
    private Integer lineStatus;

    @Column(name = "gm_report_id")
    private Integer gmReportId;
    @Column(name = "gm_report_date")
    private Date gmReportDate;
    @Column(name = "line_report_id")
    private Integer lineReportId;
    @Column(name = "line_report_date")
    private Date lineReportDate;
    @Column(name = "confirm_id")
    private Integer confirmId;
    @Column(name = "confirm_date")
    private Date confirmDate;
    @Column(name = "again_confirm_id")
    private Integer againConfirmId;
    @Column(name = "again_confirm_date")
    private Date againConfirmDate;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "again_is_no_car")
    private Integer againIsNoCar;
}