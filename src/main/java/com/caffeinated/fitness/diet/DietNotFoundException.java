package com.caffeinated.fitness.diet;

public class DietNotFoundException extends RuntimeException {

    DietNotFoundException(Long id) {
        super("Could not find diet " + id);
    }
}
