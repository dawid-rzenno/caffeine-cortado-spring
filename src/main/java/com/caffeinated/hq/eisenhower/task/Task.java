package com.caffeinated.hq.eisenhower.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Task {

    private @Id
    @GeneratedValue Long id;
}
