package com.caffeinated.fitness;

public class IngredientNotFoundException extends RuntimeException {

    IngredientNotFoundException(Long id) {
        super("Could not find ingredient " + id);
    }
}
