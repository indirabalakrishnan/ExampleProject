package com.app.annotations.customAnnotations;

import com.app.annotations.enums.RiskValues;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Risk {
    RiskValues value() default RiskValues.High;
}
