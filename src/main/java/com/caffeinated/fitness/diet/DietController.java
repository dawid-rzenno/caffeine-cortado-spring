package com.caffeinated.fitness.diet;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
class DietController {

    private final DietRepository repository;

    DietController(DietRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/diet")
    List<Diet> all() {
        return repository.findAll();
    }

    @PostMapping("/diet")
    Diet newDiet(@RequestBody Diet newDiet) {
        return repository.save(newDiet);
    }

    @GetMapping("/diet/{id}")
    Diet one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DietNotFoundException(id));
    }

    @PutMapping("/diet/{id}")
    Diet replaceDiet(@RequestBody Diet newDiet, @PathVariable Long id) {

        return repository.findById(id)
                .map(diet -> {
                    diet.setName(newDiet.getName());
                    return repository.save(diet);
                })
                .orElseGet(() -> {
                    return repository.save(newDiet);
                });
    }

    @DeleteMapping("/diet/{id}")
    void deleteDiet(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
