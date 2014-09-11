/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author jerryamadon
 */
public class CustomEmailValidator implements ConstraintValidator<ValidEmail, String> {
    
    private int min;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        min =  constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cvc) {
        if (email.length() < min || !EmailValidator.getInstance().isValid(email)) {
            return false;
        }
        return true;
    }    
}
