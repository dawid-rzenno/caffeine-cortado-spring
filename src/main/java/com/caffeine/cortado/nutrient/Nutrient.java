package com.caffeine.cortado.nutrient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "nutrients")
public class Nutrient {
    private @Id
    @GeneratedValue Long id;

    private String name;

    @CreationTimestamp
    private Date createdAt;

    private Long createdBy;

    @UpdateTimestamp
    private Date updatedAt;

    private Long updatedBy;

    Nutrient() {}
}
