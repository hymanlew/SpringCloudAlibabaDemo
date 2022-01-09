package com.hyman.common.model.dao.log;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Changyuan Su 2019/03/15
 */
@ApiModel(value = "com.hyman.common.model.dao.log.BusiOperLogDAO")
@Data
@Table(name = "`busi_oper_log`")
public class BusiOperLogDAO implements Serializable {
    private static final long serialVersionUID = 2544221563169767974L;
    /**
     * 业务ID
     */
    @Column(name = "`business_id`")
    @ApiModelProperty(value = "业务ID")
    private String businessId;

    /**
     * 模块(order:订单 customer:客户)
     */
    @Column(name = "`module`")
    @ApiModelProperty(value = "模块(order:订单 customer:客户)")
    private String module;

    /**
     * 操作类型
     */
    @Column(name = "`oper_type`")
    @ApiModelProperty(value = "操作类型")
    private String operType;

    /**
     * 操作描述
     */
    @Column(name = "`oper_desc`")
    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    /**
     * 操作后状态
     */
    @Column(name = "`after_state`")
    @ApiModelProperty(value = "操作后状态")
    private Integer afterState;

    /**
     * 备注
     */
    @Column(name = "`remarks`")
    @ApiModelProperty(value = "备注")
    private String remarks;


    /**
     * 自增ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 创建者ID
     */
    @Column(name = "`create_id`")
    @ApiModelProperty(value = "创建者ID")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "`create_date`")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 操作结果
     */
    @Column(name = "`result`")
    @ApiModelProperty(value = "操作结果")
    private String result;

}
