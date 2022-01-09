package com.hyman.common.model.vo.driver;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/11/26 10:04
 * @Describe ©
 */
@Data
public class DriverRefundInfoVO implements Serializable {

    private static final long serialVersionUID = -2528005688728343024L;

    private String driverId;

    private String name;

    private String cityName;

    private String gmName;

    private String busiTypeName;

    private String status;
}
