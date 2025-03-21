package com.hypad.MovieReviewSystem.repository;

import com.hypad.MovieReviewSystem.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieIdOrderByCreatedAtDesc(Long movieId);
    List<Review> findByMovieIdOrderByRatingDesc(Long movieId);
}
