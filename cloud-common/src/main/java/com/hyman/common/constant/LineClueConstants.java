package com.hyman.common.constant;

/**
 * @Author:yanwei
 * @Date: 2020/7/13 - 16:48
 * 貨主綫索所包含的字典type信息
 */

public interface LineClueConstants {

    /**
     *  线索来源
     */
    interface LineClueClueSource {
        String DICT_TYPE = "line_clue_source";
    }

    /**
     * 梧桐云雀车型
     */
    interface LineClueDemandSource {
        String DICT_TYPE = "Intentional_compartment";
    }

    /**
     * 主流程状态
     */
    interface LineClueStateSource {
        String DICT_TYPE = "line_clue_state";
    }
}
