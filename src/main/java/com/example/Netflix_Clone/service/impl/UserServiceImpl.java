package com.example.Netflix_Clone.service.impl;

import com.example.Netflix_Clone.model.User;
import com.example.Netflix_Clone.repository.UserRepository;
import com.example.Netflix_Clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());

            return userRepository.save(user); // Save updated user
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
