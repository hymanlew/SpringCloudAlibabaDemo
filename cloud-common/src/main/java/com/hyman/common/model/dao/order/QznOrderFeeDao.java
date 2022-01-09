package com.hyman.common.model.dao.order;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "order_fee")
public class QznOrderFeeDao implements Serializable {


    private static final long serialVersionUID = 2288997627686446385L;
    @Id
    private Integer id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "line_fee")
    private BigDecimal lineFee;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return line_fee
     */
    public BigDecimal getLineFee() {
        return lineFee;
    }

    /**
     * @param lineFee
     */
    public void setLineFee(BigDecimal lineFee) {
        this.lineFee = lineFee;
    }

    public QznOrderFeeDao() {
    }

    public QznOrderFeeDao(String orderId, BigDecimal lineFee) {
        this.orderId = orderId;
        this.lineFee = lineFee;
    }
}