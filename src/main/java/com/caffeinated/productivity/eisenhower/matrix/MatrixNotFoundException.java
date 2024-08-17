package com.caffeinated.productivity.eisenhower.matrix;

public class MatrixNotFoundException extends RuntimeException {

    MatrixNotFoundException(Long id) {
        super("Could not find matrix " + id);
    }
}