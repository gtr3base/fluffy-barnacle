package com.hypad.MovieReviewSystem.repository;

import com.hypad.MovieReviewSystem.models.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    @Query("SELECT u " +
            "FROM User u " +
            "LEFT JOIN FETCH u.reviews " +
            "WHERE u.id = :id")
    @NonNull
    Optional<User> findById(@NonNull Long id); //todo solve User <-> Review <-> Movie <-> Review
}
