package com.hypad.MovieReviewSystem.dto;

import com.hypad.MovieReviewSystem.enums.RoleEnum;
import com.hypad.MovieReviewSystem.models.Review;

import lombok.Getter;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Getter
public class UserDTO {
    private Long id;

    private String username;
    private String password;
    private String email;
    private RoleEnum role;

    private List<Review> reviews;
}
