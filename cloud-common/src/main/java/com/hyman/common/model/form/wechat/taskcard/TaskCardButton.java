package com.hyman.common.model.form.wechat.taskcard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <pre>
 *  任务卡片按钮
 *  Created by Jeff on 2019-05-16.
 * </pre>
 *
 * @author <a href="https://github.com/domainname">Jeff</a>
 * @date 2019-05-16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCardButton implements Serializable {

  private static final long serialVersionUID = -3746648155102967946L;
  /**
   * 按钮key值
   */
  private String key;
  /**
   * 按钮名字
   */
  private String name;
  /**
   * 点击后名字
   */
  private String replaceName;
  /**
   * 按钮颜色
   */
  private String color;
  /**
   * 是否加粗
   */
  private Boolean bold;
}
