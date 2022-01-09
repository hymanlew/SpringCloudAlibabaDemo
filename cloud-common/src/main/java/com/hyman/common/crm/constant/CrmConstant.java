package com.hyman.common.crm.constant;

/**
 * @Author:yanwei
 * @Date: 2020/9/3 - 18:56
 * <p>
 * CRM 常量串 指定访问 URN
 */

public interface CrmConstant {

    String TOKEN_PREFIX = "Bearer ";
    /**
     * CRM 系统认证 URN 路径
     */
    String AUTH_URN = "/oauth2/token";

    /**
     * CRM  查询或修改资源的 URN 路径
     */
    String COMM_URN = "/rest/data/v2.0/xobjects/";

    /**
     * CRM 根据自定义sql 查询的 URN 路径
     */
    String SQL_URN = "/rest/data/v2/query?q=";

    /**
     * CRM 创建用户信息的 URL 路径
     */
    String USER_INSERT = "/data/v1/objects/user/create";

    /**
     * CRM 用户信息描述 URL 路径
     */
    String USER_REMARK = "/data/v1/objects/user/describe";

    /**
     * CRM 用户信息明细 URL 路径
     */
    String USER_DESCRIPTION = "/data/v1/objects/user/info";

    /**
     * CRM 删除用户信息的 URL 路径
     */
    String USER_DELETE = "/data/v1/objects/user/delete";

    /**
     * CRM 用户离职信息的 URL 路径
     */
    String USER_DEPARTURE = "/data/v1/objects/user/departure";

    /**
     * CRM 用户更新信息的 URL 路径
     */
    String USER_UPDATE = "/data/v1/objects/user/update";
    /**
     * CRM 禁用用户信息的 URL 路径
     */
    String USER_ENABLE = "/rest/data/v2.0/xobjects/user/actions/enable?recordId=%s";

    /**
     * CRM 启用用户信息的 URL 路径
     */
    String USER_ENABLE_DEPARTURE = "/data/v1/objects/user/enableDeparture";

    /**
     * CRM 同步字典信息的 URL 路径
     */
    String DICT_SYNC = "/rest/metadata/v2.0/settings/globalPicks";

    /**
     * CRM 同步字典更新信息的 URL 路径
     */
    String DICT_UPDATE = "/rest/metadata/v2.0/settings/globalPicks/%s";

    /**
     * CRM 图片下载的URN路径
     */
    String IMG_DOWNLOAD = "/rest/file/v2.0/image/%s";

    /**
     * CRM 业务数据创建
     */
    String BUSI_DATA_CREATE = "/rest/data/v2.0/xobjects/%s";

    /**
     * CRM 业务数据修改
     */
    String BUSI_DATA_UPDATE = "/rest/data/v2.0/xobjects/%s/%s";

    /**
     * CRM 业务数锁定
     */
    String BUSI_DATA_LOCK = "/rest/data/v2.0/xobjects/%s/actions/locks?recordId=%s";

    /**
     * CRM 业务数解锁
     */
    String BUSI_DATA_UNLOCK = "/rest/data/v2.0/xobjects/%s/actions/locks?recordId=%s";

    String BUSI_DATA_DELETE = "/rest/data/v2.0/xobjects/%s/%s";

    /**
     * CRM 删除项目数据
     */
    String DELETE_PROJECT_DATA = "/rest/data/v2.0/xobjects/opportunity/%s";

    /**
     * CRM 删除客户数据
     */
    String DELETE_CUSTOMER_DATA = "/rest/data/v2.0/xobjects/account/%s";
    
    /**
     * CRM 更新项目的信息
     */
    String UPDATE_PROJECT_EFFECTIVE_STATUS = "/rest/data/v2.0/xobjects/opportunity/%s";
}
