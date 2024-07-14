package com.caffeinated.fitness.shoppingList;

public class ShoppingListNotFoundException extends RuntimeException {

    ShoppingListNotFoundException(Long id) {
        super("Could not find shopping list " + id);
    }
}
