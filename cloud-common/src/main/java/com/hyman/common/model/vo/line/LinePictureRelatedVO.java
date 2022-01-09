package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName LinePictureRelatedVO
 * @Description 线路照片详情视图
 * @Author shiyunlong
 * @Date 2020/7/13 11:39
 */
@Data
public class LinePictureRelatedVO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 线路id
     */
    @ApiModelProperty(value = "线路id")
    private String lineId;


    /**
     * 库房装货图片
     */
    @ApiModelProperty(value = "库房装货图片")
    private List<String> warehouseLoadingPictures;

    /**
     * 其他图片
     */

    @ApiModelProperty(value = "其他图片")
    private List<String> otherPictures;


    /**
     * 现场信息说明
     */
    @ApiModelProperty(value = "现场信息说明")
    private String informationDescription;

    /**
     * 装货视频
     */
    @ApiModelProperty(value = "装货视频")
    private String loadingVideo;


    @ApiModelProperty(value = "创建时间")
    private Date createDate;
}
