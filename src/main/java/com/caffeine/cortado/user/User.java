package com.caffeine.cortado.user;

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
@Table(name = "users")
public class User {

  private @Id
  @GeneratedValue Long id;

  private String email;

  private String username;

  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_user_role",
      joinColumns = { @JoinColumn(name = "user_id") },
      inverseJoinColumns = { @JoinColumn(name = "user_role_id") }
  )
  private Set<UserRole> roles = new HashSet<>();

  @CreationTimestamp
  private Date createdAt;

  private Long createdBy;

  @UpdateTimestamp
  private Date updatedAt;

  private Long updatedBy;
}
