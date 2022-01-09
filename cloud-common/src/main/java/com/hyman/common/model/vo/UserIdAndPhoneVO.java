package com.hyman.common.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tianchong
 * @date 2020-03-25
 **/
@Data
public class UserIdAndPhoneVO implements Serializable {
    private static final long serialVersionUID = 7482521945168404513L;
    private String userId;
    private String phone;
}
