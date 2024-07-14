package com.caffeinated.fitness.diet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DietNotFoundAdvice {

    @ExceptionHandler(DietNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dietNotFoundHandler(DietNotFoundException ex) {
        return ex.getMessage();
    }
}
