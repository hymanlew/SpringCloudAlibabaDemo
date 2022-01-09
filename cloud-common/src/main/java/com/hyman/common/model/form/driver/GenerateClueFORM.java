package com.hyman.common.model.form.driver;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yantao
 * @Date 2021/1/6 14:47
 */
@Data
public class GenerateClueFORM implements Serializable {

    private static final long serialVersionUID = -8785418228331119982L;

    private Long phone;

    private String recoUserId;

    private String sourceChannel;

    private String workCity;

    private String authorizePosition;
}
