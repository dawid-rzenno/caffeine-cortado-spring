package com.caffeine.cortado.diet;

import com.caffeine.cortado.meal.Meal;
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
public class Diet {

    private @Id
    @GeneratedValue Long id;

    private String name;

    private Float price;

    @ManyToMany()
    @JoinTable(
            name = "diet_meal",
            joinColumns = { @JoinColumn(name = "diet_id") },
            inverseJoinColumns = { @JoinColumn(name = "meal_id") }
    )
    private Set<Meal> meals = new HashSet<>();

    @CreationTimestamp
    private Date createdAt;

    private Long createdBy;

    @UpdateTimestamp
    private Date updatedAt;

    private Long updatedBy;

    Diet() {}
}
