package com.oxy.customer;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsIdExistsValidator.class)
@Documented
public @interface IsIdExists {
    String message() default "{Id tidak ditemukan}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {
    };
}
