package com.example.springsecurityjpa.controller;

import com.example.springsecurityjpa.model.Role;
import com.example.springsecurityjpa.model.User;
import com.example.springsecurityjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> login(Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }
}
