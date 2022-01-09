package com.hyman.common.msg.sms;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午1:57
 * @Description:
 */
@Data
public class Response {


    /**
     * 响应码
     */
    private Integer code;


    /**
     * 成功
     */
    private boolean success = true;


    /**
     * 发送日期
     */
    private LocalDateTime sendTime;


    /**
     * 发送完成日期
     */
    private LocalDateTime finishedTime;


}
