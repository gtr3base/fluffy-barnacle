package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.dto.ReviewDTO;
import com.hypad.MovieReviewSystem.dto.ReviewRepoDTO;
import com.hypad.MovieReviewSystem.models.Review;
import com.hypad.MovieReviewSystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @CacheEvict("movieReviews")
    public Review addReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.addReview(reviewDTO);
    }

    @Cacheable("movieReviews")
    @GetMapping("/movie/{movieId}")
    public List<ReviewRepoDTO> getReviewsByMovieId(@PathVariable Long movieId, @RequestParam(required = false) String sortBy){
        return reviewService.getReviewsByMovieId(movieId, sortBy);
    }
}
