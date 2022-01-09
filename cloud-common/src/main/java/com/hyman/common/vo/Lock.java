package com.hyman.common.vo;

import lombok.Data;

/**
 * @Author
 * @Date: 2018/7/18 11:09
 * @Description:
 */
@Data
public class Lock {
    private String name;
    private String value;

    public Lock() {

    }

    public Lock(String name) {
        this.name = name;
    }

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
