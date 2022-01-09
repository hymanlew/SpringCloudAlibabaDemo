package com.hyman.common.constant;

import cn.hutool.core.collection.CollectionUtil;
import com.hyman.common.enums.driver.MktClueTypeEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author hyman
 * @description:市场部线索相关Constants
 * @createTime: 2021/3/2
 */
public interface MarketClueConstants {
    /**
     * description:
     * param: campaign信息
     * return:
     * author  hyman
     * createTime: 2021/3/2
     */
    String REDIS_KEY_CAMPAIGN_INFO = "redis_key_campaign_info:";

    /**
     * 梧桐专车、共享线索类型集合
     */
    List<Integer> WT_CLUE_TYPE_LIST = Arrays.asList(MktClueTypeEnum.WT_SPECIAL.getCode(), MktClueTypeEnum.WT_SHARE.getCode());

    /**
     * 雷鸟租赁线索类型集合
     */
    List<Integer> LN_HIRE_CLUE_TYPE_LIST = Arrays.asList(MktClueTypeEnum.LN_HIRE.getCode());
    List<String> LN_HIRE_CLUE_NAME_LIST = Arrays.asList(MktClueTypeEnum.LN_HIRE.getDesc());

    /**
     * 可接收线索职责对应的用户
     * <p>
     * 梧桐专车对应的人员职责
     */
    Set<Integer> WT_SPECIAL_DUTY_ID = CollectionUtil.newHashSet(9);

    /**
     * 可接收线索职责对应的用户
     * 梧桐共享对应的人员职责
     */
    Set<Integer> WT_SHARE_DUTY_ID = CollectionUtil.newHashSet(10);

    /**
     * 可接收线索职责对应的用户
     * 雷鸟车池对应的人员职责
     */
    Set<Integer> LN_CAR_POOL_DUTY_ID = CollectionUtil.newHashSet(11);

    /**
     * 可接收线索职责对应的用户
     * <p>
     * 雷鸟租赁对应的人员职责
     */
    Set<Integer> LN_HIRE_DUTY_ID = CollectionUtil.newHashSet(12);

    /*
     * 雷鸟车池小程序线索分配对应的用户职责
     */
    /*渠道邀约经理*/
    Set<Integer> LN_MINI_PROGRAM_DUTY_QY = CollectionUtil.newHashSet(20);
    /*租赁BGP*/
    Set<Integer> LN_MINI_PROGRAM_DUTY_ZL = CollectionUtil.newHashSet(18);
    /*成交售后经理*/
    Set<Integer> LN_MINI_PROGRAM_DUTY_CSH = CollectionUtil.newHashSet(13);
    /*GMC*/
    Set<Integer> LN_MINI_PROGRAM_DUTY_GMC = CollectionUtil.newHashSet(21);
    List<Integer> LN_MINI_PROGRAM_DUTY_NODE = CollectionUtil.newLinkedList(20, 18, 13, 21);


    /**
     * 私海池本地导入权限
     * 梧桐专车--专车加盟经理、专车邀约经理、专车BGP
     * 梧桐专车--共享加盟经理、共享邀约经理、共享BGP
     * 雷鸟车池--雷鸟车池BGP、雷鸟车池经理
     * 雷鸟租赁C--雷鸟租赁BGP、雷鸟租赁渠道经理、雷鸟租赁交付经理
     * 梧桐专车--雷鸟租赁BGP、雷鸟租赁渠道经理、雷鸟租赁交付经理
     */
    Set<Integer> PRIVATE_WT_SPECIAL_DUTY_ID = CollectionUtil.newHashSet(5, 9);
    Set<Integer> PRIVATE_WT_SHARE_DUTY_ID = CollectionUtil.newHashSet(7, 10);
    Set<Integer> PRIVATE_LN_HIRE_DUTY_ID = CollectionUtil.newHashSet(12, 13);

    /**
     * campaign中的城市增加“全部”
     */
    int CITY_ALL_CODE = 0;
    String CITY_ALL_NAME = "全部城市";

}
