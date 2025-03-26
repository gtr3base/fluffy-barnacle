package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.details.UserDetailsImpl;

import com.hypad.MovieReviewSystem.service.MovieService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hypad on 21.03.2025
 * @project MovieReviewSystem
 */
@Controller
public class FrontController {
    private final MovieService movieService;

    public FrontController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return movieService.validateMovie(model, id, userDetails);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
