package com.hyman.common.annotation;

import com.hyman.common.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * description: Phone <br>
 * date: 2020/7/6 10:53 <br>
 * author: hyman <br>
 */
@Documented
@Constraint(
        validatedBy = {PhoneValidator.class}
)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Phone.List.class)
public @interface Phone {
    String message() default "请输入正确的手机号！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        Phone[] value();
    }
}
