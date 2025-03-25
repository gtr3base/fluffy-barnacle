package com.hypad.MovieReviewSystem.dto;

import com.hypad.MovieReviewSystem.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hypad on 23.03.2025
 * @project MovieReviewSystem
 */
@Getter
@Setter
@AllArgsConstructor
public class UserRepoDTO {
    private Long id;
    private String username;
    private String password;
    private RoleEnum role;
    private String email;

    @Override
    public String toString() {
        return "UserRepoDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }
}
