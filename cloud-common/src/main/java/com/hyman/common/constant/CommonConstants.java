package com.hyman.common.constant;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
public interface CommonConstants {
    String RESOURCE_TYPE_MENU = "menu";
    String RESOURCE_TYPE_BTN = "button";

    String TOKEN_HEADER = "Authorization";

    String TOKEN = "token";

    // 用户token异常
    Integer EX_USER_INVALID_CODE = 40101;
    // 客户端token异常
    Integer EX_CLIENT_INVALID_CODE = 40301;
    Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    Integer EX_OTHER_CODE = 500;

    String CONTEXT_KEY_USER_ID = "currentUserId";
    String CONTEXT_KEY_USERNAME = "currentUserName";
    String CONTEXT_KEY_USER_NAME = "currentUser";
    String CONTEXT_KEY_USER_TOKEN = "currentUserToken";

    String JWT_KEY_USER_ID = "userId";
    String JWT_KEY_NAME = "name";
    String JWT_KEY_PHONE = "phone";
    String JWT_KEY_DRIVER_ID = "driverId";
    String JWT_KEY_ROLE = "role";
    String JWT_KEY_OPENID = "openId";
    String JWT_KEY_TYPE = "type";//type 表示当前token 的类型：APP，Applets，BSS TokenTypeEnum
    String JWT_KEY_PROFILE = "profile";//当前运行环境 d1,m1,staging,prod
    String JWT_KEY_SYSTEMTYPE = "systemtype";//系统标识 比如1:梧桐系统 3:雷鸟系统

    String JWT_KEY_USERNAME = "username";
    String JWT_KEY_PASSWORD = "password";
    String JWT_KEY_PERMISSION = "permission";
    String HEADER_KEY_UUID = "uuid";
    //用户的密码修改
    String USERINFO_UPDATE = "userInfoUpdate";

    String REDIS_PHONE_VERIFY_PREFIX = "CORE:VERIFY:PHONE:"; //手机号验证码
    String REDIS_USER_PHONE_PREFIX = "CORE:DATA:USER:PHONE:";
    String REDIS_USER_OPENID_PREFIX = "CORE:DATA:USER:OPENID:";

    Integer DELETE_FLAG_FALSE_ZERO = 0;
    Integer DELETE_FLAG_TRUE_ONE = 1;

    /**
     * 小程序区分标记: 0梧桐专车-喜鹊1梧桐共享-云雀
     */
    String APPLET_DOMAIN_NAME_TAG = "appType";

    /**
     * ip地址
     */
    String CLIENT_IP = "clientIp";

    /**
     * base用户业务权限 参看 BusiTypeEnum
     */
    String USER_BUSI_PERMISSION = "busiPermission";

    /**
     * 登录标识用于踢出，不允许同时多人登录
     */
    String USER_BUSI_LOGIN_FLAG = "userLoginFlag";

    /**
     * REDIS默认过期时间设置，默认6个小时
     */
    long REDIS_CACHE_TIME = 6 * 60 * 60L;

    /**
     * base 工程中的用户权限信息同步到redis中的前缀
     */
    String REDIS_BASE_USER_PREFIX = "base:user:";
    /**
     * base 工程中的字典同步到redis中的前缀
     */
    String REDIS_BASE_DICT_PREFIX = "base:dict:v2:";
    /**
     * base 工程中的用户与城市信息同步到redis中的前缀
     */
    String REDIS_BASE_USERCITY_PREFIX = "base:user_city:";

    /**
     * base 工程中的业务拓展经理
     */
    String REDIS_BASE_BDMANAGER_PREFIX = "base:bd_manager:";

    /**
     * Product 工程中信息同步到redis中的前缀
     */
    String REDIS_PRODUCT_PREFIX = "product:";

    /**
     * Product 工程中id 信息同步到redis中的前缀
     */
    String REDIS_PRODUCT_ID_PREFIX = "product:id";


    /**
     * base 工程中的测试人员id同步到redis中的key
     */
    String REDIS_BASE_TEST_USER_KEY = "base:test_user_id";

    /**
     * base 工程中用户id转成用户姓名，信息同步到redis中的前缀
     */
    String REDIS_BASE_USERID_CONVERT_NAME_PREFIX = "base:userid_convert_name:";

    /**
     * calc 工程同步云鸟司机收入信息， 当前key 存在，且值为 no 时 停止同步
     */
    String REDIS_CALC_STOP_SYNC_YN = "calc:stop_sync_yn";

    /**
     * calc 工程同步云鸟司机收入信息 v1.10之前使用，已经废弃
     */
    String REDIS_CALC_YN_DRIVER_KEY = "calc:yn_driver_list:";

    /**
     * calc 工程同步云鸟司机收入信息v1.10
     * calc:yn_driver_list110:订单id:云鸟司机id
     */
    String REDIS_CALC_YN_DRIVER110_KEY = "calc:yn_driver_list110:";

    /**
     * proxy 工程登录云鸟A端 cookie key
     */
    String REDIS_PROXY_COOKIE_YN_KEY = "proxy:cookie:yn";

    /**
     * 订单域，司机签约成交，保存合同时间，待上岗时候使用
     */
    String REDIS_ORDER_DRIVER_CONTRACT_TIME = "order:driver_contract_time:";

    /**
     * 喜鹊小程序，首页，消息轮播 key
     */
    String REDIS_DRIVER_MAGPIE_MESSAGE_PREFIX = "driver:magpie_message:";

    /**
     * 喜鹊小程序，线路浏览量key
     */
    String REDIS_DRIVER_LINE_PAGE_VIEW_PREFIX = "driver:magpie_page_view:";

    /**
     * 喜鹊小程序，线路收藏量key
     */
    String REDIS_DRIVER_LINE_COLLECTION_PREFIX = "driver:magpie_collection:";

    /**
     * 喜鹊小程序，人员收藏 线路 key+userId
     */
    String REDIS_DRIVER_LINE_COLLECTION_USER_PREFIX = "driver:magpie_collection_user:";

    /**
     * 喜鹊小程序，用户订阅key
     */
    String REDIS_DRIVER_MAGPIE_SUBSCRIPTION = "driver:magpie_user_subscription:";

    /**
     * 喜鹊小程序，banner key
     */
    String REDIS_BASE_URL_KEY = "base:banner_url";
    /**
     * 云雀小程序，banner key  2.1
     */
    String REDIS_YUNQUE_BASE_URL_KEY = "base:banner_url_yunque";

    /**
     * 喜鹊小程序，banner key
     */
    String REDIS_BASE_SELF_URL_KEY = "base:banner_self_url";

    /**
     * 订单中关联的产品详情 信息同步到redis中 v1.6之前 里面不含有银行卡信息
     */
    String REDIS_ORDER_PRODUCT_DETAIL_PREFIX = "order:";

    /**
     * 手动生成订单，保存操作
     * v1.6之后，redis以当前key作为前缀存储订单信息
     */
    String REDIS_ORDER_SAVE_PRODUCT_DETAIL_PREFIX = "order:temp_save:";

    /**
     * 手动生成订单，保存操作
     * v1.11之后，redis以当前key作为前缀存储订单信息
     */
    String REDIS_ORDER_SAVE_PRODUCT_DETAIL_V111_PREFIX = "order:temp_save_v111:";

    /**
     * 订单详情
     */
    String REDIS_ORDER_SAVE_DETAIL_PREFIX = "order:detail:";

    /**
     * base 工程中的用户拥有的角色列表
     */
    String REDIS_BASE_USER_ROLE_PREFIX = "base:user_role:";

    /**
     * base 工程中的用户的职位名
     */
    String REDIS_BASE_USER_TITLE_PREFIX = "base:user_title";

    /**
     * base 工程中的用户基本信息 id，name
     */
    String REDIS_BASE_USER_NAME_PREFIX = "base:user_id_name:";

    /**
     * proxy 工程，云鸟 客户名称
     */
    String REDIS_PROXY_YN_CUSTOMER_NAME_KEY = "proxy:yn_customer_name:";

    /**
     * 线路评级条件key
     */
    String REDIS_LINE_RANK_CONDITION_KEY = "line:rank_condition";

    /**
     * 线路最终评级规则key
     */
    String REDIS_LINE_RANK_DEGREE_KEY = "line:rank_degree";

    /**
     * 线路最终评级规则key[使用Java表达式]
     * 优先级高于 REDIS_LINE_RANK_DEGREE_KEY
     */
    String REDIS_LINE_RANK_DEGREE_JAVA_KEY = "line:rank_degree:java";

    /**
     * 线路评级，根据分数区分业务权限key
     */
    String REDIS_LINE_RANK_DEGREE_BUSITYPE_KEY = "line:rank_degree:busitype";


    /**
     * 一线城市key
     */
    String REDIS_DEVELOPED_CITY_KEY = "qzn:city:developed";


    /**
     * 一线城市可售线路评判标准key
     */
    String REDIS_DEVELOPED_CITY_CANSELL_LINE_CONDITION_KEY = "qzn:line:cansell:city:developed";

    /**
     * 二线城市可售线路评判标准key
     */
    String REDIS_SECONDTIER_CITY_CANSELL_LINE_CONDITION_KEY = "qzn:line:cansell:city:second-tier";

    /**
     * 评判标准中可售线路key
     */
    String REDIS_CANSELL_LINE_SUPERIOR_KEY = "qzn:line:cansell:superior";

    /**
     * 货主一、二级分类key
     */
    String REDIS_LINE_CUSTOMER_ONE_TWO_CATEGORY_KEY = "line:customer:one_two_cate";


    /**
     * v1.8
     * Product 工程标记位，当前key 如果开启，意外着产品信息不再读取redis中的 缓存，相应数据从 Mysql 中读取
     * 开启为 true
     */
    String REDIS_PRODUCT_START_STATE = "product:start:state";

    /**
     * 喜鹊活动祝福语key
     */
    String REDIS_XIQUE_ACITVITY_BLESSWORD = "xique:activity:bless_word";

    /**
     * 喜鹊活动前缀
     */
    String REDIS_XIQUE_ACITVITY_KEY = "xique:activity:";

    /**
     * 获取喜鹊活动喜报广播消息key
     */
    String REDIS_XIQUE_ACITVITY_HAPPY_NEWS_KEY = "xique:activity:happy_news";

    /**
     * 产品租车车型缓存 以城市进行划分
     */
    String REDIS_PRODUCT_CAR_RENTAL_CITY_KEY = "product:car:rental:";

    /**
     * calc 工程定时调度，查询当前司机30天内有无创建订单
     */
    String REDIS_CALC_WHETHER_THE_DRIVER_HAS_CREATED_AN_ORDER = "calc:driver_created_order:";

    /**
     * 线路部分失效的标签
     */
    String REDIS_LABELS_LINE_PARTIALINVALID_KEY = "qzn:labels:line:1001";

    /**
     * 线路审核通过时的等待上车有效期key
     */
    String REDIS_LINE_WAIT_DIRVE_VALIDITY_DURATION_KEY = "line:wait_dirve_validity:duration";

    /**
     * 线路部分失效减少的可上车数
     */
    String REDIS_LINE_PARTEXPIRE_DECREASENUM_KEY = "qzn:line:part_expire:decrease_num";

    /**
     * 业务运营管理系统-车辆成交统计 短信
     */
    String REDIS_VEHICLE_TRANSACTIONSTATISTICS_SMS_KEY = "order:vehicle:sms:";

    /**
     * 业务运营管理系统-车辆成交统计负责人  短信
     */
    String REDIS_VEHICLE_SMS_PRINCIPAL_KEY = "order:vehicle:sms:principal:";

    /**
     * 业务运营管理系统- 共享 车辆成交统计
     */
    String REDIS_VEHICLE_SHARE_TRANSACTIONSTATISTICS_SMS_KEY = "order:vehicle:share:sms:";

    /**
     * 业务运营管理系统- 共享 车辆成交统计负责人
     */
    String REDIS_VEHICLE_SHARE_SMS_PRINCIPAL_KEY = "order:vehicle:share:sms:principal:";

    /**
     * 业务运营管理系统-车辆成交统计 短信 监控人员
     */
    String REDIS_VEHICLE_TRANSACTIONSTATISTICS_SMS_ALL_KEY = "order:vehicle:sms:all";

    /**
     * 业务运营管理系统-共享车辆成交统计 短信 监控人员
     */
    String REDIS_VEHICLE_SHARE_TRANSACTIONSTATISTICS_SMS_ALL_KEY = "order:vehicle:share:sms:all";

    /**
     * 业务运营管理系统-车辆成交统计 短信 重复调用标记位
     */
    String REDIS_VEHICLE_TRANSACTIONSTATISTICS_SMS_REPEAT_KEY = "order:vehicle:sms:repeat";

    /**
     * 梧桐喜鹊app ,创建订单权限人员
     */
    String REDIS_ORDER_XIQUE_CREATE_KEY = "order:xique:create";

    /**
     * 已经操作过的出车任务ids
     */
    String REDIS_HAS_OPERATED_EVENTIDS_KEY = "partner:operated:eventids";

    /**
     * 企业微信-司机助手-产品介绍
     */
    String REDIS_ENTERPRISEWECHAT_PATCHER_PRODUCT_INTRODUCTION_KEY = "prod:enterprisewechat:patcher:introduction";

    /**
     * 城市code --> name
     */
    String REDIS_CITY_CODE_NAME_KEY = "base:city:code-name:";

    /**
     * 撮合大会-城市权重值
     */
    String REDIS_DRIVER_LINE_MATCH_RATE_WEIGHT_KEY = "match:driver-line-rate:weight";

    /**
     * 撮合大会-共享司机上专车线路
     */
    String REDIS_DRIVER_LINE_MATCH_SELFLINE_SHARE_DRIVER_KEY = "match:driver-line-rate:selfline:share";

    /**
     * 小程序电话-存储平均分配加盟经理的列表
     */
    String REDIS_CITY_BGL_JOINMANAGER_KEY = "driver:city_manager:";

    /**
     * REDIS司机与城市绑定联系人过期时间设置（一周）
     */
    long REDIS_DRIVER_BGL_BIND_CACHE_TIME = 7 * 24 * 60 * 60L;

    /**
     * 小程序电话-绑定司机与城市加盟经理
     */
    String REDIS_DRIVER_BGL_JOINMANAER_BIND_KEY = "driver:driver_manager_bind:";

    /**
     * 赋能打分，gmc权重值key
     */
    String REDIS_DATACENTER_GMC_WEIGHT_KEY = "data-center:gmc:weight";

    /**
     * 区域
     */
    String REDIS_BASE_AREA_KEY = "base:area:province_city_county:hash:";

    /**
     * 用户可视范围列表缓存key
     */
    String REDIS_BASE_USER_DATA_SCOPE_TYPE_KEY = "base:user:dataScopeType:";

    /**
     * 角色数据权限相关缓存key
     */
    String REDIS_BASE_ROLE_ROLE_ID_KEY = "base:role:";


    /**
     * 角色数据权限相关缓存key
     */
    String REDIS_BASE_USER_ID_KEY = "base:user:personal";

    /**
     * jps交付设置
     */
    String REDIS_PRODUCT_SYSTEM_SETTING = "product:system:setting";

    /**
     * 创建小程序推广码角色权限集合key
     */
    String XCX_CREATE_QRCODE_USER_ROLE = "xcx_create_qrcode_user_role_new";

    Set<String> AREA_CODE_INIT = Sets.newHashSet("0", "-99");

    String EMPTY = "";
    
    Long LONG_ZERO = 0L;
    
}
