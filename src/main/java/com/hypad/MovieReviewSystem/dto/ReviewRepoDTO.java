package com.hypad.MovieReviewSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author hypad on 22.03.2025
 * @project MovieReviewSystem
 */
@Getter
@AllArgsConstructor
public class ReviewRepoDTO {
    private Long id;

    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    private String username;

    private String movieTitle;
}
