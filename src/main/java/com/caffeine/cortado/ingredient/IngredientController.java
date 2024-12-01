package com.caffeine.cortado.ingredient;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
class IngredientController {

    private final IngredientRepository repository;

    IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ingredient")
    Page<Ingredient> all(@Param("name") String name, Pageable p) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Ingredient> example = Example.of(ingredient, matcher);

        return repository.findAll(example, p);
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
