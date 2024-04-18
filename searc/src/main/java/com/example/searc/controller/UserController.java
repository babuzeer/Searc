package com.example.searc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.searc.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isValidUser = userService.validateUser(username, password);
        
        if (isValidUser) {
            return "redirect:/home"; // Redirect to a secured page or home page
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}
