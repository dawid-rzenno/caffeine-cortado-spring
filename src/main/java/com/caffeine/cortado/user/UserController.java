package com.caffeine.cortado.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @PostMapping("/api/v1/user/create")
  public User newUser(@RequestBody User newUser) {
      User savedUser = new User();

      savedUser.setUsername(newUser.getUsername());

      savedUser.setPassword(
          passwordEncoder.encode(newUser.getPassword())
      );

      return userRepository.save(savedUser);
  }
}