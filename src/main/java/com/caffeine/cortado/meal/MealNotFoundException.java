package com.caffeine.cortado.meal;

public class MealNotFoundException extends RuntimeException {

    MealNotFoundException(Long id) {
        super("Could not find meal " + id);
    }
}
