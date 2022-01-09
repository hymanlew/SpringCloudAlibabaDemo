package com.hyman.common.model.dao.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author hyman
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "prod_info")
public class ProdInfoDAO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 业务类型：1购车，2租车
     */
    private Integer type;

    /**
     * 产品名称，业务角度的购车车型
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 车辆描述
     */
    @Column(name = "`describe`")
    private String describe;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 城市
     */
    private String city;

    /**
     * 销售状态:10上架，20下架
     */
    private Integer status;

    /**
     * 删除状态，0正常，1删除
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 创建者
     */
    @Column(name = "create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 最后更新人
     */
    @Column(name = "update_id")
    private Integer updateId;

    /**
     * 最后更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;


    @Column(name = "car_type")
    private Integer carType;

    @Column(name = "model")
    private String model;

}
