package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "time_project_info")
public class TimeProjectInfoDAO {
    @Id
    private Integer id;

    /**
     * 项目周报id
     */
    @Column(name = "time_project_id")
    private String timeProjectId;

    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 名称
     */
    private String name;

    /**
     * 开始时间
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束时间
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 外线销售id
     * 上岗经理id
     */
    @Column(name = "duty_manager_id")
    private Integer dutyManagerId;

    /**
     * description:
     * param: 运单数
     * return:
     * author  hyman
     * createTime: 2020/9/1
     */
    @Column(name = "way_bill_num")
    private Integer wayBillNum;

    /**
     * description:
     * param: 已上报数
     * return:
     * author  hyman
     * createTime: 2020/9/1
     */
    @Column(name = "line_reported_num")
    private Integer lineReportedNum;

    /**
     * description:
     * param: 外线上报累计金额
     * return:
     * author  hyman
     * createTime: 2020/9/1
     */
    @Column(name = "line_reported_money")
    private BigDecimal lineReportedMoney;

    @Column(name = "create_date")
    private Date createDate;
}