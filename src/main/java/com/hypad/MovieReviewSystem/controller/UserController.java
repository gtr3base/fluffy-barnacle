package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.dto.UserDTO;
import com.hypad.MovieReviewSystem.dto.UserRepoDTO;
import com.hypad.MovieReviewSystem.models.User;
import com.hypad.MovieReviewSystem.service.JwtService;
import com.hypad.MovieReviewSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok("User: " + userService.registerUser(userDTO).toString() + " token: " + jwtService.generateToken(userDTO.getUsername()));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.update(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getSpecificUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }
}
