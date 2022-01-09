package com.hyman.common.model.dao.line;

import com.hyman.common.model.dao.BaseDAO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "line_project_strategy_information")
public class ProjectStrategyInfoDAO extends BaseDAO {
    @Id
    private Long id;

    /**
     * 项目编号
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 卖点
     */
    @Column(name = "sell_point")
    private String sellPoint;

    /**
     * 仓库图片url
     */
    @Column(name = "warehouse_picture_url")
    private String warehousePictureUrl;

    /**
     * 货物图片url
     */
    @Column(name = "cargo_url")
    private String cargoUrl;

    /**
     * 装货图片url
     */
    @Column(name = "loading_picture_url")
    private String loadingPictureUrl;

    /**
     * 讲解视频url
     */
    @Column(name = "video_url")
    private String videoUrl;

}