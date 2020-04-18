package com.oxy.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class IsIdExistsValidator implements ConstraintValidator<IsIdExists, String> {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return customerDAO.existsById(s);
    }
}
