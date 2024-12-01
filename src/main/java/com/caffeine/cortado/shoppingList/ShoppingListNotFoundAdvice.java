package com.caffeine.cortado.shoppingList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShoppingListNotFoundAdvice {

    @ExceptionHandler(ShoppingListNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String shoppingListNotFoundHandler(ShoppingListNotFoundException ex) {
        return ex.getMessage();
    }
}
