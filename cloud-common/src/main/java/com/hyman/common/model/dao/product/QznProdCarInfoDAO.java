package com.hyman.common.model.dao.product;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "com.hyman.common.model.dao.product.ProdCarInfoDAO")
@Data
@Table(name = "prod_car_info")
public class QznProdCarInfoDAO extends BaseDAO implements Serializable {


    /**
     * 城市
     */
    @Column(name = "city")
    @ApiModelProperty(value="城市")
    private Integer city;

    /**
     * 车型
     */
    @Column(name = "car_model")
    @ApiModelProperty(value="车型")
    private String carModel;

    /**
     * 商用车品类
     */
    @Column(name = "commercial_vehicle_category")
    @ApiModelProperty(value="商用车品类")
    private String commercialVehicleCategory;

    /**
     * 供应商
     */
    @Column(name = "supplier")
    @ApiModelProperty(value="供应商")
    private String supplier;

    /**
     * 品牌
     */
    @Column(name = "brand")
    @ApiModelProperty(value="品牌")
    private String brand;

    /**
     * 车系（sku）
     */
    @Column(name = "car_system")
    @ApiModelProperty(value="车系（sku）")
    private String carSystem;

    /**
     * 车辆配置
     */
    @Column(name = "vehicle_configuration")
    @ApiModelProperty(value="车辆配置")
    private String vehicleConfiguration;

    /**
     * 载重
     */
    @Column(name = "`load`")
    @ApiModelProperty(value="载重")
    private String load;

    /**
     * 马力
     */
    @Column(name = "horsepower")
    @ApiModelProperty(value="马力")
    private Double horsepower;

    /**
     * 体积
     */
    @Column(name = "volume")
    @ApiModelProperty(value="体积")
    private Double volume;

    /**
     * 无税车价
     */
    @Column(name = "no_tax")
    @ApiModelProperty(value="无税车价")
    private Double noTax;

    /**
     * 购置税
     */
    @Column(name = "purchase_tax")
    @ApiModelProperty(value="购置税")
    private Double purchaseTax;

    /**
     * 使用状态【默认是0，0在使用，1停用】
     */
    @Column(name = "use_state")
    @ApiModelProperty(value="使用状态【默认是0，0在使用，1停用】")
    private Integer useState;

    /**
     * 备注
     */
    @Column(name = "remarks")
    @ApiModelProperty(value="备注")
    private String remarks;


    private static final long serialVersionUID = 6225602609151253194L;
}