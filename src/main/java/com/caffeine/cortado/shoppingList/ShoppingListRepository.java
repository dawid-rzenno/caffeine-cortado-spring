package com.caffeine.cortado.shoppingList;

import org.springframework.data.jpa.repository.JpaRepository;

interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

}