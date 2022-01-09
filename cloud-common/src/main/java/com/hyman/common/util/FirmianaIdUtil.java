package com.hyman.common.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:
 * @create: 2019-03-15
 * @description: 梧桐编号生成工具类
 **/
@Slf4j
@Component
public class FirmianaIdUtil {

    @Value("${spring.application.name}")
    private String applicationName;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @PostConstruct
    public void setApplicationNameAfterConstruct() {
//        DomainIdPrefixEnum.isIllegale();
        applicationName = StringUtils.substringAfterLast(applicationName, "-");
    }




    /**
     * Id生成器前缀
     * 同一应用内的id前缀应保证唯一性
     */
    @ApiModel("不同实体的id编号前缀")
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum DomainIdPrefixEnum {

        /**
         * 财务流水
         */
        CAIWU("CW"),
        /**
         * 货主线索
         */
        LINECLUE("HX"),
        /**
         * 线路云-项目
         */
        LINEPROJECT("XM"),
        /**
         * 货主
         */
        HUOZHU("HZ"),
        /**
         * 线路
         */
        LINE("XL"),
        /**
         * 标书
         */
        MATCH("BS"),
        /**
         * 线路云-客户
         */
        LINE_CLOUD_CUSTOMER("XS"),
        /**
         * 司机
         */
        DRIVER("SJ"),
        /**
         * 运力
         */
        CARRIER("YL"),
        /**
         * 订单
         */
        ORDER("DD"),

        /**
         * 司机用户
         */
        DRIVER_APPLET_USER("DU"),
        /**
         * 支付
         */
        BILL("ZF"),
        /**
         * 运单
         */
        WAY_BILL("CC"),
        /**
         * 运单金额
         */
        WAY_BILL_AMOUNT("WA"),
        /**
         * 项目周报
         */
        TIME_PROJECT("ZB"),
        /**
         * 梧桐司机账户
         */
        WT_DRIVER_ACCOUNT("WTDA"),
        /**
         * 梧桐司机账户
         */
        WT_DRIVER_ACCOUNT_REFUND("TF"),
        /**
         * 梧桐司机-订单缴费
         */
        WT_DRIVER_ORDER_PAYMENT("WTDOP"),
        /**
         * 梧桐司机账本
         */
        WT_DRIVER_BOOK("WTDB"),
        /**
         * 运费调整
         */
        DRIVER_SHIPPING_CHANGE("TZ"),
        /**
         * 客户运费流水
         */
        CUSTOMER_ACCT_BUSINESS_RECORD("KLS"),
        /**
         * 司机运费流水
         */
        DRIVER_ACCT_BUSINESS_RECORD("LS"),

        /**
         * 司机运费流水
         */
        DRIVER_ACCT_PAY_COST_RECORD("JF"),
        /**
         * 司机月账单
         */
        DRIVER_MONTHLY_BILL("YZD"),
        /**
         * 客户月账单
         */
        CUSTOMER_MONTHLY_BILL("KYZD"),
        /**
         * 司机运费账本
         */
        DRIVER_FREIGHT_CHARGE_ACCT_BOOK("YFZB"),
        /**
         * 客户运费账本
         */
        CUSTOMER_FREIGHT_CHARGE_ACCT_BOOK("KYFZB"),
        /**
         * 司机运费账户
         */
        DRIVER_FREIGHT_CHARGE_ACCT("YFZH"),
        /**
         * 客户运费账户
         */
        CUSTOMER_FREIGHT_CHARGE_ACCT("KYFZH"),
        /**
         * 折叠线路
         */
        FOLD_LINE("ZX"),
        /**
         * 试跑早跑前缀
         */
        RUN_TEST("SP"),

        /**
         * 市场部H5线索
         */
        DRIVER_MARKET_CLUE("SC"),

        /**
         * 客群细分
         */
        USER_GROUP("UG"),

        /**
         * 市场部线索跟进前缀
         */
        MARKET_CLUE_FOLLOW_PRE("FC"),

        /**
         * 司机测-市场部线索-线索重复记录id前缀
         */
        MARKET_CLUE_REPEAT("CFXM"),

        /**
         * 司机测-市场部线索-线索主表clueId前缀
         */
        MARKET_CLUE_INFO_WT("WSX"),
        /**
         * 雷鸟车池
         */
        MARKET_CLUE_INFO_LN_CAR_POOL("LCX"),
        /**
         * 雷鸟租赁B、C
         */
        MARKET_CLUE_INFO_LN_HIRE("LZX"),

        MARKET_CAPMAIGN("CM"),

        /**
         * 赋能打分场次
         */
        SCORE_SESSION("FN"),

        /**
         * 赋能快照
         */
        SCORE_SNAPSHOT("FNKZ"),

        /**
         * 赋能报表
         */
        SCORE_REPORT("FNBB"),


        /**
         * campaign数据统计业务主键
         */
        CAMPAIGN_STATISTICS_ID("CSI"),
        /**
         * 导入任务唯一id
         */
        IMPORT_TASK_ID("ITI"),

        /**
         * 线路待办
         **/
        LINE_SHELF_TO_DO("DB"),
        /**
         * 导入任务唯一id
         */
        LEI_NIAO_USER_ID("LNUI"),

        /**
         * 撮合单ID
         **/
        MATCH_LIST_INFO_ID("CH");

        /**
         * 注意： 同一应用内的id前缀应保证唯一性，否则会出问题
         */
        @NotBlank
        @ApiModelProperty("id前缀")
        private String prefix;


        /**
         * 如果需要校验ID前缀唯一
         * 校验是否合法,前缀不允许重复
         *
         * @return
         */
        public static void isIllegale() {
            boolean b = values().length == Arrays.stream(values()).map(DomainIdPrefixEnum::getPrefix).distinct().count();
            Assert.isTrue(b, "FirmianaIdUtil.DomainIdPrefixEnum[Id前缀有重复，请仔细核对]");
        }

    }


    /**
     * 日期格式
     */
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern(DatePattern.PURE_DATE_PATTERN);

    /**
     * redis key 过期时间
     */
    private static final String ONEDAY = "86401";


    /**
     * 计数开始数字
     */
    private static final String STARTNUM = "1000";


    private static final String NORMAL_STARTNUM = "1";

    /**
     * 司机id 计数 开始数字
     */
    private static final String STARTNUM_DRIVER = "1000";

    //language=LUA
    private static final String SCRIPT =
            "if redis.call('EXISTS', KEYS[1]) == 1\n" +
                    "then\n" +
                    "    return redis.call('INCR', KEYS[1])\n" +
                    "else\n" +
                    "    redis.call('SETEX', KEYS[1], ARGV[1], ARGV[2])\n" +
                    "    return tonumber(ARGV[2])\n" +
                    "end";


    /**
     * 根据项目返回id
     * 举例：  存于redis 中的key  line:id:20190215:77
     * 存于数据库  id 是   2019021577
     *
     * @return
     */
    public String getIDByApplicationName() {

        final String currentDateStr = LocalDate.now().format(format);
        String key = Joiner.on(':').join(applicationName, "id", currentDateStr);

        long num = getIdAndInitFromRedis(Collections.singletonList(key), ONEDAY, STARTNUM);

        return Joiner.on(Strings.EMPTY).join(currentDateStr, num);
    }

    /**
     * id生成
     * 根据不同的城市、时间加自增数值生成id
     * 举例：  存于redis 中的key  driver:id:bjs:20190215:77
     * 存于数据库  id 是   BJS2019021577
     *
     * @return
     */
    public String getIDByCity(String city) {
        final String currentDateStr = LocalDate.now().format(format);

        String key = Joiner.on(":").join(applicationName, "id", city.toLowerCase(), currentDateStr);

        long num = getIdAndInitFromRedis(Collections.singletonList(key), ONEDAY, STARTNUM_DRIVER);

        return Joiner.on(StringUtils.EMPTY).join(city.toUpperCase(), currentDateStr, num);
    }

    /**
     * 存在线程安全问题
     * id生成（指定key，不带字符串前缀）,要注意防止key冲突
     * 根据项目名称、指定key、时间加自增数值生成id
     * 举例：  存于redis 中的key  driver:id:key:20190215:77
     * 存于数据库  id 是   2019021577
     *
     * @return
     */
    public String getIDByKey(String key) {
        final String currentDateStr = LocalDate.now().format(format);

        String redisKey = Joiner.on(":").join(applicationName, "id", key, currentDateStr);

        long num = getIdAndInitFromRedis(Lists.newArrayList(redisKey), ONEDAY, STARTNUM_DRIVER);

        return Joiner.on(StringUtils.EMPTY).join(currentDateStr, num);
    }

    /**
     * id生成（指定key，带指定字符串前缀）
     * 根据项目名称、指定字符串前缀、时间加自增数值生成id
     * 举例：  存于redis 中的key  driver:id:DRIVER:DRIVER20190215:77
     * 存于数据库  id 是   DRIVER2019021577
     *
     * @return
     */
    @Deprecated
    public String getIDByPrefix(String prefix) {
        final String currentDateStr = LocalDate.now().format(format);

        String key = Joiner.on(":").join(applicationName, "id", prefix, currentDateStr);

        long num = getIdAndInitFromRedis(Collections.singletonList(key), ONEDAY, STARTNUM_DRIVER);

        return Joiner.on(StringUtils.EMPTY).join(prefix, currentDateStr, num);
    }

    public String getCustInviteIDByPrefix(String prefix) {
        final String currentDateStr  = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String key = Joiner.on(":").join(applicationName, "id", prefix, currentDateStr);
        long num = getIdAndInitFromRedis(Collections.singletonList(key), ONEDAY, STARTNUM);

        return Joiner.on(StringUtils.EMPTY).join(prefix, currentDateStr, num);
    }

    /**
     * id生成（指定key，带指定字符串前缀）_自定义策率生成ID
     * 根据项目名称、指定字符串前缀、时间加自增数值生成id
     * 举例：  存于redis 中的key  driver:id:DRIVER:DRIVER20190215:77
     * 存于数据库  id 是   DRIVER2019021577
     *
     * @return
     */
    @Deprecated
    public String getIDByPrefixStrategy(String prefix, String strategy) {
        final String currentDateStr = LocalDate.now().format(format);

        String key = Joiner.on(":").join(applicationName, "id", prefix, currentDateStr);
        long num = getIdAndInitFromRedis(Collections.singletonList(key), ONEDAY, strategy);

        return Joiner.on(StringUtils.EMPTY).join(prefix, currentDateStr, num);
    }


    /**
     * 根据指定前缀生成id序列,id序列从0开始
     *
     * @param idPrefixEnum
     * @return
     */
    public String getIDByPrefix(@NotNull DomainIdPrefixEnum idPrefixEnum) {
        final String today = LocalDate.now().format(format);
        String key = Joiner.on(':').join(applicationName, idPrefixEnum.getPrefix(), today);
        long num = getIdAndInitFromRedis(Collections.singletonList(key), ONEDAY, NORMAL_STARTNUM);
        return StrUtil.concat(Boolean.FALSE, idPrefixEnum.getPrefix(), today, StrUtil.fillBefore(Convert.toStr(num), '0', 4));
    }


    /**
     * 设置redis初始id值并获取id
     *
     * @param keys
     * @param args ARGV[1]:过期时间 ARGV[2]:初始值 ARGV[3]: 增长步幅
     * @return
     */
    private long getIdAndInitFromRedis(List<String> keys, Object... args) {
        return stringRedisTemplate.execute(new DefaultRedisScript<Long>(SCRIPT, Long.class), keys, args);
    }


}
