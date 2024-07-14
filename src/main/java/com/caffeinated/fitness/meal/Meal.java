package com.caffeinated.fitness.meal;

import com.caffeinated.fitness.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Meal {

    private @Id
    @GeneratedValue Long id;

    private String name;
    private String description;

    // Details
    private Float price;
    private Integer rating;

    @ManyToMany()
    @JoinTable(
            name = "meal_ingredient",
            joinColumns = { @JoinColumn(name = "meal_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> ingredients = new HashSet<>();

    Meal() {}
}
