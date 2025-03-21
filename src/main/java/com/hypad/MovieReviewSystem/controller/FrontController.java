package com.hypad.MovieReviewSystem.controller;

import com.hypad.MovieReviewSystem.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hypad on 21.03.2025
 * @project MovieReviewSystem
 */
@Controller
public class FrontController {
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
