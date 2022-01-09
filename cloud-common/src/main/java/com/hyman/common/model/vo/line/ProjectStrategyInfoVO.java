package com.hyman.common.model.vo.line;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ProjectStrategyInfoVO
 * @Description 项目策展信息
 * @Author shiyunlong
 * @Date 2021/3/4 15:03
 */
@Data
public class ProjectStrategyInfoVO {


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
     * 卖点
     */
    private List<String> sellPointName;

    /**
     * 仓库图片url
     */
    private List<String> warehousePictureUrl;

    /**
     * 货物图片url
     */
    private List<String> cargoUrl;

    /**
     * 装货图片url
     */
    private List<String> loadingPictureUrl;

    /**
     * 讲解视频url
     */
    private String videoUrl;

}
