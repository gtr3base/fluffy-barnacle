package com.hypad.MovieReviewSystem.configuration;

import com.hypad.MovieReviewSystem.details.UserDetailsServiceImpl;
import com.hypad.MovieReviewSystem.filters.JwtAuthFilter;
import com.hypad.MovieReviewSystem.service.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hypad on 22.03.2025
 * @project MovieReviewSystem
 */
@Configuration
public class JwtConfig {
    @Bean
    public JwtAuthFilter jwtAuthFilter(UserDetailsServiceImpl userDetailsService, JwtService jwtService){
        return new JwtAuthFilter(userDetailsService, jwtService);
    }
}
