package com.hyman.common.model.dto.match;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6871061387377100814L;

    private String id;

    private String loginName;

    private String name;
}
