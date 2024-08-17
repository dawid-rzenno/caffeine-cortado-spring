package com.caffeinated.productivity.eisenhower.matrix;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Matrix {

    private @Id
    @GeneratedValue Long id;
}
