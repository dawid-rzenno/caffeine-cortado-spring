package com.caffeine.cortado.ingredient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IngredientNotFoundAdvice {

    @ExceptionHandler(IngredientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ingredientNotFoundHandler(IngredientNotFoundException ex) {
        return ex.getMessage();
    }
}
