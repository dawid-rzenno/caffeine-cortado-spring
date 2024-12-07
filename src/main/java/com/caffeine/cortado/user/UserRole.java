package com.caffeine.cortado.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@Entity
public class UserRole {

  private @Id
  @GeneratedValue Long id;

  private String name;

  @CreationTimestamp
  private Date createdAt;

  private Long createdBy;

  @UpdateTimestamp
  private Date updatedAt;

  private Long updatedBy;
}
