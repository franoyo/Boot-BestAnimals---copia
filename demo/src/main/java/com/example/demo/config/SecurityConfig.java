package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
     public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
        .authorizeHttpRequests(auth -> auth
      .requestMatchers("/auth/**").permitAll().requestMatchers("/index").permitAll().requestMatchers("/user/**").permitAll()
        .anyRequest().authenticated()
        ).formLogin(form->form.permitAll())
        .sessionManagement(sesion->sesion.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).maximumSessions(1))
        .build();
     }
     

    
}
