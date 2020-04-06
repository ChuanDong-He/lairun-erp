package com.lairun.common.valid;

import com.lairun.common.annotation.AdminRoleValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/6
 */
public class AdminRoleValidator implements ConstraintValidator<AdminRoleValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !"admin".equalsIgnoreCase(value);
    }
}
