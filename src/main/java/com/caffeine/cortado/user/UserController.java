package com.caffeine.cortado.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserRepository repository;

  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @GetMapping("/user/{id}")
  User one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PostMapping("/user/create")
  public User newUser(@RequestBody User newUser) {
    User savedUser = new User();

    savedUser.setUsername(newUser.getUsername());

    savedUser.setPassword(
        passwordEncoder.encode(newUser.getPassword())
    );

    return repository.save(savedUser);
  }
}