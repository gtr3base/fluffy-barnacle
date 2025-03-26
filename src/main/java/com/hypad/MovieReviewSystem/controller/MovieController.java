package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.dto.MovieDTO;
import com.hypad.MovieReviewSystem.models.Movie;
import com.hypad.MovieReviewSystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody MovieDTO movieDTO){
        return movieService.addMovie(movieDTO);
    }

}
