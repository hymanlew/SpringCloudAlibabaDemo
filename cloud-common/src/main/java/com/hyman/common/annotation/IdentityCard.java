package com.hyman.common.annotation;

import com.hyman.common.validator.IdentityCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * description: IdentityCard <br>
 * date: 2020/7/6 11:02 <br>
 * author: hyman <br>
 */
@Documented
@Constraint(
        validatedBy = {IdentityCardValidator.class}
)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(IdentityCard.List.class)
public @interface IdentityCard {
    String message() default "请输入正确的身份证号！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        IdentityCard[] value();
    }
}
