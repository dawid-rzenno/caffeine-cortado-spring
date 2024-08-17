package com.caffeinated.hq.eisenhower.matrix;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MatrixNotFoundAdvice {

    @ExceptionHandler(MatrixNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String matrixNotFoundHandler(MatrixNotFoundException ex) {
        return ex.getMessage();
    }
}
