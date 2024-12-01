package com.caffeine.cortado.meal;

import org.springframework.data.jpa.repository.JpaRepository;

interface MealRepository extends JpaRepository<Meal, Long> {

}