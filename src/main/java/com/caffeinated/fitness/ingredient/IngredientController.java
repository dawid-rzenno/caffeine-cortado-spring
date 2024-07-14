package com.caffeinated.fitness.ingredient;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
class IngredientController {

    private final IngredientRepository repository;

    IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ingredient")
    List<Ingredient> all() {
        return repository.findAll();
    }

    @PostMapping("/ingredient")
    Ingredient newIngredient(@RequestBody Ingredient newIngredient) {
        return repository.save(newIngredient);
    }

    @GetMapping("/ingredient/{id}")
    Ingredient one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));
    }

    @PutMapping("/ingredient/{id}")
    Ingredient replaceIngredient(@RequestBody Ingredient newIngredient, @PathVariable Long id) {

        return repository.findById(id)
                .map(ingredient -> {
                    ingredient.setName(newIngredient.getName());
                    return repository.save(ingredient);
                })
                .orElseGet(() -> {
                    return repository.save(newIngredient);
                });
    }

    @DeleteMapping("/ingredient/{id}")
    void deleteIngredient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
