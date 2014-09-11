/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = de.ebf.springmvcdemo.validation.CustomEmailValidator.class)
public @interface ValidEmail {

    int min() default 1;
    public String message() default "Invalid Email address";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};    
}
