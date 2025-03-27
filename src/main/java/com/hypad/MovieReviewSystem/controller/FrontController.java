package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.details.UserDetailsImpl;

import com.hypad.MovieReviewSystem.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

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
    public String getMovieById(@PathVariable Long id, Model model){
        return movieService.validateMovie(model, id);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
