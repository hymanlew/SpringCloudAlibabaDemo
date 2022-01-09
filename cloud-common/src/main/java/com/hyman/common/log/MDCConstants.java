package com.hyman.common.log;

/**
 * @Author: hyman
 * @Date: 2018/6/19 18:20
 * @Description:
 */
public class MDCConstants {
    public static final String REQUEST_ID_HEADER = "X-Request-Id";

    public static final String REQUEST_SEQ_HEADER = "X-Request-Seq";

    public static final String REQUEST_ID_MDC_KEY = "traceId";

    public static final String REQUEST_SEQ_MDC_KEY = "requestSeq";

    //追踪链下发时，使用的seq，由Filter生成，通常开发者不需要修改它。
    public static final String NEXT_REQUEST_SEQ_MDC_KEY = "nextRequestSeq";

    public static final String LOCAL_IP_MDC_KEY = "localIp";

    public static final String SQL = "sql";

    public static final String SQL_COST = "sqlCost";

    public static final String REQUEST_COST = "requestCost";

    public static final String FROM = "form";

    public static final String USER_ID = "userId";

    public static final String APPLICATION_NAME = "applicationName";

    public static final String CLIENT_IP = "clientIp";

    public static final String URI_MDC_KEY = "uri";

    public static final String TIMESTAMP = "_timestamp_";//进入filter的时间戳

    public static final String COOKIE_KEY_PREFIX = "_C_";

    public static final String HEADER_KEY_PREFIX = "_H_";

    public static final String PARAMETER_KEY_PREFIX = "_P_";

    public static final String HEADER_JSON = "headJson";
    public static final String COOKIE_JSON = "cookJson";
    public static final String PARAMETER_JSON = "paramJson";
}
