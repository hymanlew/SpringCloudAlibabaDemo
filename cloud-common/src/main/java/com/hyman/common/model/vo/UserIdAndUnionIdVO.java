package com.hyman.common.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tianchong
 * @date 2020-03-25
 **/
@Data
public class UserIdAndUnionIdVO implements Serializable {
    private static final long serialVersionUID = -4693997046777346575L;
    private String userId;
    private String unionId;
}
