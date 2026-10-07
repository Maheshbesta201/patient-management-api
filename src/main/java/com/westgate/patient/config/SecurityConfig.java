package com.westgate.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // Everyone must authenticate
                .requestMatchers("/api/clinical-records/**")
                .authenticated()

                // Any other request
                .anyRequest()
                .permitAll()
            )

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        UserDetails doctor = User
                .withUsername("doctor")
                .password(passwordEncoder.encode("Doctor@123"))
                .roles("DOCTOR")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("Admin@123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(
                doctor,
                admin
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}