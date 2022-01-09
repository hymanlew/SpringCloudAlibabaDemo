package com.hyman.common.model.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * desc...
 *
 * @author wanghaitong
 * @date 2020/11/5 下午4:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateDto {
    Date startDate;
    Date endDate;
}
