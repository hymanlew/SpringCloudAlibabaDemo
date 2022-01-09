package com.hyman.common.util;

import cn.hutool.core.util.StrUtil;
import com.hyman.common.exception.ValidException;

/**
 * 断言工具类，抛出业务异常，防止报警
 *
 * @author wanghaitong
 * @date 2020/12/15 下午4:07
 */
public class AssertUtil {

    public static void isTrue(boolean expression, String errorMsgTemplate, Object... params) throws ValidException {
        if (!expression) {
            throw new ValidException(StrUtil.format(errorMsgTemplate, params));
        }
    }

    public static void isFalse(boolean expression, String errorMsgTemplate, Object... params) throws ValidException {
        if (expression) {
            throw new ValidException(StrUtil.format(errorMsgTemplate, params));
        }
    }
    
    public static <T> T notNull(T object, String errorMsgTemplate, Object... params) throws ValidException {
        if (object == null) {
            throw new ValidException(StrUtil.format(errorMsgTemplate, params));
        } else {
            return object;
        }
    }
    
    public static <T extends CharSequence> T notBlank(T text, String errorMsgTemplate, Object... params) throws ValidException {
        if (StrUtil.isBlank(text)) {
            throw new ValidException(StrUtil.format(errorMsgTemplate, params));
        } else {
            return text;
        }
    }
}
