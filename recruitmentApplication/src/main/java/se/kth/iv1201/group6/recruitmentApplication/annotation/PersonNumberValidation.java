package se.kth.iv1201.group6.recruitmentApplication.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation for validating person numbers
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonNumberValidator.class)
@Documented
public @interface PersonNumberValidation {
    String message() default "Person number invalid: Format must be YYYYMMDDXXXX";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
