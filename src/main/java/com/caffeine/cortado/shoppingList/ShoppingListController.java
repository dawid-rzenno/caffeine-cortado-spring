package com.caffeine.cortado.shoppingList;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
class ShoppingListController {

    private final ShoppingListRepository repository;

    ShoppingListController(ShoppingListRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/shopping-list")
    Page<ShoppingList> all(@Param("name") String name, Pageable p) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<ShoppingList> example = Example.of(shoppingList, matcher);

        return repository.findAll(example, p);
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
