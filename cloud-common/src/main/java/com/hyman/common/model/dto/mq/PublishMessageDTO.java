package com.hyman.common.model.dto.mq;

import com.hyman.common.enums.mq.BasicMQPublishEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 发布消息的传输数据对象
 *
 * @author hucl
 * @date 2020/7/31 16:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishMessageDTO implements Serializable {

    private static final long serialVersionUID = -5761660840897681595L;

    /**
     * MQ 消息id，唯一
     */
    private String messageId;

    /**
     * 唯一id
     */
    private String primaryId;

    /**
     * rocket mq 主题
     */
    private String topic;

    /**
     * rocket mq 标签
     */
    private String tag;

    /**
     * 推送时间戳
     */
    private Date timestamp;

    /**
     * 客户端来源
     */
    private String source;

    /**
     * 需要推送的消息内容
     * json格式
     */
    private String data;

    /**
     * 设置topic info
     *
     * @param topicEnum
     */
    public PublishMessageDTO(@NotNull BasicMQPublishEnum topicEnum) {
        this.topic = topicEnum.getTopic();
        this.tag = topicEnum.getTag();
        this.source = topicEnum.getSource();

        this.timestamp = new Date();
    }

}
