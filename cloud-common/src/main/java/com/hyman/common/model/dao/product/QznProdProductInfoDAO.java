package com.hyman.common.model.dao.product;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "com.hyman.common.model.dao.product.ProdProductInfoDAO")
@Data
@Table(name = "prod_product_info")
public class QznProdProductInfoDAO extends BaseDAO implements Serializable {


    /**
     * 产品编号
     */
    @Column(name = "program_id")
    @ApiModelProperty(value="产品编号")
    private String programId;

    /**
     * 产品方案名称
     */
    @Column(name = "program_name")
    @ApiModelProperty(value="产品方案名称")
    private String programName;

    /**
     * 城市
     */
    @Column(name = "city")
    @ApiModelProperty(value="城市")
    private Integer city;

    /**
     * 主车信息编号
     */
    @Column(name = "car_info_id")
    @ApiModelProperty(value="主车信息编号")
    private Long carInfoId;

    /**
     * 保险信息编号
     */
    @Column(name = "insurance_info_id")
    @ApiModelProperty(value="保险信息编号")
    private Long insuranceInfoId;

    /**
     * gps信息编号
     */
    @Column(name = "gps_info_id")
    @ApiModelProperty(value="gps信息编号")
    private Long gpsInfoId;

    /**
     * 是否需要gps[默认0，0需要，1不需要]
     */
    @Column(name = "gps_need")
    @ApiModelProperty(value="是否需要gps[默认0，0需要，1不需要]")
    private Integer gpsNeed;

    /**
     * 金融信息编号
     */
    @Column(name = "financial_info_id")
    @ApiModelProperty(value="金融信息编号")
    private Long financialInfoId;

    /**
     * 是否需要金融【默认是0，0需要，1不需要】
     */
    @Column(name = "financial_need")
    @ApiModelProperty(value="是否需要金融【默认是0，0需要，1不需要】")
    private Integer financialNeed;

    /**
     * 线路管理费
     */
    @Column(name = "line_management_fee")
    @ApiModelProperty(value="线路管理费")
    private Double lineManagementFee;

    /**
     * 使用状态【默认是0，0上架，1下架】
     */
    @Column(name = "use_state")
    @ApiModelProperty(value="使用状态【默认是0，0上架，1下架】")
    private Integer useState;

    /**
     * 合作模式【默认是0，0尚未初始化,1购车，2租车，3带车】
     */
    @Column(name = "cooperation_model")
    @ApiModelProperty(value="合作模式【默认是0，0尚未初始化,1购车，2租车，3带车】")
    private Integer cooperationModel;

    /**
     * 备注
     */
    @Column(name = "remarks")
    @ApiModelProperty(value="备注")
    private String remarks;


    private static final long serialVersionUID = 8195715880922929522L;
}