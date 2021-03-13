package com.gmail.kirilllapitsky.deliverycaffee.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WorkerValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterWorkerTypeValidator {
    String message() default "Can`t search for administrator.";
}
