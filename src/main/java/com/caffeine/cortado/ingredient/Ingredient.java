package com.caffeine.cortado.ingredient;

import com.caffeine.cortado.nutrient.Nutrient;
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
public class Ingredient {

    private @Id
    @GeneratedValue Long id;

    private String name;

    private Float calories;

    private Float proteins;

    private Float carbohydrates;

    private Float fats;

    private Float price;

    @ManyToMany()
    @JoinTable(
            name = "ingredient_nutrient",
            joinColumns = { @JoinColumn(name = "ingredient_id") },
            inverseJoinColumns = { @JoinColumn(name = "nutrient_id") }
    )
    private Set<Nutrient> meals = new HashSet<>();

    @CreationTimestamp
    private Date createdAt;

    private Long createdBy;

    @UpdateTimestamp
    private Date updatedAt;

    private Long updatedBy;

    Ingredient() {}
}
