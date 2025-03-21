package com.hypad.MovieReviewSystem.service;

import com.hypad.MovieReviewSystem.dto.UserDTO;
import com.hypad.MovieReviewSystem.enums.RoleEnum;
import com.hypad.MovieReviewSystem.models.User;
import com.hypad.MovieReviewSystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Service
@Transactional
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(UserDTO userDTO){
        User user = User
                .builder()
                .email(userDTO.getEmail())
                .role(RoleEnum.USER_ROLE)
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .reviews(userDTO.getReviews())
                .username(userDTO.getUsername())
                .build();
        log.info("Saving user with data: " + user.toString());
        return userRepository.save(user);
    }
}
