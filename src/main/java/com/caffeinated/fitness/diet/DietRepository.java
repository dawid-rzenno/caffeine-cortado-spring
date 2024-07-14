package com.caffeinated.fitness.diet;

import org.springframework.data.jpa.repository.JpaRepository;

interface DietRepository extends JpaRepository<Diet, Long> {

}