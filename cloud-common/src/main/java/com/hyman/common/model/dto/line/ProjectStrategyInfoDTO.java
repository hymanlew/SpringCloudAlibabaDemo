package com.hyman.common.model.dto.line;

import lombok.Data;

/**
 * @ClassName ProjectStrategyInfoDTO
 * @Description 项目策展详情
 * @Author shiyunlong
 * @Date 2021/3/4 18:14
 */
@Data
public class ProjectStrategyInfoDTO {

    private Long id;

    /**
     * 项目编号
     */
    private String projectId;

    /**
     * 卖点
     */
    private String sellPoint;


    /**
     * 仓库图片url
     */
    private String warehousePictureUrl;

    /**
     * 货物图片url
     */
    private String cargoUrl;

    /**
     * 装货图片url
     */
    private String loadingPictureUrl;

    /**
     * 讲解视频url
     */
    private String videoUrl;
}
