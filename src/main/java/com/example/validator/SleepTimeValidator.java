package com.example.validator;

import com.example.annotation.SleepTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SleepTimeValidator implements ConstraintValidator<SleepTime, String> {
    private String pattern;

    @Override
    public void initialize(SleepTime constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
