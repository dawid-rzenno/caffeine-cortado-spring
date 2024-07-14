package com.caffeinated.fitness.meal;

import org.springframework.data.jpa.repository.JpaRepository;

interface MealRepository extends JpaRepository<Meal, Long> {

}