package com.hypad.MovieReviewSystem.dto;

import com.hypad.MovieReviewSystem.models.Review;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Getter
public class MovieDTO {
    private Long id;

    private String title;
    private String description;
    private LocalDate releaseDate;
    private String genre;

    private List<Review> reviews;
}
