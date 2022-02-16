package com.vyacheslavbasovproject.developerapitask.controller.exceptionsHandling;

import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({DeveloperNotFoundException.class})
    public ResponseEntity<?> DeveloperNotFoundExceptionHandler(Exception ex)  {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setError(ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse  ValidationExceptionHandler(ConstraintViolationException ex)  {
        ValidationErrorResponse error = new ValidationErrorResponse();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            error.getViolations().add(
                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return error;
    }

}
