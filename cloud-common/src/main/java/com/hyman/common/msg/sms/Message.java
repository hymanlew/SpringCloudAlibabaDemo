package com.hyman.common.msg.sms;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午2:57
 * @Description:
 */
@Data
public class Message implements Serializable {

    /**
     * 接收者唯一id
     */
    private String toSbId;


    /**
     * 消息体
     */
    private Object body;


}
