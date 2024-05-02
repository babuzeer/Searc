package com.example.searc.controller;
import com.example.searc.dto.UserLoginDTO;
import com.example.searc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    

    @GetMapping("/login")
    public ResponseEntity<?> showLoginForm() {
        return ResponseEntity.ok("Please login.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        boolean isValidUser = userService.validateUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        
        if (isValidUser) {
            return ResponseEntity.ok("Login successful. Redirecting to home.");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        }
    }
}