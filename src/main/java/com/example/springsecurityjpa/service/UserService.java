package com.example.springsecurityjpa.service;

import com.example.springsecurityjpa.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();
}
