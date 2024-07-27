package com.caffeinated.fitness.diet;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
    Page<Diet> all(@Param("name") String name, Pageable p) {
        Diet diet = new Diet();
        diet.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Diet> example = Example.of(diet, matcher);

        return repository.findAll(example, p);
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
