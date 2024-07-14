package com.caffeinated.fitness.meal;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
class MealController {

    private final MealRepository repository;

    MealController(MealRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/meal")
    List<Meal> all() {
        return repository.findAll();
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
