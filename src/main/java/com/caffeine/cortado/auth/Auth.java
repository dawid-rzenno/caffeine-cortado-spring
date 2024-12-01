package com.caffeine.cortado.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.security.config.Customizer.withDefaults;

@RestController
public class Auth {

  @GetMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests(
        (auths) -> auths.anyRequest().authenticated()
    ).httpBasic(withDefaults());

    return http.build();
  }
}
