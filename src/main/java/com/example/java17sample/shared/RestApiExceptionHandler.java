package com.example.java17sample.shared;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ErrorResponse constraintViolationException(ConstraintViolationException ex) {

        List<String> errorMessages = ex.getConstraintViolations()
            .stream()
            .map(ConstraintViolation::getMessage)
            .toList();

        return new ErrorResponse(errorMessages);
    }
}
