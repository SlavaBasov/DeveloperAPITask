package com.vyacheslavbasovproject.developerapitask.controller;

import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
