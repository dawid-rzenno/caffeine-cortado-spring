package com.caffeine.cortado.meal;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
class MealController {

    private final MealRepository repository;

    MealController(MealRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/meal")
    Page<Meal> all(@Param("name") String name, Pageable p) {
        Meal meal = new Meal();
        meal.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Meal> example = Example.of(meal, matcher);

        return repository.findAll(example, p);
    }

    @PostMapping("/meal")
    Meal newMeal(@RequestBody Meal newMeal) {
        return repository.save(newMeal);
    }

    @GetMapping("/meal/{id}")
    Meal one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MealNotFoundException(id));
    }

    @PutMapping("/meal/{id}")
    Meal replaceMeal(@RequestBody Meal newMeal, @PathVariable Long id) {

        return repository.findById(id)
                .map(meal -> {
                    meal.setName(newMeal.getName());
                    return repository.save(meal);
                })
                .orElseGet(() -> {
                    return repository.save(newMeal);
                });
    }

    @DeleteMapping("/meal/{id}")
    void deleteMeal(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
