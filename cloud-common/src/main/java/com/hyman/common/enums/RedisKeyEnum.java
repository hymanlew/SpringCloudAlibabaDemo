package com.hyman.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: tianchong
 * @create: 2020-07-10
 * @description: redis相关key
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RedisKeyEnum {

    BASE_USER_BASIC_INFO("base:user:basic:", DataTypeEnum.STRING, "用户基本信息"),
    BASE_USER_MENU_PERMISSIONS_INFO("base:user:menu", DataTypeEnum.LIST, "用户菜单权限信息"),
    BASE_USER_CITY_PERMISSIONS_INFO("base:user:city", DataTypeEnum.LIST, "用户城市权限信息"),
    BASE_AREA_WITHOUT_TOWN_INFO("base:area:province_city_county:hash:", DataTypeEnum.HASH, "区域sys_area信息"),
    BASE_DICT_LABEL_VALUE_INFO("base:dict:v2:", DataTypeEnum.HASH, "字典信息key=前缀+dictType,field=dictLabel,value=dictValue"),
    BASE_DICT_VALUE_LABEL_INFO("base:dict:value:label:", DataTypeEnum.HASH, "字典信息key=前缀+dictType,field=dictValue,value:dictLabel"),
    BASE_USER_DATA_SCOPE_INFO("base:user:dataScopeType:userId:", DataTypeEnum.HASH, "根据userId查询当前用户可视范围的用户id集合"),
    BASE_USER_DATA_PERMISSION_INFO("base:user:data_permission:", DataTypeEnum.LIST, "根据userId查询当前用户拥有的数据权限对应的用户id集合"),
    AUTH_USER_LOGIN_FLAG("auth:user:login:flag:", DataTypeEnum.STRING, "根据userId查询当前用户的登录状态以及登入和踢出的标准"),
    BASE_USER_USERINFO("key:base:user:userinfo:", DataTypeEnum.STRING, "用户信息相关缓存"),
    USER_PREMISSION_ID_REDIS_KEY_PREFIX("key:base:user:permission:id:", DataTypeEnum.STRING, "用户权限ID"),
    BASE_ROLE_ROLE_ID_KEY("base:role:", DataTypeEnum.HASH, "角色数据权限相关缓存 key=前缀+roleId, field=uri, member=dataScope"),
    BASE_USER_SYNC_CRM_ACTIVE_KEY("base:user:crm:active", DataTypeEnum.HASH, "用户是否在crm系统激活"),
    BASE_OFFICE_ALL_INFO_REDIS_KEY("base:office:all:info", DataTypeEnum.HASH, "用户是否在crm系统激活"),
    BASE_DUTY_MAPPING_CACHE("b:d:m:c", DataTypeEnum.HASH, "职责映射缓存"),
    BASE_FIRST_DUTY_ID_AND_NAME("b:f:d:i:a:n", DataTypeEnum.HASH, "一级职责缓存"),
    BASE_OPEN_CITY_KEY("base:open_city",DataTypeEnum.ZSET,"开通五十城信息"),

    ORDER_PLATE_NO_REDIS_KEY("order:plate_no", DataTypeEnum.STRING, "订单的车牌号"),
    ORDER_COOPERATION_CAR_REDIS_KEY("order:cooperation_car", DataTypeEnum.STRING, "订单的车型"),
    DRIVER_LABEL_SYNC_A_ACTIVATION_KEY("driver:label_sync_a:activation", DataTypeEnum.HASH,
            "司机已经打过A端标签的记录，key=this key, field=driverId, value=1"),
    DRIVER_BASE_INFO_REDIS_KEY("driver:info:base", DataTypeEnum.STRING, "司机基础信息"),
    DRIVER_CLUE_H5_AUTO_ALLOCATE_REDIS_KEY("driver:clue:h5:auto_allocate", DataTypeEnum.STRING, "h5市场部司机线索自动分配, prefix:cityCode:busiType"),
    DRIVER_MKT_CLUE_AUTO_ALLOCATE_REDIS_KEY("driver:mkt_clue:auto_allocate:", DataTypeEnum.STRING, "市场部司机线索自动分配, prefix:cityCode:busiType:tid"),
    DRIVER_MATCH_MQ_REPEAT_KEY("driver:match:mq:repeat:", DataTypeEnum.STRING, "司机侧消费撮合发送MQ消息"),
    DRIVER_CLUE_APPLET_AUTO_ALLOCATE_REDIS_KEY("driver:clue:applet:auto_allocate", DataTypeEnum.STRING, "小程序司机线索自动分配, prefix:cityCode:busiType"),
    BASE_USER_USERINFO_USERIDS("key:base:user:userids", DataTypeEnum.SET, "用户id，返回Set<String>"),
    MARKET_CLUE_IMPORT_PROGRESS("market:clue:import:progress", DataTypeEnum.STRING, "市场部线索导入进度 key=prefix:recordId:毫秒时间戳,value=JSONString"),
    MARKET_CLUE_REFLOW_INFO("driver:mkt_clue:reflowInfo:", DataTypeEnum.STRING, "市场部线索回流policy配置 key=prefix:cityCode:busiType"),

    LABEL_DRIVER_MATCH_SIDE_REDIS_KEY("label:driver:match_side:",DataTypeEnum.STRING,"撮合-司机标签MQ消费缓存key"),
    LABEL_DRIVER_DRIVER_SIDE_KEY("label:driver:driver_side:",DataTypeEnum.STRING,"司机侧-司机标签MQ消费缓存key"),

    MATCH_DRIVER_ACCT_DRIVER_BOOK_KEY("match:driver:acct_driver_book:",DataTypeEnum.STRING,"撮合-司机梧桐账户信息MQ消费缓存key"),
    MATCH_DRIVER_CALL_SEND_KEY("match:driver:call_send:",DataTypeEnum.STRING,"撮合-外呼MQ消费缓存key"),
    MATCH_DRIVER_DRIVER_INFO_KEY("match:driver:driver_info:",DataTypeEnum.STRING,"撮合-司机信息MQ消费缓存key"),
    MATCH_DRIVER_LABEL_DRIVER_KEY("match:driver:label_driver:",DataTypeEnum.STRING,"撮合-司机标签MQ消费缓存key"),
    MATCH_DRIVER_RUN_TEST_KEY("match:driver:run_test:",DataTypeEnum.STRING,"撮合-试跑MQ消费缓存key"),
    /**
     * 客户相关
     */
    CUSTOMER_PROJECT_IS_FETCHLINE("c:p:i:f:",DataTypeEnum.STRING,"项目是否成功获线"),

    LABEL_CUSTOMER_MATCH_SIDE_REDIS_KEY("label:customer:match_side:",DataTypeEnum.STRING,"撮合-客户标签标签MQ消费缓存key"),
    LABEL_CUSTOMER_CUSTOMER_SIDE_KEY("label:customer:customer_side:",DataTypeEnum.STRING,"客户侧-客户标签MQ消费缓存key"),

    /**
     * 小程序相关key
     */
    LANDING_WX_TOKEN_REDIS_KEY("landing:page:wx:token", DataTypeEnum.STRING, "雷鸟落地页获取微信token的缓存key"),
    LANDING_WX_TICKET_REDIS_KEY("landing:page:wx:ticket", DataTypeEnum.STRING, "雷鸟落地页获取微信ticket的缓存key"),
    SPECIAL_WX_ACCESS_TOKEN_KEY("applet:special:accesstoken",DataTypeEnum.STRING,"梧桐专车小程序accesstoken的key"),
    SHARE_WX_ACCESS_TOKEN_KEY("applet:share:accesstoken",DataTypeEnum.STRING,"梧桐共享小程序accesstoken的key"),
    ;
    private String key;
    private DataTypeEnum type;
    private String desc;

    public enum DataTypeEnum {
        STRING, LIST, HASH, SET, ZSET
    }
}
