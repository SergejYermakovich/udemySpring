package com.udemy.spring.annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    public void initialize(CourseCode constraint) {
        coursePrefix = constraint.value();
    }

    public boolean isValid(String code, ConstraintValidatorContext context) {
        boolean isValid = false;
        if (code != null) {
            isValid = code.startsWith(coursePrefix);
        }
        return isValid;
    }
}
