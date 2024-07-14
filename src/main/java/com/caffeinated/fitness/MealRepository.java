package com.caffeinated.fitness;

import org.springframework.data.jpa.repository.JpaRepository;

interface MealRepository extends JpaRepository<Meal, Long> {

}