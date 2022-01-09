package com.hyman.common.model.dao.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Authorzhanglichao
 * @Date 2021-05-08 10:25
 * @description 项目拜访记录实体对应DAO
 */
@Data
public class LineManagerVisitProjectCommonDAO {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    protected Long id;

    /**
     * 项目编号
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 拜访目的
     */
    @Column(name = "visit_purpose")
    private Integer visitPurpose;

    /**
     * 拜访对象
     */
    @Column(name = "visit_object")
    private Integer visitObject;

    /**
     * 项目已上车数
     */
    @Column(name = "project_car_num")
    private Integer projectCarNum;

    /**
     * 已上车司机状态
     */
    @Column(name = "driver_status")
    private String driverStatus;

    /**
     * 客户意见
     */
    @Column(name = "customer_opinion")
    private String customerOpinion;

    /**
     * 线路余额数
     */
    @Column(name = "line_balance_num")
    private Integer lineBalanceNum;

    /**
     * 客户用车车型
     */
    @Column(name = "customer_car_model")
    private String customerCarModel;

    /**
     * 客户用车车型
     */
    @ApiModelProperty(value = "客户用车车型")
    @Column(name = "car_type")
    private Integer carType;


    /**
     * 客户用车数量
     */
    @Column(name = "customer_car_num")
    private Integer customerCarNum;

    /**
     * 急需处理问题
     */
    @Column(name = "urgent_problem")
    private String urgentProblem;

    /**
     * 删除状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 其他
     */
    @Column(name = "other")
    private String other;


    /**
     * 仓库图片url
     */
    @Column(name = "visit_picture_url")
    private String visitPictureUrl;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;

    /**
     * 地理位置
     */
    @Column(name = "geographical_position")
    private String geographicalPosition;


    /**
     * 创建者ID
     */
    @Column(name = "`create_id`")
    @ApiModelProperty(value = "创建者ID")
    protected Long createId;

    /**
     * 创建时间
     */
    @Column(name = "`create_date`")
    @ApiModelProperty(value = "创建时间")
    protected Date createDate;

    /**
     * 最后一次修改人员
     */
    @Column(name = "`update_id`")
    @ApiModelProperty(value = "最后一次修改人员")
    protected Long updateId;

    /**
     * 最后一次修改时间
     */
    @Column(name = "`update_date`")
    @ApiModelProperty(value = "最后一次修改时间")
    protected Date updateDate;

    /**
     * 线路渗透数
     */
    @Column(name = "penetration_number")
    private Integer penetrationNumber;

    /**
     * 线路渗透备注
     */
    @Column(name = "penetration_remark")
    private String penetrationRemark;

}
