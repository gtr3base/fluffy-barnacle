package com.hypad.MovieReviewSystem.repository;

import com.hypad.MovieReviewSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
