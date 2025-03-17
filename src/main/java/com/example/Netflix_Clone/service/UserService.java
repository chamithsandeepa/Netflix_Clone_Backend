package com.example.Netflix_Clone.service;

import com.example.Netflix_Clone.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User updateUser(String id, User updatedUser);
    void deleteUser(String id);
}
