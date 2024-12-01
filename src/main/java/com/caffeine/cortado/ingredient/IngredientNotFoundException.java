package com.caffeine.cortado.ingredient;

public class IngredientNotFoundException extends RuntimeException {

    IngredientNotFoundException(Long id) {
        super("Could not find ingredient " + id);
    }
}
