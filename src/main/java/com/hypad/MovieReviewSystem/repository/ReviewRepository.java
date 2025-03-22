package com.hypad.MovieReviewSystem.repository;

import com.hypad.MovieReviewSystem.dto.ReviewRepoDTO;
import com.hypad.MovieReviewSystem.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT new com.hypad.MovieReviewSystem.dto.ReviewRepoDTO(r.id, r.rating, r.comment, r.createdAt, u.username, m.title)" +
            " FROM Review r" +
            " JOIN r.user u" +
            " JOIN r.movie m" +
            " WHERE r.movie.id = :movieId" +
            " ORDER BY r.createdAt DESC")
    List<ReviewRepoDTO> findByMovieIdOrderByCreatedAtDesc(Long movieId);

    @Query("SELECT new com.hypad.MovieReviewSystem.dto.ReviewRepoDTO(r.id, r.rating, r.comment, r.createdAt, u.username, m.title) " +
            "FROM Review r " +
            "JOIN r.user u " +
            "JOIN r.movie m " +
            "WHERE r.movie.id = :movieId " +
            "ORDER BY r.rating DESC")
    List<ReviewRepoDTO> findByMovieIdOrderByRatingDesc(Long movieId);
}
