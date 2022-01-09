package com.hyman.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author
 * @Date: 2018/5/2 10:28
 * @Description:
 */
@Getter
@Setter
@ToString
public class LogInfo implements Serializable {
    private String menu;

    private String opt;

    private String uri;

    private Date crtTime;

    private String crtUser;

    private String crtName;

    private String crtHost;

    public LogInfo(String menu, String option, String uri,  Date crtTime, String crtUser, String crtName, String crtHost) {
        this.menu = menu;
        this.opt = option;
        this.uri = uri;
        this.crtTime = crtTime;
        this.crtUser = crtUser;
        this.crtName = crtName;
        this.crtHost = crtHost;
    }

    public LogInfo() {
    }


}
