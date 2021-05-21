package com.example.annotation;

import com.example.validator.SleepTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {SleepTimeValidator.class})
@Retention(RUNTIME)
@Target(value = {FIELD, PARAMETER, ANNOTATION_TYPE})
public @interface SleepTime {
    String message() default "yyyyMM 형식에 맞지 않습니다";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern() default "yyyyMMdd";
}
