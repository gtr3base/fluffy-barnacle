package com.hypad.MovieReviewSystem.service;

import com.hypad.MovieReviewSystem.dto.ReviewDTO;
import com.hypad.MovieReviewSystem.models.Review;
import com.hypad.MovieReviewSystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(ReviewDTO reviewDTO){
        Review review = Review
                .builder()
                .movie(reviewDTO.getMovie())
                .user(reviewDTO.getUser())
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .createdAt(LocalDateTime.now())
                .build();
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByMovieId(Long movieId, String sortBy){
        if("rating".equals(sortBy)){
            return reviewRepository.findByMovieIdOrderByRatingDesc(movieId);
        }else{
            return reviewRepository.findByMovieIdOrderByCreatedAtDesc(movieId);
        }
    }
}
