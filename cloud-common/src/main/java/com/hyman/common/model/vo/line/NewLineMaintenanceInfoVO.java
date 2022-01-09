package com.hyman.common.model.vo.line;

import lombok.Data;

/**
 * @ClassName NewLineMaintenanceInfoVO
 * @Description 新线货架维护VO
 * @Author shiyunlong
 * @Date 2021/3/22 14:43
 */
@Data
public class NewLineMaintenanceInfoVO {
    /**
     * 待办ID
     */
    private String agentId;
    /**
     * 处理优先级(1、暂不处理，2待处理)
     **/
    private Integer processingPriority;

    /**
     * 线路ID
     */
    private String lineId;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 线路详情
     */
    private LineDetailVO lineDetailVO;
    /**
     * 项目策展详情
     */
    private ProjectStrategyInfoVO projectStrategyInfoVO;

    /**
     * 标签详情
     **/
    private LineLabelVO lineLabelVO;

}
