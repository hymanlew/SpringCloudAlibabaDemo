package com.hyman.common.model.dao.line;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "com.hyman.common.model.dao.line.LineCustomerClueInfoDAO")
@Getter
@Setter
@ToString
@Table(name = "qzn_line.line_customer_clue_info")
public class LineCustomerClueInfoDAO extends BaseDAO implements Serializable {
    /**
     * 客户池唯一id
     */
    @Column(name = "customer_clue_id")
    @ApiModelProperty(value = "客户池唯一id")
    private String customerClueId;

    /**
     * 客户名称
     */
    @Column(name = "customer_clue_name")
    @ApiModelProperty(value = "客户名称")
    private String customerClueName;

    /**
     * 城市
     */
    @Column(name = "city")
    @ApiModelProperty(value = "城市")
    private Integer city;

    /**
     * 客户分类
     */
    @Column(name = "kind")
    @ApiModelProperty(value = "客户分类")
    private Integer kind;

    /**
     * 客户行业
     */
    @Column(name = "industry")
    @ApiModelProperty(value = "客户行业")
    private Integer industry;

    /**
     * 一级分类
     */
    @Column(name = "primary_classification")
    @ApiModelProperty(value = "一级分类")
    private Integer primaryClassification;

    /**
     * 二级分类
     */
    @Column(name = "secondary_classification")
    @ApiModelProperty(value = "二级分类")
    private Integer secondaryClassification;

    /**
     * 客户要求配送特征
     */
    @Column(name = "delivery_feature")
    @ApiModelProperty(value = "客户要求配送特征")
    private Integer deliveryFeature;

    /**
     * 车型
     */
    @Column(name = "car_type")
    @ApiModelProperty(value = "车型")
    private Integer carType;

    /**
     * 月毛收入(元)
     */
    @Column(name = "gross_income_monthly")
    @ApiModelProperty(value = "月毛收入(元)")
    private BigDecimal grossIncomeMonthly;

    /**
     * 月净收入(元)
     */
    @Column(name = "net_income_monthly")
    @ApiModelProperty(value = "月净收入(元)")
    private BigDecimal netIncomeMonthly;

    /**
     * 出车数
     */
    @Column(name = "requiremet_car_num")
    @ApiModelProperty(value = "出车数")
    private Double requiremetCarNum;

    /**
     * 客户线路条数
     */
    @Column(name = "line_amount")
    @ApiModelProperty(value = "客户线路条数")
    private Integer lineAmount;

    /**
     * 是否高意向客户 (1:是 2:否)
     */
    @Column(name = "is_high_intentional")
    @ApiModelProperty(value = "是否高意向客户 (1:是 2:否)")
    private Integer isHighIntentional;

    /**
     * 合作难点
     */
    @Column(name = "cooperation_difficulty")
    @ApiModelProperty(value = "合作难点")
    private String cooperationDifficulty;

    /**
     * 状态(字典获取)
     */
    @Column(name = "`status`")
    @ApiModelProperty(value = "状态(字典获取)")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = -6295699602156472632L;
}