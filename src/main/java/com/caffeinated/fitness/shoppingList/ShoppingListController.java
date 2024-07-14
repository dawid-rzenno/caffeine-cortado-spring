package com.caffeinated.fitness.shoppingList;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
class ShoppingListController {

    private final ShoppingListRepository repository;

    ShoppingListController(ShoppingListRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/shopping-list")
    List<ShoppingList> all() {
        return repository.findAll();
    }

    @PostMapping("/shopping-list")
    ShoppingList newShoppingList(@RequestBody ShoppingList newMeal) {
        return repository.save(newMeal);
    }

    @GetMapping("/shopping-list/{id}")
    ShoppingList one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ShoppingListNotFoundException(id));
    }

    @PutMapping("/shopping-list/{id}")
    ShoppingList replaceShoppingList(@RequestBody ShoppingList newMeal, @PathVariable Long id) {

        return repository.findById(id)
                .map(meal -> {
                    meal.setName(newMeal.getName());
                    return repository.save(meal);
                })
                .orElseGet(() -> {
                    return repository.save(newMeal);
                });
    }

    @DeleteMapping("/shopping-list/{id}")
    void deleteShoppingList(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
