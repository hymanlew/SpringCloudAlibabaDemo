package com.hyman.common.model.dto.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yantao
 * @Date 2021/6/9 10:33
 * @Describe
 */
@Data
public class GeoRadiusDto implements Serializable {

    private static final long serialVersionUID = 3073405042548596886L;

    private String key;
    private String member;
    private double x;
    private double y;
}
