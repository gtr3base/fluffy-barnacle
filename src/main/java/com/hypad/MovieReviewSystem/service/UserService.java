package com.hypad.MovieReviewSystem.service;

import com.hypad.MovieReviewSystem.details.UserDetailsImpl;
import com.hypad.MovieReviewSystem.dto.UserDTO;
import com.hypad.MovieReviewSystem.dto.UserRepoDTO;
import com.hypad.MovieReviewSystem.enums.RoleEnum;
import com.hypad.MovieReviewSystem.models.User;
import com.hypad.MovieReviewSystem.repository.UserRepository;
import com.hypad.MovieReviewSystem.utils.NullAwareBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public User registerUser(UserDTO userDTO){
        User user = User
                .builder()
                .email(userDTO.getEmail())
                .role(RoleEnum.USER_ROLE)
                .password(new BCryptPasswordEncoder().encode(userDTO.getPassword()))
                .reviews(userDTO.getReviews())
                .username(userDTO.getUsername())
                .build();
        return userRepository.save(user);
    }

    public User update(UserDTO userDTO) {
        User exUser = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("No such user while updating"));
        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));

        NullAwareBeanUtils.copyNonNullProps(userDTO, exUser);

        return userRepository.save(exUser);
    }

    public String findById(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("No user with id " + id + " found")).toString()
                + "{reviews counter:" + userRepository.findReviewIdsByUserId(id)
                .stream().map(Object::toString).collect(Collectors.joining()) + "}";
    }
}
