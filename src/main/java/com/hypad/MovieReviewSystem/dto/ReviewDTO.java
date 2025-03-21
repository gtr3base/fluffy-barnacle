package com.hypad.MovieReviewSystem.dto;

import com.hypad.MovieReviewSystem.models.Movie;
import com.hypad.MovieReviewSystem.models.User;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Getter
public class ReviewDTO {
    private Long id;

    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    private User user;

    private Movie movie;
}
