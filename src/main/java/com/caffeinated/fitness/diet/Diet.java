package com.caffeinated.fitness.diet;

import com.caffeinated.fitness.meal.Meal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Diet {

    private @Id
    @GeneratedValue Long id;

    private String name;
    private String description;

    // Details
    private Float price;

    @ManyToMany()
    @JoinTable(
            name = "diet_meal",
            joinColumns = { @JoinColumn(name = "diet_id") },
            inverseJoinColumns = { @JoinColumn(name = "meal_id") }
    )
    private Set<Meal> meals = new HashSet<>();

    Diet() {}
}
