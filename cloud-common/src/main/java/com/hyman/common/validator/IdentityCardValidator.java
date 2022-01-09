package com.hyman.common.validator;

import com.hyman.common.annotation.IdentityCard;
import com.hyman.common.util.Validator;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * description: IdnentityValidator <br>
 * date: 2020/7/6 11:00 <br>
 * author: hyman <br>
 */
public class IdentityCardValidator implements ConstraintValidator<IdentityCard,String> {
    @Override
    public boolean isValid(String idCard, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(idCard)){
            return true;
        }

        return Validator.isIDCard(idCard);
    }
}
