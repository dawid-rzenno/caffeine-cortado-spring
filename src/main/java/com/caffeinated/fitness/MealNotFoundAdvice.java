package com.caffeinated.fitness;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MealNotFoundAdvice {

    @ExceptionHandler(MealNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String mealNotFoundHandler(MealNotFoundException ex) {
        return ex.getMessage();
    }
}
