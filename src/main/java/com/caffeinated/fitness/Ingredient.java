package com.caffeinated.fitness;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Ingredient {

    private @Id
    @GeneratedValue Long id;

    private String name;

    // Details
    private Float price;
    private Long category_id;

    // Nutrients
    private Float calories;
    private Float proteins;
    private Float carbohydrates;
    private Float fats;

    Ingredient() {}
}
