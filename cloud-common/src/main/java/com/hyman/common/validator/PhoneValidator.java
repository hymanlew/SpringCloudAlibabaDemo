package com.hyman.common.validator;

import com.hyman.common.annotation.Phone;
import com.hyman.common.util.Validator;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * description: PhoneValidator <br>
 * date: 2020/5/11 10:37 <br>
 * author: hyman <br>
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(phone)){
            return true;
        }
        return Validator.isMobile(phone);
    }
}
