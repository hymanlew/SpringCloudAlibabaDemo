package com.hyman.gate.filter;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.hyman.common.constant.CommonConstants;
import com.hyman.common.enums.TokenTypeEnum;
import com.hyman.common.exception.ServiceException;
import com.hyman.common.jwt.JWTHelper;
import com.hyman.common.log.MDCConstants;
import com.hyman.common.msg.Result;
import com.hyman.common.msg.auth.TokenErrorResponse;
import com.hyman.common.msg.auth.TokenForbiddenResponse;
import com.hyman.gate.feign.IAuthService;
import com.hyman.gate.model.vo.VerificationTokenVo;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.jetbrains.annotations.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hyman.common.constant.CommonConstants.*;
import static com.hyman.common.log.MDCConstants.REQUEST_ID_HEADER;

/**
 * gateway 过滤器用于修改进入的 http 请求和返回的 http 响应，路由过滤器只能指定路由进行使用。gateway 内置了多种路由过滤器，
 * 由 GatewayFilter 工厂类生产。分为前置和后置（pre，post），全局和自定义（GlobalFilter ，GatewayFilter ）。
 *
 * 全局过滤器可用于全局日志记录，统一网关鉴权等等操作。
 */
@Component
@Slf4j
public class AccessGlobalFilter implements GlobalFilter, Ordered {

    // 不校验token的路径
    private Set<String> ignorePathSet, ingoreOpenApis;

    @Resource
    private IAuthService iAuthService;

    @Value("${gate.ignore.startWith:''}")
    private String ingorePaths;

    @Value("${gate.ignore.swagger:''}")
    private String ingoreSwagger;

    @Value("${gate.ignore.openInterface:''}")
    private String ingoreOpenInterface;

    @Value("${gate.prefix}")
    private String gatePrefix;

    @Value("${spring.cloud.config.profile}")
    private String env;

//    @Resource
//    private RedisUtil redisUtil;

    //小程序在换取token之前，会先访问/customer/v1/cust/selectCustList ，网关提示登录换取token
    public static final String FIRST_LOGIN_PAGE = "/customer/v1/cust/selectCustList";

    /**
     * 部分开放接口，简单秘钥比对
     */
    private static final String openInterface = "VO43UhpJf5yZEXMARoSNHVqnsVF6r7fT";

    @PostConstruct
    private void setIgnorePath() {
        ignorePathSet = Stream.concat(Splitter.on(',').splitToStream(ingorePaths), Splitter.on(',').splitToStream(ingoreSwagger)).map(String::trim).collect(Collectors.toSet());
        ingoreOpenApis = Splitter.on(',').splitToStream(ingoreOpenInterface).map(String::trim).collect(Collectors.toSet());
        ingorePaths = ingoreSwagger = ingoreOpenInterface = null; // help GC
    }

//    private boolean roleStatusIsNormal(String authToken) {
//        //获取用户Id
//        Claims infoFromToken = JWTHelper.getInfoFromToken(authToken);
//        String userId = objectToStr(infoFromToken.get(JWT_KEY_USER_ID));// 注意： 用户id有负值的存在
//        String loginFlagRedisKey = String.format("%s%s", RedisKeyEnum.AUTH_USER_LOGIN_FLAG.getKey(), userId);
//        Object uuid = redisUtil.get(loginFlagRedisKey);
//        log.info("uid:",uuid);
//        return Objects.nonNull(uuid);
//    }

    /**
     * 解析token ,目前有如下几种方式
     * 1，小程序 只有手机号的方式，加密得到的token
     * 2, bss 系统，有用户名，密码，加密得到的 token
     * 3. application 登录
     * <p>
     * 这里解析token,判断用户是哪种方式登录进来的。
     *
     * @param authToken
     */
    private String decryptToken(String authToken, ServerWebExchange exchange) {

        Claims infoFromToken = JWTHelper.getInfoFromToken(authToken);
        String tokenType = setHeaderFromToken(infoFromToken, exchange);
        return tokenType;

    }

    /**
     * 解析token中的值，放入header中
     *
     * @param infoFromToken
     * @return
     */
    private String setHeaderFromToken(Claims infoFromToken, ServerWebExchange exchange) {

        String JWT_KEY_PROFILE_TEMP = objectToStr(infoFromToken.get(JWT_KEY_PROFILE));
        String openId = objectToStr(infoFromToken.get(JWT_KEY_OPENID));
        String userId = objectToStr(infoFromToken.get(JWT_KEY_USER_ID));// 注意： 用户id有负值的存在
        String JWT_KEY_USERNAME_TEMP = objectToStr(infoFromToken.get(JWT_KEY_USERNAME));
        String JWT_KEY_PHONE_TEMP = objectToStr(infoFromToken.get(JWT_KEY_PHONE));
        String type = objectToStr(infoFromToken.get(JWT_KEY_TYPE));
        String busiPermission = String.valueOf(infoFromToken.getOrDefault(USER_BUSI_PERMISSION, StringUtils.EMPTY));
        String systemtype = objectToStr(infoFromToken.get(JWT_KEY_SYSTEMTYPE));

        log.info("profile:{},openid:{},userId:{},username:{},phone:{},type:{}",
                JWT_KEY_PROFILE_TEMP, openId, userId, JWT_KEY_USERNAME_TEMP, JWT_KEY_PHONE_TEMP, type);

        if (!StringUtils.equalsAny(env, "d2", JWT_KEY_PROFILE_TEMP)) {
            throw new ServiceException(200, "当前token不适用该环境");
        }

        exchange.getRequest().getHeaders().add(JWT_KEY_OPENID, openId);
        exchange.getRequest().getHeaders().add(JWT_KEY_USER_ID, userId);
        exchange.getRequest().getHeaders().add(JWT_KEY_TYPE, type);
        exchange.getRequest().getHeaders().add(JWT_KEY_PHONE, JWT_KEY_PHONE_TEMP);
        exchange.getRequest().getHeaders().add(JWT_KEY_USERNAME, JWT_KEY_USERNAME_TEMP);
        exchange.getRequest().getHeaders().add(USER_BUSI_PERMISSION, busiPermission);// 0:梧桐专车 1:梧桐共享
        exchange.getRequest().getHeaders().add(JWT_KEY_SYSTEMTYPE,systemtype);//系统标识 1:梧桐系统 3:雷鸟系统


        return type;
    }

    /**
     * 根据类型进行判断
     *
     * @param tokenType
     * @param requestUri
     * @param authToken
     */
    private void judgingByType(String tokenType, String requestUri, String authToken) {

        switch (TokenTypeEnum.getByValue(tokenType)) {
            case APP:
                break;
            case Applets:
                break;
            case BSS:
//                permissionCheck(requestUri, authToken);
                break;
            case WuTongApplets:
                break;
            default:
                break;
        }
    }

    /**
     * 权限校验
     */
    private void permissionCheck(String requestUri, String authToken, ServerWebExchange exchange) {
        //如果是bss的token,进行权限校验
        Result<VerificationTokenVo> verificationTokenVoResult = iAuthService.verificationToken(requestUri, authToken);
        Boolean success = verificationTokenVoResult.getSuccess();

        if (!success) {
            setFailedRequest(exchange, JSON.toJSONString(new TokenErrorResponse("调用接口验证权限失败")), 200);
        }

        VerificationTokenVo verificationToken = verificationTokenVoResult.getData();
        if (!verificationToken.isFlag()) {
            log.warn("url=[{}]无权限，请核对", requestUri);
            setFailedRequest(exchange, JSON.toJSONString(new TokenErrorResponse("当前token权限验证失败，没有调用权限;Token Forbidden")), 200);
        }

    }

    /**
     * object转str
     *
     * @param obj
     * @return     
     */
    public static String objectToStr(@Nullable Object obj) {
        String str = io.jsonwebtoken.lang.Objects.getDisplayString(obj);
//        String str = Objects.toString(obj, StringUtils.EMPTY);
        return Strings.isBlank(str) ? "0" : str;
    }

    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(@NotBlank String requestUri) {
        return !CollectionUtils.isEmpty(ignorePathSet) && (ignorePathSet.contains(requestUri) || ignorePathSet.parallelStream().anyMatch(e -> StringUtils.startsWith(requestUri, e)));

//        boolean flag = false;
//
//        for (String s : ingorePaths.split(",")) {
//            if (requestUri.startsWith(s.trim())) {
//                return true;
//            }
//        }
//
//        for (String s : ingoreSwagger.split(",")) {
//            if (requestUri.startsWith(s.trim())) {
//                return true;
//            }
//        }
//
//        return flag;
    }

    /**
     * 开放接口简单秘钥判断
     *
     * @param requestUri
     * @return
     */
    private boolean openInterfaceJudge(@NotBlank String requestUri, ServerWebExchange exchange) {
        String firmiana = exchange.getRequest().getQueryParams().getFirst("hyman");
        return StringUtils.equals(firmiana, openInterface) && !CollectionUtils.isEmpty(ingoreOpenApis) && (ingoreOpenApis.contains(requestUri) ||
                ingoreOpenApis.parallelStream().anyMatch(e -> StringUtils.startsWith(requestUri, e)));

//        boolean flag = false;
//
//        for (String s : ingoreOpenInterface.split(",")) {
//            if (requestUri.startsWith(s.trim())) {
//                String hyman = request.getParameter("hyman");
//                if (hyman != null && hyman.equals(openInterface)) {
//                    return true;
//                }
//            }
//        }
//        return flag;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ApplicationContext context = exchange.getApplicationContext();
        ServerHttpRequest request = exchange.getRequest();

        // 链路追踪使用
        String uuid = IdUtil.randomUUID();
        request.getHeaders().add(REQUEST_ID_HEADER, uuid);
        MDC.put(MDCConstants.REQUEST_ID_MDC_KEY, uuid);

        String token = request.getQueryParams().getFirst(TOKEN_HEADER);
        String authToken = StringUtils.isBlank(token) ? token : request.getHeaders().getFirst(TOKEN_HEADER);
        //增加cookie
        if(StringUtils.isEmpty(authToken)){
            MultiValueMap<String, HttpCookie> cookies = request.getCookies();
            for (String name : cookies.keySet()) {
                HttpCookie cookie = cookies.getFirst(name);
                if (CommonConstants.TOKEN.equals(cookie.getName())) {
                    authToken = cookie.getValue();
                    break;
                }
            }
        }

        request.getHeaders().add("clientIp", Objects.requireNonNull(request.getRemoteAddress()).getHostString());
        final String requestUri = request.getURI().getPath().substring(gatePrefix.length());
        log.info("requestUri的值是:{}", requestUri);

        if (FIRST_LOGIN_PAGE.equals(requestUri) && StringUtils.isBlank(authToken)) {
            setFailedRequest(exchange, JSON.toJSONString(new TokenForbiddenResponse("please login!")), 200);
            return exchange.getResponse().setComplete();
        }

        // 验证token, 放入header
        String tokenType = StringUtils.EMPTY;
        if (StringUtils.isNotBlank(authToken)) {
            try {
                tokenType = decryptToken(authToken, exchange);
            } catch (Exception e) {
                setFailedRequest(exchange, JSON.toJSONString(new TokenErrorResponse(e.getMessage())), 200);
                return exchange.getResponse().setComplete();
            }
        }

        // 不进行拦截的地址
        if (StringUtils.equals(env, "d2") || isStartWith(requestUri)) {
            log.info("不进行拦截的地址：{}", requestUri);
            return chain.filter(exchange);
        }

        //开放接口简单秘钥判断
        if (openInterfaceJudge(requestUri, exchange)) {
            log.info("开放接口简单秘钥判断 ：{}", requestUri);
            return chain.filter(exchange);
        }

        if (StringUtils.isBlank(authToken)) {
            setFailedRequest(exchange, JSON.toJSONString(new TokenErrorResponse("无权限")), 200);
            return exchange.getResponse().setComplete();
        }

        judgingByType(tokenType, requestUri, authToken);
        //验证权限是否被修改
//        boolean isNormal = false;
//        try {
//            log.info("校验redis tken start...");
//            isNormal = roleStatusIsNormal(authToken);
//            log.info("校验redis tken result:{}",isNormal);
//        } catch (Exception e) {
//            setFailedRequest(JSON.toJSONString(new TokenErrorResponse(e.getMessage())), 200);
//            return null;
//        }
//        if(!isNormal){
//            setFailedRequest(JSON.toJSONString(new TokenErrorResponse(CommonResultConstant.AUTH_ERROR.getErrorMsg())), CommonResultConstant.AUTH_ERROR.getErrorCode());
//            return null;
//        }

        return chain.filter(exchange);
    }

    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(ServerWebExchange exchange, String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        log.warn("非法用户！");

        try {
            HttpServletResponse response = (HttpServletResponse)exchange.getResponse();
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);

            response.setContentType("text/html;charset=UTF-8");
            if (exchange.getRequest().getBody().getPrefetch() == 0) {
                response.getWriter().write(body);
            }
        } catch (IOException ignored) {
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
