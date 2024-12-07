package com.caffeine.cortado.meal;

import com.caffeine.cortado.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "meals")
public class Meal {

    private @Id
    @GeneratedValue Long id;

    private String name;

    private String recipe;

    @ManyToMany()
    @JoinTable(
            name = "meals_ingredients",
            joinColumns = { @JoinColumn(name = "meal_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> ingredients = new HashSet<>();

    @CreationTimestamp
    private Date createdAt;

    private Long createdBy;

    @UpdateTimestamp
    private Date updatedAt;

    private Long updatedBy;

    Meal() {}
}
