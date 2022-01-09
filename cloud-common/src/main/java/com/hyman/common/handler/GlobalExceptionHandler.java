package com.hyman.common.handler;

import cn.hutool.core.util.StrUtil;
import com.hyman.common.constant.CommonResultConstant;
import com.hyman.common.exception.*;
import com.hyman.common.exception.auth.ClientTokenException;
import com.hyman.common.exception.auth.UserTokenException;
import com.hyman.common.msg.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

import static com.hyman.common.msg.ResultUtils.fail;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
@RestControllerAdvice
@Slf4j(topic = "exception")
public class GlobalExceptionHandler implements EnvironmentAware {

    boolean isDevEnv = false;

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UserTokenException.class)
    public Object userTokenExceptionHandler(UserTokenException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(CommonResultConstant.AUTH_ERROR.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ClientTokenException.class)
    public Object clientTokenExceptionHandler(ClientTokenException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(CommonResultConstant.FORBIDDEN.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ConstraintViolationException.class)
    public Object validExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
//        StringBuffer sb = new StringBuffer();
//        for (ConstraintViolation<?> item : violations) {
//            String msg = item.getPropertyPath().toString() + ":" + item.getMessage();
//            /**打印验证不通过的信息*/
//            sb.append(msg);
//        }
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.warn("{}", ex);
        return fail(425, violations.stream().map(ConstraintViolation::getMessageTemplate).collect(Collectors.joining(" | ")));
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NumberFormatException.class)
    public Object numberFormatExceptionHandler(NumberFormatException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.warn("{}", ex);
        return fail(426, "参数格式错误");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidException.class)
    public Object validExceptionHandler(ValidException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.warn("{}", ex);
        return fail(440, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IgnorableException.class)
    public Object validExceptionHandler(IgnorableException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.info("{}", ex);
        return fail(400, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    public Object validExceptionHandler(BindException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
//        List<ObjectError> errs = ex.getAllErrors();
//        String msg = "Bind Exception : ";
//        for (ObjectError err : errs) {
//            if (err instanceof FieldError) {
//                FieldError fieldError = (FieldError) err;
//                msg += fieldError.getField() + ":" + err.getDefaultMessage() + " :: ";
//            } else {
//                msg += err.getDefaultMessage();
//            }
//        }
        log.warn("{}", ex);
        return fail(450, ex.getMessage());
    }


    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalArgumentException.class)
    public Object IllegalArgumentException(IllegalArgumentException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(427, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalStateException.class)
    public Object IllegalStateException(IllegalStateException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
//        String msg = ex.getMessage();

//        Arrays.stream(els).forEach(e -> log.error("行号={}:类名={}:方法名={}:文件名={}", e.getLineNumber(), e.getClassName(), e.getMethodName(), e.getFileName()));
        log.error("{}", ex);
        return fail(428, ex.getMessage());
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(HttpMessageConversionException.class)
    public Object runtimeException(HttpMessageConversionException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(429, ex.getRootCause().getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    public Object runtimeException(RuntimeException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(505, ex.getMessage());
    }


    /**
     * 空指针异常
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NullPointerException.class)
    public Object nullPointException(NullPointerException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(507, ex.getMessage());
    }

    /**
     * 参数校验异常控制
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object exceptionHandler(MethodArgumentNotValidException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        String errorMessages = ex.getBindingResult().getAllErrors().parallelStream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(StrUtil.COMMA));
        log.warn("接口数据验证异常:[{}]", errorMessages);
        return fail(CommonResultConstant.VILAD_ERROR.getErrorCode(), errorMessages);
    }

    /**
     * Service手动抛出异常控制
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServiceException.class)
    public Object serviceExceptionHandler(ServiceException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(ex.getErrorCode(), ex.getErrorMsg());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(SqlRuntimeException.class)
    public Object sqlRuntimeExceptionHandler(SqlRuntimeException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(510, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ExceptionHandler(InvocationTargetException.class)
    public Object invocationTargetException(InvocationTargetException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.warn("{}", ex);
        return fail(600, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BaseException.class)
    public Object baseExceptionHandler(BaseException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(650, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(Exception.class)
    public Object otherExceptionHandler(Exception ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(660, "系统异常，请稍后再试～");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(Throwable.class)
    public Object throwable(Throwable ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.error("{}", ex);
        return fail(680, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        if (isDevEnv) {
            ex.printStackTrace();
        }
        log.warn("缺少请求参数异常{}", ex.getMessage());
        return fail(670, StrUtil.format("请求参数[{}]缺失", ex.getParameterName()));
    }

    @Override
    public void setEnvironment(Environment environment) {
        String activeProfile = environment.getProperty("spring.cloud.config.profile");
        isDevEnv = StringUtils.equals(activeProfile, "d2");
    }
}
