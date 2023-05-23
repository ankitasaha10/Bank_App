package com.example.Bank_App.Controller;

import com.example.Bank_App.Model.User;
import com.example.Bank_App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User existingUser = userRepository.findByUserId(user.getUserId());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("User already exists.");
        }

        userRepository.save(user);
        return ResponseEntity.ok("User created successfully.");
    }
}
