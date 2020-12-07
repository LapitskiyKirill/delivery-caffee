package com.gmail.kirilllapitsky.deliverycaffee.validation;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkerValidator implements
        ConstraintValidator<WorkerTypeValidator, String> {

    @Override
    public void initialize(WorkerTypeValidator worker) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return !contactField.equals(Role.ADMINISTRATOR.toString());
    }
}
