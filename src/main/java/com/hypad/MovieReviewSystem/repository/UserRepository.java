package com.hypad.MovieReviewSystem.repository;

import com.hypad.MovieReviewSystem.dto.UserRepoDTO;
import com.hypad.MovieReviewSystem.models.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    @Query("SELECT new com.hypad.MovieReviewSystem.dto.UserRepoDTO(u.id, u.username, u.password, u.role, u.email) FROM User u WHERE u.id = :id")
    @NonNull
    Optional<UserRepoDTO> findUserById(@NonNull Long id);
    @Query("SELECT r.id FROM User u JOIN u.reviews r WHERE u.id = :id")
    @NonNull
    List<Long> findReviewIdsByUserId(@NonNull Long id);  //todo change return type to Review and dont fetch User
}
