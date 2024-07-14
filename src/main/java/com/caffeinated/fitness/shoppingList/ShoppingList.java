package com.caffeinated.fitness.shoppingList;

import com.caffeinated.fitness.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class ShoppingList {

    private @Id
    @GeneratedValue Long id;

    private String name;
    private String description;

    // Details
    private Float price;

    @ManyToMany()
    @JoinTable(
            name = "shopping_list_ingredient",
            joinColumns = { @JoinColumn(name = "shopping_list_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> ingredients = new HashSet<>();

    ShoppingList() {}
}
