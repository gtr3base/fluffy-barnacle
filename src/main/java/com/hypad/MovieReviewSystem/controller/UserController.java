package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.dto.UserDTO;
import com.hypad.MovieReviewSystem.models.User;
import com.hypad.MovieReviewSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User registerUser(@RequestBody UserDTO userDTO){
        return userService.registerUser(userDTO);
    }
}
