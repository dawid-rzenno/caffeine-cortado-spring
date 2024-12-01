package com.caffeine.cortado.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Auth {

  @GetMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
