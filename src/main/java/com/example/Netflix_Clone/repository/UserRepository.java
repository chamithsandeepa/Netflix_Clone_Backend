package com.example.Netflix_Clone.repository;

import com.example.Netflix_Clone.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
