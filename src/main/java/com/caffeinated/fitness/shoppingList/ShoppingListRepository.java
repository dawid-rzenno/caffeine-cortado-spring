package com.caffeinated.fitness.shoppingList;

import org.springframework.data.jpa.repository.JpaRepository;

interface ShoppingListRepository extends JpaRepository<com.caffeinated.fitness.shoppingList.ShoppingList, Long> {

}